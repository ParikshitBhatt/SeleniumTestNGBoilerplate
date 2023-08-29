package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class helper_functions {
	protected WebDriver driver;
	
	public helper_functions(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
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
}
