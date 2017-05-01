package mod.model.objects.items;

import com.google.common.collect.Sets;

import mod.model.objects.tabs.Tabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemTool;

public class MistbornAxe extends ItemTool
{

	protected MistbornAxe(String name, int tab, ToolMaterial material)
	{
		super(material, Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE}));
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
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
