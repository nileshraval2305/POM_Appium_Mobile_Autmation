package flourish.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import flourish.reports.ReportGenerator;

public class SuiteListener implements ISuiteListener{

	public void onStart(ISuite suite) {
		ReportGenerator.generateReport("src/test/resources/ExtentReports/Flourish.html", "Mitesh", "Flourish Login App","Flourish Report");
		
	}

	public void onFinish(ISuite suite) {
		ReportGenerator.saveReport();
		
	}

}
