package Data_Driven_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_external_file {

	public static void main(String[] args) throws IOException {
		
		// connection with the external file of type properties
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\config.properties");
		prop.load(input);
		
		// basic code to lauch the browser
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// lauch the url
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.tagName("button")).click();
		

	}

}
