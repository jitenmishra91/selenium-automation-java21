package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebdriverFactory;

public class AddUserPage {

	@FindBy(name = "systemUser[employeeName][empName]")
	WebElement empName;
	
	@FindBy(id="systemUser_userName")
	WebElement userName;
	
	@FindBy(id="systemUser_password")
	WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPassword;

	@FindBy(id="btnSave")
	WebElement btnSave;

	WebDriverWait wait;
	
	public AddUserPage()
	{
		PageFactory.initElements(WebdriverFactory.threadStorage.get(), this);
		wait=new WebDriverWait(WebdriverFactory.threadStorage.get(), 30);
	}
	
	public void addUser(String txtEmpName, String txtUserName, String txtPassword, String txtConfirmPassword)
	{
		empName.sendKeys(txtEmpName);
		userName.sendKeys(txtUserName);
		password.sendKeys(txtPassword);
		confirmPassword.sendKeys(txtConfirmPassword);
		btnSave.click();
	}
	
	public AddUserPage isPageloaded()
	{
		wait.until(ExpectedConditions.visibilityOf(empName));
		wait.until(ExpectedConditions.visibilityOf(userName));
		wait.until(ExpectedConditions.visibilityOf(password));
		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
		wait.until(ExpectedConditions.visibilityOf(btnSave));
		return this;
	}
}
