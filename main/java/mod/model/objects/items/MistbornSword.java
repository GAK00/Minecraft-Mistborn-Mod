package mod.model.objects.items;

import mod.model.objects.tabs.Tabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class MistbornSword extends ItemSword
{

	public MistbornSword(String name, int tab, ToolMaterial mat)
	{
		super(mat);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		if (tab == 1)
		{
			this.setCreativeTab(CreativeTabs.MISC);
		}

		else if (tab == 2)
		{
			this.setCreativeTab(CreativeTabs.BREWING);
		}

		else if (tab == 3)
		{
			this.setCreativeTab(CreativeTabs.COMBAT);
		}

		else if (tab == 4)
		{
			this.setCreativeTab(CreativeTabs.DECORATIONS);
		}

		else if (tab == 5)
		{
			this.setCreativeTab(CreativeTabs.FOOD);
		}

		else if (tab == 6)
		{
			this.setCreativeTab(CreativeTabs.MATERIALS);
		}

		else if (tab == 7)
		{
			this.setCreativeTab(CreativeTabs.REDSTONE);
		}

		else if (tab == 8)
		{
			this.setCreativeTab(CreativeTabs.TOOLS);
		}

		else if (tab == 9)
		{
			this.setCreativeTab(CreativeTabs.TRANSPORTATION);
		}

		else if (tab == 10)
		{
			this.setCreativeTab(Tabs.MistbornTab);
		}
	}
}
