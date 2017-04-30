package mod.model.powers;

import mod.controller.GuiOpener;
import mod.model.powers.metals.Metal;
import mod.model.powers.metals.Metals;
import mod.model.tools.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PoweredPlayer extends EntityPlayer
{
	private EntityPlayer basePlayer;
	private PlayerData save;
	private Powers powers;
	private boolean canSnap;

	public PoweredPlayer(EntityPlayer basePlayer)
	{
		super(basePlayer.getEntityWorld(), basePlayer.getGameProfile());
		save = new PlayerData(basePlayer);
		save.createGroup("Allomancy");
		save.addToGroup(new String[] { "CanSnap", "PowerLevel" }, new String[] { "1", "0" }, "Allomancy");
		powers = new Powers(this);
		canSnap = save.toBool(save.getFromGroup("CanSnap", "Allomancy"));
		this.basePlayer = basePlayer;
	}



	public void setMetal(int metalId)
	{
		if (metalId != 0 && !this.world.isRemote)
		{
			System.out.println("snap");
			powers.add(metalId);
			canSnap = false;
			save.saveToGroup("CanSnap", "0", "Allomancy");
		}
	}

	@Override
	public boolean isSpectator()
	{
		return basePlayer.isSpectator();
	}

	@Override
	public boolean isCreative()
	{
		return basePlayer.isCreative();
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void snap(LivingHurtEvent livingHurt)
	{
		if (livingHurt.getEntityLiving().equals(basePlayer) && canSnap && Float.compare(livingHurt.getEntityLiving().getHealth(), 8f) <= 0)
		{
			try
			{
				GuiOpener.openGui(basePlayer, "snapgui");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public PlayerData getSave()
	{
		return save;
	}
	public EntityPlayer getBasePlayer()
	{
		return basePlayer;
	}
	@SubscribeEvent
	public void save(PlayerEvent.SaveToFile save)
	{
		if (!super.world.isRemote&&powers!= null&&save!=null)
		{
			powers.save();
		}
	}
	public void setPowers(Powers powers)
	{
		this.powers = powers;
	}
	public Powers getPowers()
	{
		return powers;
	}
}
