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

public class OutboundPageTest extends AndroidTestBase {
	
	Logger logger = Logger.getLogger(OutboundPageTest.class);
	
	public By txtNewOrder = By.xpath("//android.widget.TextView[@text='NEW ORDER']");
	
	public OutboundPageTest() {
		
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
		outboundPage = flourishDashboardPage.clickOnOutbound();
	
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
		outboundPage.clickOnCreateNewOrder();
		boolean status = driver.findElement(txtNewOrder).isDisplayed();
		Assert.assertTrue(status,"Unable to redirect to OutBound Screen Page");
		logger.info("Redirected to OutBound Screen Page successfully");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be redirected to OutBound Screen Page <br /> Actual Result :Redirected to OutBound Screen Page successfully ", "");
		
		
	}

}
