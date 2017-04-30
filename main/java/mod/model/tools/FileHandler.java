package mod.model.tools;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class FileHandler
{
	private static File mainDirectory;
	private static File subDirectory;

	public static void init() throws Exception
	{
		URL path = FileHandler.class.getProtectionDomain().getCodeSource().getLocation();
		String stringPath = URLDecoder.decode(path.getFile(), "UTF-8");
		mainDirectory = new File(new File(stringPath).getParentFile().getParentFile().getPath() + "/MistbornData");
		System.out.println("making directory " + mainDirectory.getPath());
		if (!mainDirectory.exists())
		{
			mainDirectory.mkdir();
		}
	}

	public static void setSubDirectory(String name)
	{
		if (!name.equals("0"))
		{
			boolean run = true;
			if (subDirectory != null)
			{
				run = !subDirectory.getPath().equals(mainDirectory.getParentFile() + "/" + name);
			}
			if (run)
			{
				subDirectory = new File(mainDirectory.getPath() + "/" + name);
				if (!subDirectory.exists())
				{
					subDirectory.mkdir();
				}
			}
		}
	}
	public static File getCurrentDirectory()
	{
		return subDirectory;
	}
}
