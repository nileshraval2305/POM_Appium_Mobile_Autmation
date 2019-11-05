package flourish.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.LoginPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class AddOrderLinePageTest extends AndroidTestBase 
{
	
	static public By txtOrderLines = By.xpath("//android.widget.TextView[@text='Order Lines (1)']");
	
	public AddOrderLinePageTest()
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
		flourishDashboardPage = pin_Page.enterPIN();
		outboundPage = flourishDashboardPage.clickOnOutbound();
		newOrderScreenPage = outboundPage.clickOnCreateNewOrder();
		newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		addOrderLinePage = newOrderScreenPage.addOrderLineManually();
		
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
	
	@Test(priority=1,description="To verify that the user is able to add order line")
	public void verifyAddOrderLineDetail()
	{
		addOrderLinePage.addOrderLineDetail(properties.getProperty("itemName"));
		boolean status = driver.findElement(txtOrderLines).isDisplayed();
		Assert.assertTrue(status, "Add an Order Line Manually Not Verified");
		logger.info("Add an Order Line Manually Link Verified");
		ReportGenerator.verificationTest("PASS", "Expected Result :Order Line Manually click Should be Redirected to Add Order Line Page <br /> Actual Result : ReDirected to AddOrder Line Page successfully ", "");
		
	}
}
