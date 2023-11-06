package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper_functions {
	protected static WebDriver driver;
	
	public helper_functions(WebDriver driver) {
		helper_functions.driver = driver;
	}
	
	protected WebElement findElement(By locator) {
		waitForElementToBePresent(locator, Duration.ofMinutes(2));
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		waitForElementToBePresent(locator, Duration.ofMinutes(2));
		findElement(locator).click();
	}
	
	protected void type(By locator, String text) {
		try {
			WebElement element = findElement(locator);
			element.click();
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected boolean isExist(By locator){
		try {
			waitForElementToBePresent(locator, Duration.ofSeconds(10));
			List<WebElement> elements = driver.findElements(locator);
	        return !elements.isEmpty();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	protected static WebElement waitForElementToBePresent(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
