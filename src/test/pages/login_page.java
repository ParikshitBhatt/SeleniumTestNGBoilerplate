package pages;

import org.openqa.selenium.*;
import utilities.helper_functions;

public class login_page extends helper_functions{
	public login_page(WebDriver driver) {
		super(driver);
		driver.get("https://sach.org.in/login");
	}
	
	//Page Locators
	private By userIdField = By.id("userID");
	private By passwordField = By.id("password");
	private By signInBtn = By.xpath("//button[contains(text(),'Sign in')]");
	private By forgotIDorPassword = By.xpath("//*[contains(text(),'Forgot User ID or Password?')]");
	private By forgot_EmailField = By.id("userEmail");
	private By forgot_SendBtn = By.xpath("//button[contains(text(),'Sign in')]");
	private By createAccount = By.xpath("//*[contains(text(),'Create an account')]");
	
	//Page Features
	public void signIn(String userId, String password) {
		type(userIdField, userId);
		type(passwordField, password);
		click(signInBtn);
	}
	
	public void forgotAccout(String email) {
		click(forgotIDorPassword);
		type(forgot_EmailField, email);
		click(forgot_SendBtn);
	}
	
	public void createAccount() {
		click(createAccount);
	}	
}
