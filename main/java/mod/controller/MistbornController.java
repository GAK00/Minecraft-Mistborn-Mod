package mod.controller;

import org.apache.logging.log4j.Logger;

import mod.model.objects.items.MistbornItems;
import mod.model.objects.tabs.Tabs;
import mod.model.powers.metals.Metals;
import mod.model.tools.FileHandler;
import mod.model.tools.NetworkHandler;
import mod.view.gui.SnappedGui;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Reference.NAME, modid = Reference.ID, version = Reference.VERSION)
public class MistbornController
{
	@Instance(Reference.ID)
	private MistbornController instance;
	private Logger logger;
	private EventsHandler events;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = FMLLog.getLogger();
		try
		{
			FileHandler.init();
		}
		catch(Exception e)
		{
			logger.info("critical error could not initialize filehandler");
			FMLCommonHandler.instance().exitJava(0, false);
		}
		
		NetworkHandler.init();
		Metals.init();
		GuiOpener.addGui(SnappedGui.class, "snapgui");
		logger.info("preInit");
	
	}
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		logger.info("Init");
		Tabs.ini();
		MistbornItems.initItems();
		events = new EventsHandler();
	}
	@EventHandler
	public void postIninit(FMLPostInitializationEvent event)
	{
		logger.info("postInit");
	}

}
