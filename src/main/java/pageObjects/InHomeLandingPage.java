package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class InHomeLandingPage extends AbstractComponents
{
	WebDriver driver;
	public InHomeLandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[text()='BOOK IN-HOME VISIT']")
	WebElement bookInHome;
	
	public void goToUserSelection()
	{
		bookInHome.click();
	}
}
