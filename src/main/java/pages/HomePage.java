package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SeleniumBase;
import common.WebdriverFactory;

public class HomePage {

	@FindBy(id="welcome")
	WebElement welcomeText;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminMenuClick;
	
	WebDriverWait wait;
	
	public HomePage()
	{
		PageFactory.initElements(WebdriverFactory.threadStorage.get(), this);
		wait=new WebDriverWait(WebdriverFactory.threadStorage.get(), 30);
	}
	
	public HomePage verifyWelcomeText()
	{
		assertEquals(welcomeText.getText().contains("Welcome"),true);
		return this;
	}
	
	public AdminPage navigateToAdminPage()
	{
		adminMenuClick.click();
		return new AdminPage().isPageloaded();
	}
	
	public HomePage isPageLoaded()
	{
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		wait.until(ExpectedConditions.visibilityOf(adminMenuClick));
		return this;
	}
}
