package mod.model.powers.metals;

import java.awt.Color;

import mod.model.powers.PoweredPlayer;

public abstract class Metal
{
	private String name;
	private int id;
	private boolean isAllomatic;
	private PoweredPlayer player;
	private int color;

	public Metal(String name, int id, int color)
	{
		this.name = name;
		this.id = id;
		this.isAllomatic = false;
		this.player = null;
		this.color = color;
	}

	public int getColor()
	{
		return this.color;
	}
	public boolean isAllomatic()
	{
		return isAllomatic;
	}

	public void setAllomatic(boolean isAllomatic)
	{
		this.isAllomatic = isAllomatic;
	}

	public void setPlayer(PoweredPlayer player)
	{
		this.player = player;
	}

	public String getName()
	{
		return name;
	}

	public int getId()
	{
		return id;
	}
}
