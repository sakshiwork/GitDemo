package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObject.LinkedInHomePage;
import pageObject.LoginPage;

import org.junit.runner.RunWith;
import org.testng.Assert;

import TestCases.Base;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	LoginPage lp;

	@Given("^Initializing the browser$")
	public void initializing_the_browser() throws Throwable {
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@Given("^Click on Signin on the home page$")
	public void click_on_signin_on_the_home_page() throws Throwable {
		LinkedInHomePage hp = new LinkedInHomePage(driver);
		lp = (LoginPage) hp.LoginIn();
	}


    @When("^User enter (.+) and (.+) and logsIn$")
    public void user_enter_and_and_logsin(String username, String password) throws Throwable {
       
    
		lp.Email().sendKeys(username);

		lp.Pswrd().sendKeys(password);

		lp.SignInB().click();

	}

	@Then("^Verify it's loggedIn$")
	public void verify_its_loggedin() throws Throwable {
		Assert.assertEquals(lp.titlen().getText(), "Sakshi Srivastava");

		Assert.assertTrue(lp.NotificationBar().isDisplayed());

	}

}