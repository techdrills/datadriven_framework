package cowin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.excelUtility;

public class cowin {
	public static excelUtility read = new excelUtility("D:\\cowin.xlsx");
	public static JFrame frame;
	public static String UserOtp="";
	public static WebDriver driver;
	public static String mobile;
	public static String pincode = ""; 
	@BeforeTest
	public void baseSetup() throws InterruptedException {
		
		int rowcount = read.getRowCount("data");
		System.out.println(rowcount);
		mobile = read.getCellData("data", "mobile", 2);
		String pincode = read.getCellData("data", "pincode", 2);
		System.out.println(mobile + pincode);
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("https://cowin.gov.in/");
//		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(mobile);
//		driver.findElement(By.xpath("//ion-button[contains(text(),'Get OTP')]")).click();
//		getOtp(); // get otp
//		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(UserOtp);
//		driver.findElement(By.xpath("//ion-button[contains(text(),'Verify & Proceed')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-beneficiary-dashboard/ion-content/div/div/ion-grid/ion-row/ion-col/ion-grid[1]/ion-row[2]/ion-col/ion-grid/ion-row[4]/ion-col[2]/ul/li/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-beneficiary-dashboard/ion-content/div/div/ion-grid/ion-row/ion-col/ion-grid[1]/ion-row[7]/ion-col/div/div[2]/div/ion-button")).click();
		
		
		
		
	}
	
	@Test
	public void schedule() throws InterruptedException {
		
		
	}
	
	@AfterTest
	public void teardown() {
		
	}
	
	public static void getOtp() {
		JFrame f = new JFrame();   
		UserOtp=JOptionPane.showInputDialog(f,"Enter Name");  
		System.out.println(UserOtp);
	}
	


}
