package cucumber.stepdef;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.base.ElementUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends ElementUtils{
	
	//WebDriver driver;
	
	public LoginSteps(){
		getDriver();
		launchApp();
	}
	
	
	@When("Enter the username {string}")
	public void enter_the_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Enter the username = "+string);
	   getDriver1().findElement(By.name("userName")).sendKeys(string);
	}

	@When("Enter the password {string}")
	public void enter_the_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter the password = "+string);
		getDriver1().findElement(By.name("password")).sendKeys(string);
	}

	@When("Click on SignIn button")
	public void click_on_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Clicked on Sign In button");
		getDriver1().findElement(By.name("submit")).click();
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Logged into the application");
		Assert.assertTrue(verifyPageTitle("Login: Mercury Tours"));
		
	}
	
	@After
	public void quitDriver() {
		quitBrowser();
	}

}
