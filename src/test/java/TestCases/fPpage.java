package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LinkedInHomePage;
import pageObject.LoginPage;


public class fPpage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(fPpage.class.getName());
	LinkedInHomePage hp;
	LoginPage lp;
@BeforeTest
public void befortestExecution() throws IOException
{
	driver = initializeDriver();
	log.info("Driver Initialized");
}
	@Test(dataProvider = "getdata")
	public void forgotpageNavigation(String Username) throws IOException, InterruptedException {

		
		driver.get(prop.getProperty("url"));
		log.info("URL got hit");
		 hp = new LinkedInHomePage(driver);
		LoginPage lp=(LoginPage) hp.LoginIn();
		log.info("Login button clicked");
		Thread.sleep(2000);
		ForgotPassword fp= lp.Forgotpswd();
		Thread.sleep(2000);
		
		fp.emailaddress().sendKeys(Username);
		log.info("username given");
		fp.Findaccount().click();
		log.info("Find Account clicked");
		
	
	}
	
	@Test
	public void header() {
		
		Assert.assertEquals(lp.getheader().getText(), "We just sent you a verification code");
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] obj = new Object[1][1];

		obj[0][0] = "sakshisri.1195@gmail.com";
		return obj;
	}
	
}
