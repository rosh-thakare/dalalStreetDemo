package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Configure
{
	public Properties pro;
	public Read_Configure()
	{
		String path = "C:\\Users\\PERSONAL\\Desktop\\GitHub\\GitHubRepo\\dalalStreetDemo\\Dalalstreet\\src\\resource\\java\\configure\\configs.properties";
		
		try
		{
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getApplicatonUrl()
	{
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");   //short way
	}
}
