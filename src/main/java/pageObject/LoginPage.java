package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	private By Email = By.id("username");
	private By pw = By.id("password");
	private By SignInButton = By.xpath("//button[@class='btn__primary--large from__button--floating']");
	private By title = By.xpath("//div[@class='profile-rail-card__actor-link t-16 t-black t-bold']");

	
	private By Notification = By.xpath("//span[@id='notifications-tab-icon']");
	private By ForPas = By.xpath("//a[@class='btn__tertiary--medium action__btn']");
	private By FpH = By.xpath("//h1[@class='content__header']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public ForgotPassword Forgotpswd() {

		driver.findElement(ForPas).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}

	public WebElement Email() {
		return driver.findElement(Email);
	}

	public WebElement Pswrd() {
		return driver.findElement(pw);
	}

	public WebElement SignInB() {
		return driver.findElement(SignInButton);
	}

	public WebElement titlen() {
		return driver.findElement(title);
	}

	public WebElement NotificationBar() {
		return driver.findElement(Notification);
	}
	
	public WebElement getheader() {
		return driver.findElement(FpH);
	}
}
