package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extent_reporter {
	protected static ExtentReports extent;
	private ExtentSparkReporter htmlReport;
	public ExtentTest testLogger;
	private static String projectPath = System.getProperty("user.dir");
	
	protected void extentReportSetup(){
		try {
			extent = new ExtentReports();
	        htmlReport = new ExtentSparkReporter(projectPath+"/src/extent-reports/index.html");
	        extent.attachReporter(htmlReport);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void createTestSection(String TestName) {
		try {
			testLogger = extent.createTest(TestName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
