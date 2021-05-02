package Data_Driven_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.excelUtility;

public class get_parameterized_data {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// connection with excel file
		excelUtility read = new excelUtility("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Framwork\\src\\testData\\dataDriven_TestData.xlsx");
		int rowcount = read.getRowCount("loginTestData");
		System.out.println(rowcount);
		
		// selenium code to launch browser
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_setup\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// loop to read multiple records from the file.
		// parameterisation of data---
		for(int i=2; i<=rowcount; i++) {
			
			System.out.println("----- executed count :"+ i);
			driver.get("http://ecollegeweb.in/hostel_project/login");
			
			String username = read.getCellData("loginTestData", "username", i);
			String password = read.getCellData("loginTestData", "password", i);
			System.out.println("row = " + i + " "+ username + " "+ password);
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[contains(text(),'sign in')]")).click();
			
			// test data and test case validation and write result into the excel sheet.
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("index")) {
				System.out.println("Test case is Passed");
				// write the data into the excel sheet
				read.setCellData("loginTestData", "status", i , "Passed");
			}
			else {
				System.out.println("Test case is Failed");
				// write the data into the excel sheet
				read.setCellData("loginTestData", "status", i , "Failed");
			}
			
		}
		
		
	}

}
