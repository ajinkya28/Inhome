package abstractTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LoginPage;

public class BaseTests 
{
	public WebDriver driver;
	public LoginPage loginPage;
	
	public void initializeDriver() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException
	{
		initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo("https://my-tst2.bswhealth.com/login");
	}
	
	public String getScreenShot(String testCase, WebDriver driver) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\reports\\"+testCase+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public List<HashMap<String,String>> getJsonData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\user.json";
		String jsonContent = FileUtils.readFileToString(new File(path) ,StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>>data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
}
