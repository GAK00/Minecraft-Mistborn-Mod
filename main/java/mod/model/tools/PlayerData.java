package mod.model.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerData
{
	private File mainDirectory;
	private Path mainPath;

	public PlayerData(EntityPlayer player)
	{
		mainDirectory = new File(FileHandler.getCurrentDirectory().getPath() + "/" + player.getUniqueID() + ".txt");
		mainPath = Paths.get(mainDirectory.getPath());
		try
		{
			Files.write(mainPath, "".getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void createGroup(String groupName)
	{
		List<String> contents;
		try
		{
			contents = Files.readAllLines(mainPath);
			if (!contents.contains(groupName+"--"))
			{
				contents.add(groupName+"--");
				contents.add("----------");
				Files.write(mainPath, contents, StandardOpenOption.WRITE);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void addToGroup(String[] types, String[] defaultValues, String group)
	{
		if (types.length == defaultValues.length)
		{
			try
			{
				List<String> contents = Files.readAllLines(mainPath);
				if (contents.contains(group + "--"))
				{
					int startIndex = contents.indexOf(group + "--");
					List<String> pre = new ArrayList<String>();
					pre.addAll(contents.subList(0, startIndex));
					
					List<String> halfCleaned = contents.subList(startIndex, contents.size());
					
					int endIndex = halfCleaned.indexOf("----------");
					List<String> post = new ArrayList<String>();
					post.addAll(halfCleaned.subList(endIndex, halfCleaned.size()
							));
					List<String> cleaned = halfCleaned.subList(0, endIndex);
					for (int index = 0; index < types.length; index++)
					{
						String type = types[index];
						if (!cleaned.contains(type + ":"))
						{
							cleaned.add(1, defaultValues[index]);
							cleaned.add(1, type + ":");
						}
					}
					cleaned.addAll(post);
					cleaned.addAll(0, pre);
					Files.write(mainPath, cleaned, StandardOpenOption.WRITE);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public List<String> getGroup(String group)
	{
		List<String> groupData = null;
		try
		{
			List<String> elements = Files.readAllLines(mainPath);
			if(elements.contains(group+"--"))
			{
				int startIndex = elements.indexOf(group+"--");
				List<String> subElements = elements.subList(startIndex, elements.size());
				int endIndex =subElements.indexOf("----------");
				groupData = subElements.subList(1, endIndex);
			}
		}
		catch(IOException e)
		{
			System.out.println("FUCK");
		}
		return groupData;
	}
	public String getFromGroup(String name, String group)
	{
		try
		{
			List<String> contents = Files.readAllLines(mainPath);
			if (contents.contains(group + "--"))
			{
				int startIndex = contents.indexOf(group + "--");
				List<String> pre = new ArrayList<String>();
				pre.addAll(contents.subList(0, startIndex));
				List<String> halfCleaned = contents.subList(startIndex, contents.size());
				int endIndex = halfCleaned.indexOf("----------");
				List<String> post = new ArrayList<String>();
				post.addAll(halfCleaned.subList(endIndex, halfCleaned.size()));
				List<String> cleaned = halfCleaned.subList(0, endIndex);
				for (int index = 0; index < cleaned.size(); index++)
				{
					if (cleaned.get(index).equalsIgnoreCase(name + ":"))
					{
						return cleaned.get(index + 1);
					}
				}
				return null;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void saveToGroup(String name, String value, String group)
	{
		try
		{
			List<String> contents = Files.readAllLines(mainPath);
			if (contents.contains(group + "--"))
			{
				int startIndex = contents.indexOf(group + "--");
				List<String> pre = new ArrayList<String>();
				pre.addAll(contents.subList(0, startIndex));
				List<String> halfCleaned = contents.subList(startIndex, contents.size());
				int endIndex = halfCleaned.indexOf("----------");
				List<String> post = new ArrayList<String>();
				post.addAll(halfCleaned.subList(endIndex, halfCleaned.size()));
				List<String> cleaned = halfCleaned.subList(0, endIndex);
				for (int index = 0; index < cleaned.size(); index++)
				{
					if (cleaned.get(index).equalsIgnoreCase(name + ":"))
					{
						cleaned.set(index + 1, value);
					}
				}
				cleaned.addAll(post);
				cleaned.addAll(0, pre);
				Files.write(mainPath, cleaned, StandardOpenOption.TRUNCATE_EXISTING);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public int toInteger(String string)
	{
		return Integer.parseInt(string);
	}
	public double toDouble(String string)
	{
		return Double.parseDouble(string);
	}
	public boolean toBool(String string)
	{
		int representiveInt = Integer.parseInt(string);
		return representiveInt == 1;
	}
}
