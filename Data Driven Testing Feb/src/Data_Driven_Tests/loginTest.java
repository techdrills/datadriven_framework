package Data_Driven_Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.excelUtility;

public class loginTest {

	public static void main(String[] args) throws InterruptedException {
		
		excelUtility reader = new excelUtility("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\login_test_data.xlsx");
		String sheetName = "login data";
		int rows = reader.getRowCount(sheetName);
		String baseUrl = reader.getCellData("config", "url", 2);
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		for(int i = 2; i<=rows; i++) {
			String username = reader.getCellData(sheetName, "username", i);
			String password = reader.getCellData(sheetName, "password", i);
			
			driver.findElement(By.name("username")).clear();  // clear the textfield
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.tagName("button")).click();
			Thread.sleep(1000);
			
			String url = driver.getCurrentUrl();
			if(url.contains("index")) {
				driver.navigate().to("http://ecollegeweb.in/hostel_project/login");
				reader.setCellData(sheetName, "status", i , "Passed");  // write the data into excel sheet
				
				System.out.println("Test Case is Passed and test data is -"+ username + " | " + password);
			}
			else{
				reader.setCellData(sheetName, "status", i , "Failed");  // write the data into excel sheet
				System.out.println("Test Case is Failed and test data is -"+ username + " | " + password);
			}
		}
		
		
	}

}
