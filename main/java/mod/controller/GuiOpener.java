package mod.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import mod.model.tools.HandleGui;
import mod.model.tools.NetworkHandler;
import mod.view.gui.Gui;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class GuiOpener
{
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<Class<Gui>> screens = new ArrayList<Class<Gui>>();

	public static void addGui(Class screen, String name)
	{
		names.add(name.toLowerCase());
		screens.add(screen);
	}

	public static void openGui(EntityPlayer player, String name) throws Exception
	{
		if (names.contains(name.toLowerCase()))
		{
			NetworkHandler.sendTo(new HandleGui(names.indexOf(name.toLowerCase())), player);
		} else
		{
			throw new Exception("Gui unregistered");
		}
	}

	public static void displayGui(int guiId)
	{
			try
			{
				Method m = screens.get(guiId).getMethod("isTypeOpen");
				boolean isOpen = (Boolean) m.invoke(null);
				if(!isOpen){
				Minecraft.getMinecraft().displayGuiScreen(screens.get(guiId).newInstance());}
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				e.printStackTrace();
			} catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			} catch (SecurityException e)
			{
				e.printStackTrace();
			}
	}
}
