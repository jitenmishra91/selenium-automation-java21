package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebdriverFactory;

public class AdminPage {

	@FindBy(id="btnAdd")
	WebElement addButton;
	
	WebDriverWait wait;
	
	public AdminPage()
	{
		PageFactory.initElements(WebdriverFactory.threadStorage.get(), this);
		wait=new WebDriverWait(WebdriverFactory.threadStorage.get(), 30);
	}
	
	public AddUserPage navigateToAddUserPage()
	{
		addButton.click();
		return new AddUserPage().isPageloaded();
	}
	
	public AdminPage isPageloaded()
	{
		wait.until(ExpectedConditions.visibilityOf(addButton));
		return this;
	}
}
