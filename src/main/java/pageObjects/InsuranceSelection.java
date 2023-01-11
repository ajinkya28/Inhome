package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.AbstractComponents;

public class InsuranceSelection extends AbstractComponents
{
	WebDriver driver;
	public InsuranceSelection(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//select[contains(@title,'coverage')]")
	WebElement insuranceSelect;
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	
	public void SelectInsurance(String insurance)
	{
		waitElementAppear(insuranceSelect);
		Select s = new Select(insuranceSelect);
		s.selectByValue(insurance);
		next.click();
	}
}
