package mod.model.objects.items;

public class ShavingKnife extends MistbornItem
{

	public ShavingKnife(String name, int tab)
	{
		super(name, tab);
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setMaxDamage(30);
		this.setNoRepair();
	}

}
