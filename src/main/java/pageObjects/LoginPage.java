package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	public void LoginApplication(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
	}
	public void goTo(String url)
	{
		driver.get(url);
	}
}
