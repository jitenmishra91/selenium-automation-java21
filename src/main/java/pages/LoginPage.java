package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.SeleniumBase;
import common.WebdriverFactory;

public class LoginPage {

	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(id="spanMessage")
	WebElement hardErrors;
	
	public LoginPage()
	{
		PageFactory.initElements(WebdriverFactory.threadStorage.get(), this);
	}
	
	public HomePage login(String txtUserName, String txtPassword)
	{
		userName.sendKeys(txtUserName);
		password.sendKeys(txtPassword);
		loginButton.click();
		return new HomePage();//.isPageLoaded();
	}
	
	public String getErrorMessage()
	{
		return hardErrors.getText();
	}
	
	
}
