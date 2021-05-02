package Data_Driven_Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hardCodedData {

	public static void main(String[] args) {
		
		// 3 type test data
			//1 valid username & valid password
			//2 valid username & invalid password
			//3 invalid username & valid password
			//4 blank username & valid password
			//100
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://ecollegeweb.in/hostel_project");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("root");		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		driver.get("http://ecollegeweb.in/hostel_project");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("root");		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		driver.get("http://ecollegeweb.in/hostel_project");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("root123");		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		driver.get("http://ecollegeweb.in/hostel_project");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
	}

}
