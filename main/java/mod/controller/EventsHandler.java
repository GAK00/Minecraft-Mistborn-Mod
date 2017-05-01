package mod.controller;

import mod.model.powers.Players;
import mod.model.powers.PoweredPlayer;
import mod.model.tools.FileHandler;
import mod.view.gui.PowerOverlay;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventsHandler
{
	private int saveTick;

	public EventsHandler(Object[] toRegister)
	{
		for (Object object : toRegister)
		{
			MinecraftForge.EVENT_BUS.register(object);
		}
		MinecraftForge.EVENT_BUS.register(this);
		saveTick = 0;
	}

	public EventsHandler()
	{
		MinecraftForge.EVENT_BUS.register(this);
		saveTick = 0;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void setupNewPlayer(PlayerLoggedInEvent loggedIn)
	{
		if (!loggedIn.player.world.isRemote)
		{
			Players.addPlayer(loggedIn.player);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void removePlayer(PlayerLoggedOutEvent loggedOut)
	{
		if (!loggedOut.player.world.isRemote)
		{
			try
			{
				Players.getPlayer(loggedOut.player).save(null);
			} catch (Exception e)
			{

				e.printStackTrace();
			}
			;
			Players.removePlayer(loggedOut.player.getUniqueID());
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void clientRemovePlayer(ClientDisconnectionFromServerEvent loggedOut)
	{
		Players.reset();
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public void backupSave(ServerTickEvent tick)
	{
		if (saveTick >= 6000)
		{
			for (PoweredPlayer player : Players.getPlayers())
			{
				if (!player.world.isRemote)
				{
					player.save(null);
				}
			}
		} else
		{
			saveTick++;
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void drawOverlay(RenderGameOverlayEvent.Post event)
	{
		if (event.getType() != ElementType.EXPERIENCE)
			return;
		new PowerOverlay();

	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void setFileLocation(WorldEvent.Load WorldLoad)
	{
		if (!WorldLoad.getWorld().isRemote)
		{
			FileHandler.setSubDirectory(WorldLoad.getWorld().getSaveHandler().getWorldDirectory().getName());
		}
	}
}
