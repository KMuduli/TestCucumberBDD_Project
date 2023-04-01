package stepDefinitions;

import java.io.IOException;

import com.aventstack.extentreports.util.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.PageObjectManager;
import pageObjects.LoginTestPage;

public class LoginTestSteps {

	TestContext testContext;
	LoginTestPage testPage;
	
	public LoginTestSteps(TestContext context) {
		testContext = context;
		testPage = testContext.getPageObjectManager().getTestPage();
		}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("*****user is on login page*******");
		testPage.user_is_On_LoginPage();
	}

	@When("user enters username<{string}> and password<{string}>")
	public void user_enters_username_and_password(String userName, String userPassword) {
		System.out.println("*****user enters username and password *******");
		testPage.loginTo_OrangeHRM_Application(userName, userPassword);  
	}

	@And("^click on login button$")
	public void click_on_login_button() throws InterruptedException {
		System.out.println("*****click on login button*******");
		testPage.clickOn_LoginButton();		
		}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws IOException {
		System.out.println("*****user is navigated to the home page**Jai Maharastra*****");
		testPage.verify_UserLogin();
		}
}
