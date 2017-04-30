package mod.model.tools;

import mod.controller.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler
{

	private static SimpleNetworkWrapper INSTANCE;

	public static void init()
	{
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.ID);
		INSTANCE.registerMessage(HandleGui.class, HandleGui.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(HandleGui.class, HandleGui.class, 1, Side.SERVER);
		INSTANCE.registerMessage(OverlaySync.class, OverlaySync.class,2,Side.CLIENT);
	}

	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}

	public static void sendTo(IMessage message, EntityPlayer playerSp)
	{
		EntityPlayerMP player = (EntityPlayerMP) playerSp;
		INSTANCE.sendTo(message, player);
	}

	public static void sendToAllAround(IMessage message, TargetPoint point)
	{
		INSTANCE.sendToAllAround(message, point);
	}
}
