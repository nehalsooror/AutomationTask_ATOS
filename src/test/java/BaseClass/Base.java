package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import UIActions.UiAction;

public class Base {

		/**
		 * the base cass the contains the path and takes the chrome as a default url
		 */
	@BeforeClass
	@Parameters({"Browser"}) // To run test from suite
	public void beforeClass(@Optional("chrome") String Browser) {
		switch (Browser) {

			case "chrome": // run tests by chrome
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				UiAction.setDriver(new ChromeDriver(options)) ;

				break;
			case "firefox": //run tests by firefox
				WebDriverManager.firefoxdriver().setup();
				UiAction.setDriver(new FirefoxDriver());

				break;
			case "internet explorer": //run tests by internet explore
				WebDriverManager.iedriver().setup();
				UiAction.setDriver(new InternetExplorerDriver());

				break;
			case "opera": //run tests by opera
				WebDriverManager.operadriver().setup();
				UiAction.setDriver(new OperaDriver());

				break;
		}

		UiAction.getDriver().manage().window().maximize();
		UiAction.setWaitDriver(new WebDriverWait(UiAction.getDriver(), 10));

	}

		/**
		 * after class to close the driver
		 */
	@AfterTest
	public void afterClass() {
		UiAction.getDriver().close();

	}

}
