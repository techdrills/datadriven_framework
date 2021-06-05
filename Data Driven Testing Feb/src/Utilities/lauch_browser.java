package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class lauch_browser {
	WebDriver driver;
	
	public void browser_setup(String browser_name) {
		
		
		if(browser_name == "chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browser_name == "edge") {
			System.setProperty("webdriver.edge.driver", "C:\\selenium_files\\edgedriver.exe");
			driver = new EdgeDriver();
		}
		
		if(browser_name == "firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\selenium_files\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	}

}
