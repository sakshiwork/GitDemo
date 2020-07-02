package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By Email = By.xpath("//input[@id='username']");
	By FA = By.xpath("//button[@id='reset-password-submit-button']");

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailaddress() {
		return driver.findElement(Email);
	}

	public WebElement Findaccount() {
		return driver.findElement(FA);
	}

}
