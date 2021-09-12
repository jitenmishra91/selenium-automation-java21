package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.IInvokedMethodImpl;
import pages.AddUserPage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

@Listeners(IInvokedMethodImpl.class)
public class UserTest {

	@Test
	public void verifyUserGettingAddedSuccessfully() {
		LoginPage lp=new LoginPage();
		lp.login("Admin", "admin123")
		.verifyWelcomeText()
		.navigateToAdminPage()
		.navigateToAddUserPage()
		.addUser("Jiten", "Jiten123", "Jiten@12", "Jiten@12"); //Object chaining
	}
}
