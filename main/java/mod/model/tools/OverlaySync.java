package mod.model.tools;

import java.util.ArrayList;

import io.netty.buffer.ByteBuf;
import mod.model.powers.Players;
import mod.model.powers.Powers;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class OverlaySync extends MessageBase<OverlaySync>
{
	private  ArrayList<Integer> ids;
	private int size;
	public OverlaySync()
	{
		size =0;
		ids = new ArrayList<Integer>();
	}
	public OverlaySync(ArrayList<Integer> ids)
	{
		this.ids = ids;
		this.size = ids.size();
	}
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.size = buf.readInt();
		System.out.println("Pay attention to this: " + size);
		for(int index = 0; index<this.size; index++)
		{
			System.out.println("index" +index);
			int value = buf.readInt();
			System.out.println("value" + value);
			ids.add(value);
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(size);
		for(int index =0; index<size; index++)
		{
			buf.writeInt(ids.get(index));
		}
		
	}

	@Override
	public void handleClientSide(OverlaySync message, EntityPlayer player)
	{
		System.out.println("if this is null then bad: " + message.ids.size());
		if(message.ids.size()>0)
		{
			System.out.println("value on this end: " + message.ids.get(0));
		}
		try
		{Players.singleInit(message.ids);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void handleSeverSide(OverlaySync message, EntityPlayer player)
	{
		
	}

}
