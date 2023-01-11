package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractComponents.AbstractComponents;
import abstractTests.BaseTests;
import pageObjects.AppointmentVerification;
import pageObjects.ConfirmationScreen;
import pageObjects.DashBorard;
import pageObjects.DateTimeSelection;
import pageObjects.EligibilityScreen;
import pageObjects.InHomeLandingPage;
import pageObjects.InsuranceSelection;
import pageObjects.LocationContact;
import pageObjects.UserSelectionScreen;
import pageObjects.UserValidation;
import pageObjects.VaccineSelection;

public class LoginValidations extends BaseTests
{
	@Test(dataProvider = "getUsers")
	public void LoginTest(HashMap<String,String>data) throws InterruptedException
	{
		String username=data.get("username");
		String password = data.get("password");
		String vaccine=data.get("vaccine");
		String proxy=data.get("proxy");
		String insurance=data.get("insurance");
		loginPage.LoginApplication(username, password);
		
		DashBorard db = new DashBorard(driver);
		db.goToInhome();
		
		InHomeLandingPage landing = new InHomeLandingPage(driver);
		landing.goToUserSelection();
		
		UserSelectionScreen selectUser=new UserSelectionScreen(driver);
		selectUser.selectUser(proxy);
		
		UserValidation obj = new UserValidation(driver);
		obj.navigateNext();
		
		LocationContact location = new LocationContact(driver);
		location.LocationContactValidate();
		
		InsuranceSelection insu= new InsuranceSelection(driver);
		insu.SelectInsurance(insurance);
		
		VaccineSelection selectVaccine = new VaccineSelection(driver);
		selectVaccine.SelectVaccines(vaccine);
		
		EligibilityScreen e = new EligibilityScreen(driver);
		e.Eligibilty();
		
		DateTimeSelection d = new DateTimeSelection(driver);
		d.SelectDateTime();
		
		AppointmentVerification ap = new AppointmentVerification(driver);
		ap.BookAppointment();
		
		ConfirmationScreen c = new ConfirmationScreen(driver);
		c.AppointmentConfirmation();
	}
	@DataProvider
	public Object[][] getUsers() throws IOException
	{
		List<HashMap<String,String>>data=getJsonData();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	@Test
	public void sampleFail() throws InterruptedException
	{
		loginPage.goTo("https://my-tst2.bswhealth.com/login");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-1000)");
		Assert.assertTrue(false);
	}
}
