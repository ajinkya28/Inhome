package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class AppointmentVerification extends AbstractComponents
{
	WebDriver driver;
	public AppointmentVerification(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[text()='BOOK IT']")
	WebElement book;
	public void BookAppointment()
	{
		waitElementDisappear(spinner);
		waitElementClickable(book);
		book.click();
	}
}
