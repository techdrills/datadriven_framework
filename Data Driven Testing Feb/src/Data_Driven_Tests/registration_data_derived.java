package Data_Driven_Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.excelUtility;

public class registration_data_derived {
	
	public static void main(String[] args) throws IOException, InterruptedException {

		// connection with properties file
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\data_driven.properties");
		prop.load(input);		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		// connection with excel file
		excelUtility reader = new excelUtility("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\Registration_data.xlsx");
		String sheetname = "registrations";
		System.out.println(reader.getRowCount(sheetname));
		
		System.out.println("Launching the browser...");
		
		// luanch browser
//		lauch_browser lb = new lauch_browser();
//		lb.browser_setup("chrome");
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		// login to the app
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.tagName("button")).click();
		
		// reading register data from excel
		
		// registration process
		driver.findElement(By.xpath("//body/div[1]/aside[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='student_name']")).sendKeys(reader.getCellData(sheetname, "student_name", 2));
		driver.findElement(By.xpath("//input[@id='student_college']")).sendKeys(reader.getCellData(sheetname, "organization", 2));
		driver.findElement(By.xpath("//input[@id='date_of_birth']")).sendKeys(reader.getCellData(sheetname, "dob", 2));		
		driver.findElement(By.xpath("//input[@id='uid_no']")).sendKeys(reader.getCellData(sheetname, "uid_no", 2));
		driver.findElement(By.xpath("//input[@id='student_mobile']")).sendKeys(reader.getCellData(sheetname, "mobile", 2));
		driver.findElement(By.xpath("//input[@id='parent_name']")).sendKeys(reader.getCellData(sheetname, "parent_name", 2));
		driver.findElement(By.xpath("//input[@id='parent_mobile']")).sendKeys(reader.getCellData(sheetname, "parent_mobile", 2));
		driver.findElement(By.xpath("//input[@id='parent_city']")).sendKeys(reader.getCellData(sheetname, "parent_city", 2));
		driver.findElement(By.xpath("//textarea[@id='parent_address']")).sendKeys(reader.getCellData(sheetname, "parent_address", 2));
		driver.findElement(By.xpath("//input[@id='guardian_name']")).sendKeys(reader.getCellData(sheetname, "guardian_name", 2));
		driver.findElement(By.xpath("//input[@id='guardian_mobile']")).sendKeys(reader.getCellData(sheetname, "guardian_mobile", 2));			
		driver.findElement(By.xpath("//textarea[@id='guardian_address']")).sendKeys(reader.getCellData(sheetname, "guardian_address", 2));
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/div[3]/button[1]")).click();
					
		
		
		
	}

}
