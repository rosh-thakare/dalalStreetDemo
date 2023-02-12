package testBase;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import com.dalalStreet.pageLayer.A_Sign_Up_Page;
//import com.dalalStreet.pageLayer.B_Login_Page;
//import com.dalalStreet.pageLayer.C_Dashboard_Page;
//import com.dalalStreet.pageLayer.D_Exchanges_Page;
//import com.dalalStreet.pageLayer.E_Place_And_Order;
//import com.dalalStreet.pageLayer.F_Transaction_Page;
//import com.dalalStreet.utilities.Excel_Handling;
//import com.dalalStreet.utilities.Read_Configure;
//import com.dalalStreet.utilities.Utility_Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageLayer.B_Login_Page;
import utilities.Excel_Handling;
import utilities.Read_Configure;
import utilities.Utility_Class;

public class Test_Base
{
	public static WebDriver driver;
	public static Logger logger;
	public B_Login_Page loginPage_Obj;
//	public A_Sign_Up_Page signUp_Obj;
//	public C_Dashboard_Page dashPage_Obj;
//	public E_Place_And_Order placeOrder_Obj;
//	public D_Exchanges_Page exchangesPage_Obj;
//	public F_Transaction_Page transaction_Obj;
	public Utility_Class utility_Obj;
	public Excel_Handling excel_data;
	
//------------Logger---------
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("DalalStreet Automation Framework");
		PropertyConfigurator.configure("Log4jfile.properties");
		logger.info("Framework Execution started");
		
	}
	@AfterTest
	public void end()
	{
		logger.info("Framework execution stopped");
	}
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) throws InterruptedException
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		Read_Configure read_configure = new Read_Configure();
		
		//-------------Initialize Browser---------
		driver.get(read_configure.getApplicatonUrl());
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//-------------object Creation------------
		loginPage_Obj = new B_Login_Page(driver);
//		signUp_Obj = new A_Sign_Up_Page (driver);
		utility_Obj = new Utility_Class();
//		dashPage_Obj = new C_Dashboard_Page(driver);
//		placeOrder_Obj = new E_Place_And_Order(driver);
//		exchangesPage_Obj = new D_Exchanges_Page(driver);
//		transaction_Obj = new F_Transaction_Page(driver);
//		excel_data = new Excel_Handling();
	
		//--------------Login steps-------------
		loginPage_Obj.enter_Email(read_configure.getEmail());
		loginPage_Obj.enter_Password(read_configure.getPassword());
		loginPage_Obj.click_OnLoginBtn();
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}	
}
