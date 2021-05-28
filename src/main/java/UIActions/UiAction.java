package UIActions;

import java.util.concurrent.TimeUnit;

import Modules.ErrorHandling;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiAction {
	private WebElement element = null;
	
	static public WebDriver driver ;
	static public WebDriverWait wait;
	
	public static final int CLICK = 1;
	public static final int CLEAR = 2;
	public static final int GET_TEXT = 3;

	
	public static final int WAIT_UNTIL_VISIBILITY = 1;
	public static final int WAIT_implicitlyWait = 2;


	/**
	 * getter for the driver
	 * @return
	 */
	public static WebDriverWait getWaitDriver(){
		return UiAction.wait;
	}

	/**
	 * setter for the element
	 * @param wait
	 */
	public static void setWaitDriver(WebDriverWait wait){
		UiAction.wait = wait;
	}


	/**
	 * getter for the driver
	 * @return
	 */
	public static WebDriver getDriver(){
		return UiAction.driver;
	}

	/**
	 * setter for the element
	 * @param driver
	 */
	public static void setDriver(WebDriver driver){
		UiAction.driver = driver;
	}

	/**
	 *
	 * @param byXpath
	 * @param waitype
	 * @return
	 */
	public UiAction ElementWait(By byXpath,int waitype) {
		try{

		switch(waitype) {
		case WAIT_UNTIL_VISIBILITY:
			wait.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
			break;
		case WAIT_implicitlyWait:
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		default:
			break;
		
		}
		} catch (ElementNotVisibleException e) {
			ErrorHandling.ElementNotVisibleExceptionHandling(e);
		} catch (ElementNotInteractableException e) {
			ErrorHandling.ElementNotInteractableExceptionHandling(e);
		} catch (TimeoutException e) {
			ErrorHandling.TimeoutExceptionHandling(e);
		}
		
		return this;
	}

	public Boolean elementIsDisplayed(){
		return element.isDisplayed();

	}


	/**
	 *
	 * @param byxpath
	 * @return
	 */
	public UiAction FindElement(By byxpath)  {
		
	try{
		element = driver.findElement(byxpath);


	} catch (InvalidSelectorException e) {
		ErrorHandling.InvalidSelectorExceptionHandling(e);
	} catch (NoSuchElementException e) {
		ErrorHandling.NoSuchElementExceptionHandling(e);
	} catch (NullPointerException e) {
		ErrorHandling.NullPointerExceptionHandling(e);
	} catch (ElementNotVisibleException e) {
		ErrorHandling.ElementNotVisibleExceptionHandling(e);
	}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	
	}

	/**
	 *
	 * @param keys
	 * @return
	 */
	public UiAction SendKeysToElement(String keys) {
	try{
	     element.sendKeys(keys);
	} catch (NullPointerException e) {
		ErrorHandling.NullPointerExceptionHandling(e);
	} catch (NoSuchElementException e) {
		ErrorHandling.NoSuchElementExceptionHandling(e);
	}
		return this;
	}

	/**
	 *
	 * @param action
	 * @return
	 */
	public String ActOntheElement(int action) {
		try{
			switch(action) {
				case UiAction.CLICK:
				element.click();
				return "";
				//break;
			case UiAction.CLEAR:
				element.clear();
				return "";
				//break;
			case UiAction.GET_TEXT:
				
				return element.getText();
				//break;
			default :
				
				break;
		}

	} catch (NullPointerException e) {
		ErrorHandling.NullPointerExceptionHandling(e);
	} catch (ElementNotInteractableException e) {
		ErrorHandling.ElementNotInteractableExceptionHandling(e);
	}
		return null;	
	}

	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		System.out.println("Nehawwwww");
		return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}