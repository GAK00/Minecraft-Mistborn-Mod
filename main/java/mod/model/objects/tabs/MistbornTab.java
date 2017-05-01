package mod.model.objects.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MistbornTab extends CreativeTabs
{

	public MistbornTab(int id, String name)
	{
		super(id, name);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem()
	{

		return new ItemStack(Items.IRON_SWORD);
	}

}
