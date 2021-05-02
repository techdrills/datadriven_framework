package dataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.dataProvider_connector;

public class loginTest {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_setup\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://ecollegeweb.in/hostel_project/login");
	}
	
	// code to dataprovider
	
	@DataProvider()
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testData = dataProvider_connector.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getData")
	public void loginTestDataProvider (String username, String password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'sign in')]")).click();	
		String expectedUrl = "http://ecollegeweb.in/hostel_project/index";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualURL);
	}
	
	@AfterMethod()
	public void close() {
		driver.close();
	}
	

}
