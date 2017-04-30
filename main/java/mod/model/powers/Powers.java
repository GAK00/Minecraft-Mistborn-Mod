package mod.model.powers;

import java.util.ArrayList;
import java.util.List;

import mod.model.powers.metals.Metal;
import mod.model.powers.metals.Metals;
import mod.model.tools.NetworkHandler;
import mod.model.tools.OverlaySync;
import mod.model.tools.PlayerData;
import net.minecraft.client.Minecraft;

public class Powers
{
	private ArrayList<Metal> useableAllomanticMetals;
	private int activePower;
	private PoweredPlayer player;
	private PlayerData save;

	public Powers(PoweredPlayer player)
	{
		this.save = player.getSave();
		this.player = player;
		this.useableAllomanticMetals = new ArrayList<Metal>();
		activePower = 0;
		System.out.println("adding group");
		save.createGroup("AllomanticMetals");
		List<String> savedPowers = save.getGroup("AllomanticMetals");
		ArrayList<Integer> ids = new ArrayList<Integer>();
		if (savedPowers != null)
		{
			for (int index = 0; index < savedPowers.size(); index += 2)
			{
				if (save.toInteger(savedPowers.get(index + 1)) == 1)
				{
					ids.add(save.toInteger(savedPowers.get(index).substring(0, 1)));
				}
			}
		} else
		{
			System.out.println("asdfasdfasdfasdfasdf");
		}
		Integer[] a = new Integer[ids.size()];
		setupAllomancy(ids.toArray(a));
		sync();
	}

	public Powers(ArrayList<Integer> ids)
	{
		this.activePower = 0;
		try
		{
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		useableAllomanticMetals = new ArrayList<Metal>();
		setupAllomancy(ids.toArray(new Integer[0]));

	}

	private void setupAllomancy(Integer[] ids)
	{
		System.out.println("reading");
		for (int id : ids)
		{
			if (id > 0 && id < 11)
			{
				System.out.println(ids[0]);
				Metal metal = Metals.getMetal(id);
				boolean isContained = false;
				for (Metal containedMetal : useableAllomanticMetals)
				{
					if (containedMetal.getId() == metal.getId())
					{
						isContained = true;
					}
				}
				if (!isContained)
				{
					useableAllomanticMetals.add(metal);
				}
			}
		}
		for (Metal metal : useableAllomanticMetals)
		{
			System.out.println(metal.getName());
		}
	}

	public void add(Integer id)
	{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for (Metal metal : useableAllomanticMetals)
		{
			ids.add(metal.getId());
		}
		if (!ids.contains(id))
		{
			useableAllomanticMetals.add(Metals.getMetal(id));
		}
		sync();
	}

	public void remove(Integer id)
	{
		Metal toRemove = Metals.getMetal(id);
		useableAllomanticMetals.remove(toRemove);
		save.saveToGroup(Integer.toString(id), "0", "AllomanticMetals");
		sync();
	}

	public void toggleActive()
	{
		if (useableAllomanticMetals.size() > 0)
		{
			if (activePower < useableAllomanticMetals.size() - 1)
			{
				activePower++;
			} else
			{
				activePower = 0;
			}
		}
	}

	public ArrayList<Metal> getCurrentMetals()
	{
		return useableAllomanticMetals;
	}

	public void save()
	{
		System.out.println("Saving");
		;
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<String> validate = new ArrayList<String>();
		for (Metal metal : useableAllomanticMetals)
		{
			System.out.println("saving");
			validate.add("1");
			ids.add(Integer.toString(metal.getId()));
		}
		if(ids!=null&&ids.size()>0){
		save
		.addToGroup(ids.toArray(new String[0]), validate.toArray(new String[0]), "AllomanticMetals");}
	}

	private void sync()
	{
		if (!this.player.world.isRemote)
		{
			ArrayList<Integer> ids = new ArrayList<Integer>();
			for (Metal metal : useableAllomanticMetals)
			{
				ids.add(metal.getId());
			}
			System.out.println("sync");
			OverlaySync sync = new OverlaySync(ids);
			NetworkHandler.sendTo(sync, player.getEntityWorld().getPlayerEntityByUUID(player.getUniqueID()));
		}
	}
}
