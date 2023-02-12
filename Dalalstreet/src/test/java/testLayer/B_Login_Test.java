package testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.Test_Base;


public class B_Login_Test extends Test_Base
{
	@Test
	public void loginTest() throws InterruptedException
	{
		String expected_output = "https://www.apps.dalalstreet.ai/dashboard";
		
//		loginPage_Obj.enter_Email("rosh03052021@gmail.com");
//		loginPage_Obj.enter_Password("Rosh@2022");
//		loginPage_Obj.click_OnLoginBtn();
		Thread.sleep(3000);
		
		String actual_output = utility_Obj.getWebPageUrl();
		
		Assert.assertEquals(actual_output, expected_output);
	}
}
