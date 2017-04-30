package mod.view.gui;

import net.minecraft.client.gui.GuiScreen;

public abstract class Gui extends GuiScreen
{
		private static boolean typeOpen;
		public Gui()
		{
			super();
			typeOpen = true;
		}
		public void close()
		{
			typeOpen = false;
			this.mc.displayGuiScreen(null);
			this.onGuiClosed();
		}
		@Override
	    public void onGuiClosed()
	    {
			typeOpen = false;
	    }
		public static boolean isTypeOpen()
		{
			return typeOpen;
		}
}
