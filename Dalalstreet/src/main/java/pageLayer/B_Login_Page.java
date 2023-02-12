package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_Login_Page
{
	public B_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//input[@placeholder='Enter email']")
	private WebElement email_txtBox;
	
	@FindBy(xpath="//input[@placeholder='Enter Password']")
	private WebElement password_TextBox;
	
	@FindBy(xpath="//div[@class='mt-3 d-grid']")
	private WebElement login_Btn;
	
	@FindBy(xpath="//a[normalize-space()='Signup now']")
	private WebElement signup_NowLink;
	
	public void enter_Email(String email)
	{
		email_txtBox.sendKeys(email);
	}
	
	public void enter_Password(String password)
	{
		password_TextBox.sendKeys(password);
	}
	
	public void click_OnLoginBtn()
	{
		login_Btn.click();
	}
	
	public void click_OnSignupNowLink()
	{
		signup_NowLink.click();
	}
}
