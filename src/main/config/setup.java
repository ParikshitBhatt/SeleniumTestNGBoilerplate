package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import utilities.extent_reporter;

public class setup extends extent_reporter{
	public static WebDriver driver;
	
	@BeforeSuite
	public void InitialSetup() {
		try {
			driver = getDriver();
			extentReportSetup();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterSuite
	public void TearDown() {
		try {
			extent.flush();
			closeDriver();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static WebDriver getDriver() {
		if(driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	private static void closeDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}	
}
