package tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.gittigidiyorLoginPageObjects;
import pages.gittigidiyorPageObjects;
import logPackage.gittigidiyorLogger;

public class gittigidiyorTest {
	
	gittigidiyorLogger logObj = new gittigidiyorLogger();
	private static WebDriver driver = null;
	
	@Before
	public void setUpTest() {
		
		logObj.log_info("Initialize the test case.");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	
	@Test
	public void gittigidiyorPageTest() {
		
        //Define main page class and login page class
		
		gittigidiyorPageObjects mainPageObj = new gittigidiyorPageObjects(driver);
		gittigidiyorLoginPageObjects loginPageObj = new gittigidiyorLoginPageObjects(driver);
		logObj.log_trace("Defining main page class and login page class is successful.");
		
		//open gittigidiyor
		driver.get("https://www.gittigidiyor.com/");
		logObj.log_trace("Open page https://www.gittigidiyor.com/ is successful.");
		
		//Check main page is opened
		Assertions.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi", driver.getTitle());
		logObj.log_trace("Check main page is successful.");
		
		//Go to Login page
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clickUserMenuButton();
		mainPageObj.clickLoginButton();
		
		//Login
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		loginPageObj.setTextInUsernameBox("testcand88@gmail.com");
		loginPageObj.setTextInPasswordBox("T3st1234");
		//Check Login process
		System.out.println(driver.getCurrentUrl());
		Assertions.assertEquals("https://www.gittigidiyor.com/uye-girisi", driver.getCurrentUrl());
	
		loginPageObj.clickLoginButton();
		//login process ends here
		logObj.log_trace("Login is successful.");
		
		
		//Search for "bilgisayar"
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.setTextInSearchBox("bilgisayar");
		mainPageObj.clickSearchButton();
		logObj.log_trace("Search 'bilgisayar' is successful.");
		
		//open page 2
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clickPage2Button();
		
		//check page 2 is opened
		Assertions.assertEquals("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2", driver.getCurrentUrl());
		logObj.log_trace("Check page 2 is successful.");
		
		//Pick a random product
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clickProductButton();
		
		//Add product in to the basket
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clickBasketButton();
		
		//Get product page price
		mainPageObj.setDelay(1);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		String priceR = mainPageObj.getRealPrice();
		System.out.println(priceR);
		
		//Go to basket
		mainPageObj.setDelay(1);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clickGoBasketButton();
		
		//Get basket price
		mainPageObj.setDelay(1);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		String priceB = mainPageObj.getBasketPrice();
		System.out.println(priceB);
		
		//Compare prices
		if (priceR.equals(priceB)) {
			System.out.println("Product price and basket price are equal.");
			logObj.log_trace("Product price and basket price are equal.");
		}
		
		else {
			System.out.println("Product and basket price are not equal.");
			logObj.log_trace("Product price and basket price are not equal.");
		}
		logObj.log_trace("Price comparison is successful.");
		
		//Increase number of products to 2
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.dropdownSelect2();
		WebElement selNum2 = driver.findElement(By.xpath("//option[contains(text(),'2')]"));
		
		
		// Check it is 2
		String num2 = selNum2.getText();
		System.out.println(num2);
		Assertions.assertEquals("2", num2);
		logObj.log_trace("Number of products is 2.");
		
		//Clean the basket
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		mainPageObj.clearBasket();
		mainPageObj.setDelay(2);
		
		//Check it is clean
		WebElement checkCleanBasket = driver.findElement(By.xpath("//h2[contains(text(),'Sepetinizde ürün bulunmamaktadýr.')]"));
		String expectedBasket = checkCleanBasket.getText();
		System.out.println(expectedBasket);
		Assertions.assertEquals("Sepetinizde ürün bulunmamaktadýr.", expectedBasket);
		logObj.log_trace("Basket is empty.");
		
	}
	
	@After
	public void tearDownTest() {
		
		//Close the driver
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully.");
		logObj.log_info("Test Completed Successfully.");
	}
}
