package mod.model.objects.items;

public class MistbornVial extends MistbornItem
{
	private int size;
	public MistbornVial(String name, int tab, int size)
	{
		super(name,tab);
		this.size = size;
	}
}

