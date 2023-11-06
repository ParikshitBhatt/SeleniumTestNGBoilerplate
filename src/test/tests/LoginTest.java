package tests;

import org.testng.annotations.*;
import pages.login_page;
import utilities.testdata_loader;

public class LoginTest extends testdata_loader {
	private login_page loginPage;
	
	@BeforeMethod
	public void setup() {
		loginPage = new login_page(driver);
		createTestSection(this.getClass().getSimpleName());
	}
	
	@DataProvider(name = "loginData")
    public Object[][] provideTestData() {
        return testdata_loader.getTestData();
    }
	
	@Test(dataProvider = "loginData")
	public void ValidateLogin(String username, String password, String email) {
		loginPage.signIn(username, password);
		testLogger.info("Username: "+username+", Password: "+password);
		testLogger.info("Login completed");
	}
	
	@Test(dataProvider = "loginData")
	public void testLogin(String username, String password, String email) {
		loginPage.signIn(username, password);
		testLogger.info("Username: "+username+", Password: "+password);
		testLogger.fail("Login completed");
	}
}
