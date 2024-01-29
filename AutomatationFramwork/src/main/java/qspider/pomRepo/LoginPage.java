package qspider.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButtton;

	
	@FindBy(xpath="//div[text()='Registered successfully']")
	private WebElement registerSuccesfullMsg;
	
	@FindBy(xpath="//div[text()='Signin successful']")
	private WebElement signinSuccessfullMsg;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButtton() {
		return loginButtton;
	}

	public WebElement getRegisterSuccesfullMsg() {
		return registerSuccesfullMsg;
	}

	public WebElement getSigninSuccessfullMsg() {
		return signinSuccessfullMsg;
	}
	
	public void loginUser(String email, String password) {
		
		emailTextField.sendKeys(email);
	    passwordTextField.sendKeys(password);
	    loginButtton.click();
	    
	}
	
	public boolean verifyRegisterUser() {
		
		return registerSuccesfullMsg.isDisplayed();
	}
	
	public boolean verifyLoginUser() {
		
		return signinSuccessfullMsg.isDisplayed();
	}
	
}
