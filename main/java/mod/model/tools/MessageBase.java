package mod.model.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>
{

	@Override
	public REQ onMessage(REQ message, MessageContext ctx)
	{
		if (ctx.side == Side.SERVER)
		{
			handleSeverSide(message, ctx.getServerHandler().playerEntity);
		} else
		{
			handleClientSide(message, Minecraft.getMinecraft().player);
		}
		return null;
	}

	public abstract void handleClientSide(REQ message, EntityPlayer player);

	public abstract void handleSeverSide(REQ message, EntityPlayer player);

}
