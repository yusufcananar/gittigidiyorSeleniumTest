package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googlesearch();
		
	}
	
	public static void googlesearch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Go to google.com
		driver.get("https://www.google.com");
		
		// enter text in search textbox
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.ENTER);
		
		//close browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	}

}
