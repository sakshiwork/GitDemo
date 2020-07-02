package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInHomePage {

	public WebDriver driver;

	private By signIn = By.xpath("//a[@class='nav__button-secondary']");

	public LinkedInHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage LoginIn() {

		 driver.findElement(signIn).click();
		 LoginPage lp = new LoginPage(driver);
		 return lp;
	}
}
