package mod.model.tools;

import io.netty.buffer.ByteBuf;
import mod.controller.GuiOpener;
import mod.model.powers.Players;
import net.minecraft.entity.player.EntityPlayer;

public class HandleGui extends MessageBase<HandleGui>
{
	private int guiId;
	private int returnedData;

	public HandleGui()
	{
		guiId = 0;
	}

	public HandleGui(int guiId)
	{
		this.guiId = guiId;
		this.returnedData = 0;
	}

	public HandleGui(int guiId, int returnedData)
	{
		this.guiId = guiId;
		this.returnedData = returnedData;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		guiId = buf.readInt();
		returnedData = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(guiId);
		buf.writeInt(returnedData);
	}

	@Override
	public void handleClientSide(HandleGui message, EntityPlayer player)
	{
		GuiOpener.displayGui(message.guiId);
	}

	@Override
	public void handleSeverSide(HandleGui message, EntityPlayer player)
	{
		switch (message.guiId)
		{
		case 1:
			try
			{
				System.out.println(Players.getPlayer(player));
				System.out.println(message.returnedData);
				Players.getPlayer(player)
				.setMetal(message.returnedData);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
	}
}
