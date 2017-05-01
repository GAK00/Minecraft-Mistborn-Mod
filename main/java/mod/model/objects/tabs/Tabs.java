package mod.model.objects.tabs;

import net.minecraft.creativetab.CreativeTabs;

public class Tabs
{
	public static CreativeTabs MistbornTab;

	public static void ini()
	{
		MistbornTab = new MistbornTab(CreativeTabs.getNextID(), "MistbornTab");
	}
}
