package flourish.listeners;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class Reporter implements IReporter{
	
	Logger logger = Logger.getLogger(Reporter.class);

//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite iSuite : suites) {
			
			System.out.println(iSuite.getName());
			
			Map<String, ISuiteResult> results = iSuite.getResults();
			
			for (ISuiteResult rs : results.values()) {
				ITestContext context = rs.getTestContext();
				System.out.println("All Tests are "+context.getAllTestMethods().length);
				int totalTestCases = context.getPassedTests().size() + context.getFailedTests().size();
				System.out.println("Total Number of Test Cases are Executed :"+totalTestCases);
				System.out.println("Passed Test Cases are "+context.getPassedTests().size());
				System.out.println("Failed Test Cases are "+context.getFailedTests().size());
				logger.info("All Tests are "+context.getAllTestMethods().length);
				logger.info("Total Number of Test Cases are Executed :"+totalTestCases);
				logger.info("Passed Test Cases are "+context.getPassedTests().size());
				logger.info("Failed Test Cases are "+context.getFailedTests().size());
				
			}
			
		}

		
			// TODO Auto-generated method stub
			
		
		
	}


}
