package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LinkedInHomePage;
import pageObject.LoginPage;


public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
@BeforeTest
public void befortestExecution() throws IOException
{
	driver = initializeDriver();
	log.info("Driver Initialized");
}
	@Test(dataProvider = "getdata")
	public void basepageNavigation(String Username, String Password) throws IOException, InterruptedException {

		
		driver.get(prop.getProperty("url"));
		log.info("URL got hit");
		LinkedInHomePage hp = new LinkedInHomePage(driver);
		LoginPage lp=(LoginPage) hp.LoginIn();
		log.info("Login button clicked");
		Thread.sleep(2000);
		
		lp.Email().sendKeys(Username);
		log.info("username given");
		lp.Pswrd().sendKeys(Password);
		log.info("pwd given");
		lp.SignInB().click();
		log.info("LoggedIn suucessfully");
		Assert.assertEquals(lp.titlen().getText(), "Sakshi Srivastava");
		log.info("title extracted");
		Assert.assertTrue(lp.NotificationBar().isDisplayed());
		log.info("Notification Bar is displayed");
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] obj = new Object[1][2];

		obj[0][0] = "sakshisri.1195@gmail.com";
		obj[0][1] = "9455614136";

		// obj[1][0]="sakshisriiii.1195@gmail.com";
		 //obj[1][1]="9456665614136";
		return obj;
	}
	@AfterTest
	public void close() {
		driver.close();
		log.info("Driver Closed");
	}
}
