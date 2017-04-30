package mod.model.powers;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class Players
{
	private static ArrayList<PoweredPlayer> players = new ArrayList<PoweredPlayer>();
	private static Powers singlePowers;
	public static ArrayList<PoweredPlayer> getPlayers()
	{
		return players;
	}
	public static void addPlayer(EntityPlayer player)
	{

		System.out.println("Mistorn Mod recoginzed and is handling player: " + player.getName());
		PoweredPlayer poweredPlayer = new PoweredPlayer(player);
		MinecraftForge.EVENT_BUS.register(poweredPlayer);
		players.add(poweredPlayer);
	}
	public static void addPlayer(PoweredPlayer player)
	{
		MinecraftForge.EVENT_BUS.register(player);
		players.add(player);
	}
	public static PoweredPlayer getPlayer(EntityPlayer player) throws Exception
	{
		for (PoweredPlayer pPlayer : players)
		{
			if (pPlayer.getUniqueID().equals(player.getUniqueID()))
			{
				return pPlayer;
			}
		}
		throw new Exception("Player does not exist");
	}
	public static void removePlayer(UUID id)
	{
		for(int index =0; index<players.size(); index++)
		{
			if(players.get(index).getUniqueID().compareTo(id)==0)
			{
				MinecraftForge.EVENT_BUS.unregister(players.remove(index));
				index--;
			}
		}
	}
	public static void singleInit(ArrayList<Integer> ids)
	{
		singlePowers = new Powers(ids);
		System.out.println("new Power: " + singlePowers);
	}
	public static Powers getSinglePowers()
	{
		return singlePowers;
	}
}
