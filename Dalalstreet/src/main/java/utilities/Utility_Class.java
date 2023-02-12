package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import testBase.Test_Base;


public class Utility_Class extends Test_Base
{
	public Utility_Class()
	{
		PageFactory.initElements(driver,this);
	}
	
//-----------get Url-------------
	public String getWebPageUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
//------------Scroll--------------
	public void scroll_By_XY(String a, String b )
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+a+","+b+")");
	}
	
//------------alert Popup--------
	
	public String getPopupText()
	{
		String popup_Text = driver.switchTo().alert().getText();
		return popup_Text;
	}
	
//------------Screenshot--------------
	
	public static void takeSS(String filename)
	{	
		String path = "C:\\Users\\PERSONAL\\Desktop\\GitHub\\GitHubRepo\\dalalStreetDemo\\Dalalstreet\\screenshots\\";
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		String date_time = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File des = new File(path+filename+"-"+date_time+".png");
		
		try
		{
			FileHandler.copy(src, des);
		}
		catch (IOException e)
		{	
			e.printStackTrace();
		}
	}
}









