package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class UserSelectionScreen extends AbstractComponents
{
	WebDriver driver;
	public UserSelectionScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='checkbox-container']")
	List<WebElement>usersList;
	@FindBy(xpath = "//div[contains(@class,'d-flex')]//span[@class='checkmark ']")
	WebElement accept;
	@FindBy(xpath = "//button[text()='NEXT']")
	WebElement next;
	public void selectUser(String proxy)
	{
		for(WebElement user:usersList)
		{
			if(user.getText().equalsIgnoreCase(proxy))
				user.click();
		}
		accept.click();
		next.click();
	}
}
