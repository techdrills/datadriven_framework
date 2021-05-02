package Data_Driven_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.excelUtility;

public class loginTest {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// java code to read the data from excel sheet
		
		excelUtility read = new excelUtility("C:\\Users\\Mahesh\\Documents\\dataDriven_TestData.xlsx");
		
		String username = read.getCellData("loginTestData", "username", 2);
		String password = read.getCellData("loginTestData", "password", 2);
		
		System.out.println(username + " "+ password);		
		// selenium code
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ecollegeweb.in/hostel_project/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'sign in')]")).click();
		
		System.out.println("first record......=====");
		
		// unparameterized data and redundent code, that is not proper to use
		String username2 = read.getCellData("loginTestData", "username", 3);
		String password2 = read.getCellData("loginTestData", "password", 3);
		
		System.out.println(username2 + " "+ password2);		
		// selenium code
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ecollegeweb.in/hostel_project/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username2);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password2);
		driver.findElement(By.xpath("//button[contains(text(),'sign in')]")).click();
	

	}

}
