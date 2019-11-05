package flourish.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.LoginPage;
import flourish.pages.PIN_Page;
import flourish.pages.FlourishDashboardPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class Env_SettingsPageTest extends AndroidTestBase{
	
	public Logger logger = Logger.getLogger(Env_SettingsPageTest.class);
	public By txtSettings = By.xpath("//android.widget.TextView[@text='SETTINGS']");
	public By txtPin = By.xpath("//android.widget.TextView[@text='PIN']");
	
	public Env_SettingsPageTest() {
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
	public void verifySelectFacilityAndScanner()
	{
		env_SettingsPage.selectFacilityAndScanner();
		boolean status = driver.findElement(txtPin).isDisplayed();
		Assert.assertTrue(status,"Unable to redirect to PIN Page");
		logger.info("Redirected to PIN Page successfully");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be redirected to PIN Page <br /> Actual Result :Redirected to PIN Page successfully ", "");
		
		
	}
}
