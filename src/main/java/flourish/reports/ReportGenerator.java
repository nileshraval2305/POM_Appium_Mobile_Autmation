package flourish.reports;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import flourish.testbase.AndroidTestBase;
import flourish.utils.TestUtils;


public class ReportGenerator extends AndroidTestBase{
	
	static Logger logger = Logger.getLogger(ReportGenerator.class);
	static ExtentHtmlReporter reporter;
	static ExtentReports reports;
	static ExtentTest test;
	
	public static void generateReport(String reportPath,String owner,String docTitle,String reportName)
	{
		logger.info("Report Generation Started...");
		//fis = new FileInputStream(reportPath);
		reporter = new ExtentHtmlReporter(reportPath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Owner", owner);
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		
		reporter.config().setDocumentTitle(docTitle);
		reporter.config().setReportName(reportName);
		
	}
	
	public static void saveReport()
	{
		reports.flush();
		logger.info("Report Saved...");
	}
	
	public static void startTest(String testName)
	{
		test = reports.createTest(testName);
	}
	
	public static void verificationTest(String status,String verifiedText,String screenshotName)
	{
		if(status.equalsIgnoreCase("PASS"))
		{
			test.pass(MarkupHelper.createLabel(verifiedText, ExtentColor.GREEN));
			logger.info(verifiedText+" - Test Passed");
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			try {
				test.fail(MarkupHelper.createLabel(verifiedText, ExtentColor.RED));
				test.fail(new Throwable(verifiedText+" Test Failed"), MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.getSS(screenshotName)).build());
				logger.error(verifiedText+" - Test Failed");
			} catch (IOException e) {
				logger.error("OOPS...IOException Occurred...");
				e.printStackTrace();
			}
		}
		else if(status.equalsIgnoreCase("SKIP"))
		{
			test.skip(MarkupHelper.createLabel(verifiedText, ExtentColor.GREY));
		}
		else
		{
			logger.fatal("Status not matched");
		}
	}
}
