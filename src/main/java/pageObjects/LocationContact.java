package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.AbstractComponents;
import io.reactivex.rxjava3.functions.Action;

public class LocationContact extends AbstractComponents
{
	WebDriver driver;
	public LocationContact(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@placeholder='Address 1']")
	WebElement address;
	@FindBy(xpath = "//select[contains(@title,'City')]")
	WebElement selectCity;
	@FindBy(xpath = "//input[@placeholder='Zip Code']")
	WebElement zip;
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement email;
	@FindBy(xpath = "//input[@placeholder='Mobile Phone']")
	WebElement phone;
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	
	public void LocationContactValidate() throws InterruptedException
	{
		waitElementDisappear(spinner);
		Thread.sleep(2000);
		address.sendKeys("Main Road Texas");
		Select obj= new Select(selectCity);
		obj.selectByValue("dallas");
		zip.sendKeys("75201");
		//email.sendKeys("jay.testingactivation2@bswhealth.com");
		phone.sendKeys("4564566789");
		next.click();
		
	}
}
