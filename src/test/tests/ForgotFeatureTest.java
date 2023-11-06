package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.login_page;
import utilities.testdata_loader;

public class ForgotFeatureTest extends testdata_loader {
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
	public void ForgotUserIDorPassword(String username, String password, String userEmail) {
		boolean isValidateUser = loginPage.forgotAccout(userEmail);
		testLogger.info("Email: "+userEmail);
		Assert.assertTrue(isValidateUser);
		testLogger.info("ValidateForgotUserIDorPassword completed");
	}
}
