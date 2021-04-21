package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class gittigidiyorPageObjects {
	
	WebDriver driver = null;
	
	By button_usermenu = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]");
	By button_login = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");
	
	By button_search = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");
	String textbox_search = "k";
	
	By button_page2 = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");
	By button_product_list = By.xpath(".//*[@class='catalog-view clearfix products-container']/li");
	
	By button_basket = By.xpath("//button[@id='add-to-basket']");
	
	By price_real = By.xpath("//div[@id='sp-price-discountPrice']");
	By price_basket = By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p");
	
	By button_gobasket = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a/div[1]/div/img");
	
	By dropdown_select = By.xpath("//body/div[@id='main-content']/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/div[4]/div[1]/div[2]/select[1]");
	
	By button_clear_basket = By.xpath("//body/div[@id='main-content']/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/a[1]/i[1]");
	
	public gittigidiyorPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickUserMenuButton() {
		
		driver.findElement(button_usermenu).click();
	}
	public void clickLoginButton() {
		
		driver.findElement(button_login).click();
	}
	
	public void setTextInSearchBox(String text) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName(arguments[0])[0].value=arguments[1]",textbox_search,text);

	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.ENTER);
	}
	
	public void clickPage2Button() {
		WebElement page2 = driver.findElement(button_page2);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("(arguments[0]).click();",page2);

	}
	
	public void clickProductButton() {
		
		List<WebElement> links = driver.findElements(button_product_list);
		Random gen = new Random();
		int maxProducts = links.size();
		WebElement link = links.get(gen.nextInt(maxProducts));
		
		link.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("(arguments[0]).click();",link);
		

	}
	
	public void clickBasketButton() {
		
		WebElement bask = driver.findElement(button_basket);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("(arguments[0]).click();",bask);
	}
	
	public String getRealPrice() {
		
		WebElement price = driver.findElement(price_real);
		String price_text = price.getText();
		
		return price_text;
	}
	
	public String getBasketPrice() {
		
		WebElement price = driver.findElement(price_basket);
		String price_text = price.getText();
		return price_text;
	}
	
	public void clickGoBasketButton() {
		
		WebElement bask = driver.findElement(button_gobasket);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("(arguments[0]).click();",bask);
	}
	
	public void dropdownSelect2() {
		
		driver.findElement(dropdown_select).click();
		driver.findElement(dropdown_select).sendKeys(Keys.NUMPAD2);
		driver.findElement(dropdown_select).sendKeys(Keys.ENTER);

	}
	
	public void clearBasket() {
		
		driver.findElement(button_clear_basket).click();
		
	}
	
	public void setDelay(double d) {
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
