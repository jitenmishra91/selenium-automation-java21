package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.IInvokedMethodImpl;
import common.SeleniumBase;
import pages.HomePage;
import pages.LoginPage;

@Listeners(IInvokedMethodImpl.class)
public class LoginTest extends SeleniumBase{

	
//	  @Test(dataProvider = "Login Data") 
//	  public void verifyAdminUserLoginSuccefull(String strUserName, String strPassword) 
//	  {
//		  LoginPage lp=new LoginPage(); 
//		  lp.login(strUserName, strPassword).verifyWelcomeText(); 
//	  }
//	 
	
	  @Test(dataProvider = "CSVDataProvider") 
	  public void verifyAdminUserLoginSuccefull(String strUserName, String strPassword) 
	  {
		  LoginPage lp=new LoginPage(); 
		  lp.login(strUserName,strPassword).verifyWelcomeText(); 
	  }
	 
	
	/*
	 * @Test public void verifyInvalidUsername() { LoginPage lp=new LoginPage();
	 * lp.login("dmin", "admin123"); Assert.assertEquals(lp.getErrorMessage(),
	 * "Invalid credentials"); }
	 * 
	 * @Test public void verifyBlankUsername() { LoginPage lp=new LoginPage();
	 * lp.login("", "admin123"); Assert.assertEquals(lp.getErrorMessage(),
	 * "Username cannot be empty"); }
	 * 
	 * @Test public void verifyBlankPassword() { LoginPage lp=new LoginPage();
	 * lp.login("Admin", "");
	 * Assert.assertEquals(lp.getErrorMessage(),"Password cannot be empty"); }
	 */
}
