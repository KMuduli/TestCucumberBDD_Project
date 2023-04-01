package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Verify;

import dev.failsafe.internal.util.Assert;
import selenium.Wait;

public class LoginTestPage {
	WebDriver driver;
	public LoginTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "username") 
	private WebElement txtbx_UserName;
	
	@FindBy(how = How.NAME, using = "password") 
	private WebElement txtbx_UserPassword;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,' oxd-button')]") 
	private WebElement btn_Login;
	
	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'')])[8]") 
	private WebElement link_AdminDashboard;

	public void user_is_On_LoginPage() {
		Assert.isTrue(btn_Login.isDisplayed(),"User failed to login OrangeHRM Application", "Test");
	}
	public void loginTo_OrangeHRM_Application(String username,String password) {
		txtbx_UserName.sendKeys(username);
		txtbx_UserPassword.sendKeys(password);			
	}
	
	public void clickOn_LoginButton() throws InterruptedException {
		btn_Login.click();	
		Thread.sleep(3000);
	}
	
	public void verify_UserLogin() {
		Assert.isTrue(link_AdminDashboard.isDisplayed(), "User failed to login OrangeHRM Application", "Test");
	}


}
