package flourish.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.LoginPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class FlourishDashboardPageTest extends AndroidTestBase {
	
	
	Logger logger = Logger.getLogger(FlourishDashboardPageTest.class);
	
	public By txtCreateNewOrder = By.xpath("//android.widget.TextView[@text='Create New Order']");
	
	public FlourishDashboardPageTest() {
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
		flourishDashboardPage = pin_Page.enterPIN();
		//outboundPage = flourishDashboardPage.clickOnOutbound();
	
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
	public void verifyClickOnOutbound()
	{
		
		//pin_Page.enterPIN();
		flourishDashboardPage.clickOnOutbound();
		boolean status = driver.findElement(txtCreateNewOrder).isDisplayed();
		Assert.assertTrue(status,"Unable to redirect to FlourishDashBoard Page");
		logger.info("Redirected to FlourishDashboard Page successfully");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be redirected to FlourishDashboard Page <br /> Actual Result :Redirected to FlourishDashboard Page successfully ", "");
		
		
	}

}
