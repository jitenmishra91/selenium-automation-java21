package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethodImpl implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", 
				"C:\\\\Users\\\\jiten\\\\Desktop\\\\Automation_Training\\\\chromedriver_win32\\\\chromedriver.exe");
		WebdriverFactory.threadStorage.set(new ChromeDriver());
		WebdriverFactory.threadStorage.get().manage().window().maximize();
		WebdriverFactory.threadStorage.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//Implicit wait
		//1. It will wait for all the implicit methods used in framework i.e Findelement, get, isEnabled etc.
		//2. It is applicable to all the elements in the page classes.
		WebdriverFactory.threadStorage.get().get("https://opensource-demo.orangehrmlive.com/");
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		WebdriverFactory.threadStorage.get().quit();
	}

}
