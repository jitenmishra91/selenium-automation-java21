package common;

import org.openqa.selenium.WebDriver;

public class WebdriverFactory {

	public static ThreadLocal<WebDriver> threadStorage=new ThreadLocal<WebDriver>();
}
