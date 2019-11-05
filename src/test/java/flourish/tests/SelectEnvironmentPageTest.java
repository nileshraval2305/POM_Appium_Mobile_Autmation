package flourish.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.Env_SettingsPage;
import flourish.pages.LoginPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class SelectEnvironmentPageTest extends AndroidTestBase{
	
	Logger logger = Logger.getLogger(SelectEnvironmentPageTest.class);
	
	public By txtSettings = By.xpath("//android.widget.TextView[@text='SETTINGS']");
	
	public SelectEnvironmentPageTest() {
	
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
	public void verifySelectEnv()
	{
		selectEnvironmentPage.selectEnvironment();
		boolean status =driver.findElement(txtSettings).isDisplayed();
		Assert.assertTrue(status,"Unable to direct to Settings page - Test Failed");
		logger.info("Directed to Settings Page - Test Passed");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be directed to setting page  <br /> Actual Result : Directed to Settings Page ", "");
		
	}

}
