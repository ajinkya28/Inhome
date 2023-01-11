package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class DateTimeSelection extends AbstractComponents
{
	WebDriver driver;
	public DateTimeSelection(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='DayPicker-Day']")
	List<WebElement>dates;
	@FindBy(xpath = "//div[contains(@class,'btn-primary')]")
	List<WebElement>times;
	@FindBy(xpath = "//div[@class='inhome-date-display']")
	WebElement selectedDateTime;
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	public void SelectDateTime() throws InterruptedException
	{
		waitElementDisappear(spinner);
		for(WebElement date:dates)
		{
			waitElementClickable(date);
			date.click();
			break;
		}
		for(WebElement time:times)
		{
			time.click();
			break;
		}
		waitElementAppear(selectedDateTime);
		System.out.println(selectedDateTime.getText());
		next.click();
	}
}
