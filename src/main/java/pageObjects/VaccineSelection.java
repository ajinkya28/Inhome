package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class VaccineSelection extends AbstractComponents
{
	WebDriver driver;
	public VaccineSelection(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h2[@class='recipient-name']")
	WebElement dropDown;
	@FindBy(xpath = "//label[contains(@class,'check-wrapper')]")
	List<WebElement>vaccines;
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	@FindBy(xpath = "//button[text()='No thank you']")
	WebElement no;
	public void SelectVaccines(String vaccine) throws InterruptedException
	{
		waitElementDisappear(spinner);
		waitElementAppear(dropDown);
		dropDown.click();
		for(WebElement v:vaccines)
		{
			if(v.getText().equalsIgnoreCase(vaccine))
			{
				v.click();
			}
		}
		next.click();
		Thread.sleep(1000);
		no.click();
	}
}
