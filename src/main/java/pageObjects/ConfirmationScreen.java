package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ConfirmationScreen extends AbstractComponents
{
	WebDriver driver;
	public ConfirmationScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'status-banner-msg')]//h1")
	WebElement statusMsg;
	
	public void AppointmentConfirmation()
	{
		waitElementDisappear(spinner);
		System.out.println(statusMsg.getText());
	}
		
}
