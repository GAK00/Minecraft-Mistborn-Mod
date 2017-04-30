package mod.model.powers.metals;

import java.util.ArrayList;

public class Metals
{
	private static ArrayList<Metal> metals = new ArrayList<Metal>();

	protected static void addMetal(Metal metal)
	{
		metals.add(metal);
	}

	public static Metal getMetal(int id)
	{
		Metal metal = null;
		for (int index = 0; index < metals.size(); index++)
		{
			if (metals.get(index).getId() == id)
			{
				metal = metals.get(index);
			}
		}
		try
		{
			return metal.getClass().newInstance();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static Metal getMetal(String name)
	{
		return getMetal(getId(name));
	}

	public static int getId(String name)
	{
		int id = -1;
		for (int index = 0; index < metals.size(); index++)
		{
			if (name.equalsIgnoreCase(metals.get(index).getName()))
			{
					id = metals.get(index).getId();
			}
		}
		return id;
	}
	public static void init()
	{
			metals.add(new Brass());
			metals.add(new Bronze());
			metals.add(new Copper());
			metals.add(new Iron());
			metals.add(new Pewter());
			metals.add(new Steel());
			metals.add(new Tin());
			metals.add(new Zinc());
	}
}
