package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class EligibilityScreen extends AbstractComponents
{
	WebDriver driver;
	public EligibilityScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	public void Eligibilty()
	{
		waitElementDisappear(spinner);
		waitElementAppear(next);
		next.click();
	}
}
