package mod.view.gui;

import java.util.ArrayList;

import javax.swing.plaf.metal.MetalSliderUI;

import mod.controller.Reference;
import mod.model.powers.Players;
import mod.model.powers.Powers;
import mod.model.powers.metals.Metal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class PowerOverlay extends net.minecraft.client.gui.Gui
{
	private ScaledResolution scaled;
	private Minecraft mc;
	private Powers powers;
	public PowerOverlay()
	{
		mc = Minecraft.getMinecraft();
		scaled = new ScaledResolution(mc);
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.ID + ":gui/overlay.png"));
		try
		{
		this.powers = Players.getSinglePowers();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		drawAllomantic();
	}

	private void drawAllomantic()
	{
		if(powers!=null)
		{
			ArrayList<Metal> metals = powers.getCurrentMetals();
			int width = 20;
			int height = 51;
			for(int index =0; index<metals.size(); index++)
			{
				this.drawTexturedModalRect((index*(width+5)),0, 0, 0, width+1, height+1);
				
			}
			for(int index =0; index<metals.size(); index++)
			{
			for(int letter =0; letter<metals.get(index).getName().length()&&letter<4; letter++)
			{
				this.drawString(mc.fontRendererObj, metals.get(index).getName().substring(letter, letter+1), index*(width+5)+width/2, 2+(10*letter), metals.get(index).getColor());
			}}
		}
	}
}
