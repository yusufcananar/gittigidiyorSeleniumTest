package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class gittigidiyorLoginPageObjects {
	
	WebDriver driver = null;
	
	By textbox_username = By.xpath("//*[@id=\"L-UserNameField\"]");
	By textbox_password = By.xpath("//*[@id=\"L-PasswordField\"]");
	By button_login = By.xpath("//*[@id=\"gg-login-enter\"]");
	
	public gittigidiyorLoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void setTextInUsernameBox(String text) {
		
		driver.findElement(textbox_username).sendKeys(text);
	}
	public void setTextInPasswordBox(String text) {
		
		driver.findElement(textbox_password).sendKeys(text);
	}
	public void clickLoginButton() {
		
		driver.findElement(button_login).click();
	}
	
}
