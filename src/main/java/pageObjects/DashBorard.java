package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class DashBorard extends AbstractComponents
{
	WebDriver driver;
	public DashBorard(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@data-container='MenuHeadItem']//span[text()='Get Care']")
	WebElement getCare;
	@FindBy(xpath = "//span[text()='In-Home Services']")
	WebElement InHomeServies;
	
	public void goToInhome()
	{
		waitElementDisappear(spinner);
		waitElementAppear(getCare);
		waitElementClickable(getCare);
		getCare.click();
		waitElementAppear(InHomeServies);
		InHomeServies.click();
	}
}
