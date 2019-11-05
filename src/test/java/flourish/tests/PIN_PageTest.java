package flourish.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.FlourishDashboardPage;
import flourish.pages.LoginPage;
import flourish.pages.PIN_Page;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class PIN_PageTest extends AndroidTestBase {
	
	
	Logger logger = Logger.getLogger(PIN_PageTest.class);
	
	public By txtSettings = By.xpath("//android.widget.TextView[@text='SETTINGS']");
	public By txtPin =By.xpath("//android.widget.TextView[@text='PIN']");
	public By txtoutbound =By.xpath("//android.widget.TextView[@text='Outbound']");
	public PIN_PageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		System.out.println("working");
		logger.info(properties.getProperty("browserName")+"Browser Started");
		loginPage = new LoginPage();
		selectEnvironmentPage = loginPage.loginToAndroidFlourish(properties.getProperty("email"), properties.getProperty("password"));
		env_SettingsPage = selectEnvironmentPage.selectEnvironment();
		
		pin_Page = env_SettingsPage.selectFacilityAndScanner();
	
	}
	
	@AfterMethod
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
			logger.info(properties.getProperty("browserName")+" browser closed");
			
			
		}
	}
	
	@Test
	public void verifyEnterPin()
	{
		
		pin_Page.enterPIN();
		boolean status = driver.findElement(txtoutbound).isDisplayed();
		Assert.assertTrue(status,"Unable to redirect to PIN Page");
		logger.info("Redirected to PIN Page successfully");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be redirected to PIN Page <br /> Actual Result :Redirected to PIN Page successfully ", "");
		
		
	}

}
