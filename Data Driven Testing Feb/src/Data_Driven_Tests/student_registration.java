package Data_Driven_Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.lauch_browser;

public class student_registration {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// connection with the external file of type properties
			Properties prop = new Properties();
			FileInputStream input = new FileInputStream("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\config.properties");
			prop.load(input);
			
			// login to the app
			driver.get(prop.getProperty("url"));
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.tagName("button")).click();

			// code for regisration
						// student details---
						driver.findElement(By.xpath("/html/body/div/aside/div[2]/nav/ul/li[2]/a")).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//input[@id='student_name']")).sendKeys("John Doe");
						driver.findElement(By.xpath("//input[@id='student_college']")).sendKeys("Franson University");
						driver.findElement(By.xpath("//input[@id='date_of_birth']")).sendKeys("20101999");
						
//						String dob = "16-10-1999";
//						WebElement dateofbirth = driver.findElement(By.xpath("//input[@id='date_of_birth']"));
//						((JavascriptExecutor)driver).executeScript("document.getElementById('date_of_birth')");
//						dateofbirth.clear();
//						dateofbirth.sendKeys(dob);
						
						driver.findElement(By.xpath("//input[@id='uid_no']")).sendKeys("123456789012");
						driver.findElement(By.xpath("//input[@id='student_mobile']")).sendKeys("8834567890");
						driver.findElement(By.xpath("//input[@id='parent_name']")).sendKeys("Alen Peter");
						driver.findElement(By.xpath("//input[@id='parent_mobile']")).sendKeys("8877665544");
						driver.findElement(By.xpath("//input[@id='parent_city']")).sendKeys("Boston");
						driver.findElement(By.xpath("//textarea[@id='parent_address']")).sendKeys("Straight road, near assembly abc floor, house no 31");
						driver.findElement(By.xpath("//input[@id='guardian_name']")).sendKeys("Henry joseph");
						driver.findElement(By.xpath("//input[@id='guardian_mobile']")).sendKeys("7234567890");			
						driver.findElement(By.xpath("//textarea[@id='guardian_address']")).sendKeys("near chruche building abc house");
						driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/div[3]/button[1]")).click();
						
	}

}
