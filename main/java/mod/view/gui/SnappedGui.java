package mod.view.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import mod.controller.Reference;
import mod.model.tools.HandleGui;
import mod.model.tools.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SnappedGui extends Gui
{
	private int guiHeight;;
	private int guiWidth;
	private int guiY;
	private int guiX;
	private boolean[] metalClicked;
	private String[] metalName;
	private String[] metalDescription;
	private int[] color;
	private int tabX;
	private int currentHeight;
	private int currentWidth;
	boolean randPressed;
	boolean onExitScreen;
	private GuiButton Continue;
	private GuiButton Random;
	private GuiButton Finish;
	private GuiButton Return;

	public SnappedGui()
	{
		super();
		randPressed = false;
		onExitScreen = false;
		currentHeight = height;
		currentWidth = width;
		guiHeight = 199;
		guiWidth = 199;
		tabX = guiX + 15;
		guiY = (height - guiHeight) / 2;
		guiX = (width - guiWidth) / 2;
		metalClicked = new boolean[11];
		metalName = new String[] { "Steel", "Zinc", "Pewter", "Copper", "Iron", "Bronze", "Tin", "Brass", "Atium", "Gold", "Mistborn", };
		color = new int[] { 0x545454, 0xA6A6A6, 0x1D1D1D, 0xFFB27F, 0x969696, 0xBB9E60, 0xCCD5D4, 0xFFD67F, 0x00CC17, 0xFFFF0B, 0xC16E64 };
		metalDescription = new String[] { "Steel is an alloy of Iron. When burned it allows the user to push against metal objects with there mind. propelling that object in the opposite direction unless the object is heavier than the user in wich case the user is propelled away from the object", "Zinc is not an alloy. When burned it allows the user to riot other peoples emotions making them stronger. ",
				"Pewter is an alloy of lead and tin. When burned it gives the user exterme strength, resistance and durability", "Copper is not an alloy. When burned it allows the user to hide there allomancy from bronze burners as well as protect them from emotional allomancy", "Iron is not an alloy. When burned it allows the user to pull on metal objects with ther mind. propelling that object to them. if the object is heavier then the user the user will be pulled to the object",
				"Bronze is an alloy of copper. When burned it allows the user to detect others using allomancy and to detect what type they are using", "Tin is not an alloy. When burned the user gain heightened senses including better hearing and eyesight", "Brass is an alloy of Zinc. When burned it allows the user to sooth others emotions making them calmer and more subdued",
				"Atium is not an alloy. When burned the user gains the ability to see slightly into others futures giving them a godly advatage in battles", "Gold is not an alloy. When burned the user gains the ability to see an alternate version of themselves not useful but fun", "Mistborns have the ability to burn any metal they please" };

	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int x, int y, float ticks)
	{
		if (currentHeight != height || currentWidth != width)
		{
			currentHeight = height;
			currentWidth = width;
			guiY = (height - guiHeight) / 2;
			guiX = (width - guiWidth) / 2;
			tabX = guiX + 15;
		}

		GL11.glColor4f(1, 1, 1, 1);
		this.drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.ID + ":gui/snapped.png"));
		if (!randPressed && !onExitScreen)
		{
			drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
			int currentX = 0;
			int currentY = 0;
			for (int counter = 0; counter < 8; counter++)
			{
				currentX = 220;
				if (counter < 4)
				{
					currentX = 200;
				}
				if (counter == 4)
				{
					currentY = 0;
				}
				if (metalClicked[counter])
				{
					drawTexturedModalRect(tabX, guiY + 7 + (22 * counter), 200, 80, 20, 20);
				} else
				{
					this.drawTexturedModalRect(tabX, guiY + 7 + (22 * counter), currentX, currentY * 20, 20, 20);
				}
				currentY++;
			}

		} else
		{
			drawTexturedModalRect(guiX + 40, guiY, 40, 0, guiWidth - 40, guiHeight);
		}
		if (!onExitScreen)
		{
			Finish.drawButton(Minecraft.getMinecraft(), x, y);
			Random.drawButton(Minecraft.getMinecraft(), x, y);
			boolean hasBeenClicked = false;
			for (int index = 0; index < metalClicked.length; index++)
			{
				if (metalClicked[index])
				{
					hasBeenClicked = true;
					fontRendererObj.drawString(metalName[index], guiX + 45, guiY + 5, color[index]);
					fontRendererObj.drawSplitString(metalDescription[index], guiX + 45, guiY + 15, guiWidth - 50, 0x000000);
				}
			}

			if (!hasBeenClicked)
			{
				fontRendererObj.drawString("You Snapped", guiX + 45, guiY + 5, 0xD49090);
				fontRendererObj.drawSplitString("Congratulations you have snapped, unlocking your abilities as a misting please use this menu to select the metal that you wish to burn. By clicking through the tabs you may read the respective abilities of each metal", guiX + 45, guiY + 15, guiWidth - 50, 0x00000);
			}
		} else
		{
			Return.drawButton(Minecraft.getMinecraft(), x, y);
			Continue.drawButton(Minecraft.getMinecraft(), x, y);
			int selectedIndex = -1;
			String metal = "None";
			for (int index = 0; index < metalClicked.length; index++)
			{
				if (metalClicked[index])
				{
					selectedIndex = index;
				}
			}
			if (selectedIndex != -1)
			{
				metal = metalName[selectedIndex];
			}
			fontRendererObj.drawString("Continue?", guiX + 45, guiY + 5, 0x00000);
			fontRendererObj.drawSplitString("You have chosen: " + metal + ", do you wish to continue?", guiX + 45, guiY + 15, guiWidth - 50, 0x00000);
		}

	}

	@Override
	protected void mouseClicked(int x, int y, int button)
	{
		try
		{
			super.mouseClicked(x, y, button);
			for (int counter = 0; counter < 8; counter++)
			{
				if (tabX <= x && tabX + 20 >= x && guiY + 7 + (22 * counter) <= y && guiY + 27 + (22 * counter) >= y && !onExitScreen && !randPressed)
				{
					for (int index = 0; index < 8; index++)
					{
						metalClicked[index] = false;
					}
					metalClicked[counter] = true;
				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void initGui()
	{
		if (currentHeight != height || currentWidth != width)
		{
			currentHeight = height;
			currentWidth = width;
			guiY = (height - guiHeight) / 2;
			guiX = (width - guiWidth) / 2;
			tabX = guiX + 15;
		}
		if (!randPressed && !onExitScreen)
		{
			for (int index = 0; index < 11; index++)
			{
				metalClicked[index] = false;
			}
		}
		setupMainMenuButtons();
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		try
		{
			switch (button.id)
			{
			case 1:
				onExitScreen = true;
				setupExitButtons();
				if (randPressed)
				{
					Return.enabled = false;
				}
				break;
			case 2:
				selectRandomMetal();
				randPressed = true;
				button.enabled = false;
				returnPower();
				break;
			case 3:
				onExitScreen = false;
				setupMainMenuButtons();
				break;
			case 4:
				if(!randPressed)
				{
					returnPower();
				}
				this.close();
				break;

			}

			super.actionPerformed(button);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void setupMainMenuButtons()
	{
		Finish = new GuiButton(1, guiX + 160, guiY + 179, 35, 15, "Finish");
		Random = new GuiButton(2, guiX + 45, guiY + 179, 70, 15, "Random Metal");
		if (randPressed)
		{
			// Random.enabled = false;
		}
		buttonList.clear();
		buttonList.add(Finish);
		buttonList.add(Random);
	}

	private void setupExitButtons()
	{
		Continue = new GuiButton(4, guiX + 150, guiY + 179, 45, 15, "Continue");
		Return = new GuiButton(3, guiX + 45, guiY + 179, 70, 15, "Go Back");
		buttonList.clear();
		buttonList.add(Continue);
		buttonList.add(Return);
	}

	private void selectRandomMetal()
	{
		if (!randPressed)
		{
			int randomIndex;
			if (((int) (Math.random() * 10)) > 3)
			{
				randomIndex = (int) (Math.random() * 8);
			} else
			{
				randomIndex = (int) (Math.random() * 3) + 8;
			}
			for (int index = 0; index < 11; index++)
			{
				metalClicked[index] = false;
			}

			metalClicked[randomIndex] = true;
		}
	}
	
	private void returnPower()
	{
		int selectedIndex = -1;
		for(int index = 0; index < metalClicked.length; index++)
		{
			if(metalClicked[index])
			{
				selectedIndex = index;
			}
		}
		NetworkHandler.sendToServer(new HandleGui(1,selectedIndex+1));
	}

}