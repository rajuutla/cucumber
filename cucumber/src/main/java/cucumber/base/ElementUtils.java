package cucumber.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementUtils {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {

		String browserType = System.getProperty("browserType");

		// if(driver == null) {
		switch (browserType.toLowerCase()) {

		case "chrome":
			System.out.println("Passed the browserType as : " + browserType);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver");
			// WebDriverManager.chromedriver().setup();
			// wdMgr.setup();

			driver.set(new ChromeDriver());
			break;
		default:
			driver.set(new ChromeDriver());

		}

		// }

		getDriver1().manage().window().maximize();
		getDriver1().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Driver object in intialize = " + getDriver1().toString());

		return getDriver1();
	}
	
	public WebDriver getDriver1() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
	
	public void quitBrowser() {
		System.out.println("Driver object in quitBrowser method = "+getDriver1().toString());
		getDriver1().quit();
	}

	public void launchApp() {
		String appEnv = System.getProperty("env");
		System.out.println("Environment passed = " + appEnv);

		if (appEnv.trim().equalsIgnoreCase("DEV")) {
			getDriver1().get("http://demo.guru99.com/test/newtours/");
		} else {
			getDriver1().get("http://newtours.demoaut.com");
		}

	}

	public boolean verifyPageTitle(String expTitle) {

		String actualTitle = getDriver1().getTitle();
		System.out.println("acutal page title = "+actualTitle+"Expected title = "+expTitle);

		if (actualTitle.trim().equals(expTitle))
			return true;
		else
			return false;
	}

}
