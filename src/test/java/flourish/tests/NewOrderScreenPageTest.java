package flourish.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.LoginPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class NewOrderScreenPageTest extends AndroidTestBase {
	
	Logger logger = Logger.getLogger(NewOrderScreenPageTest.class);
	static public By txtOrderLines = By.xpath("//android.widget.TextView[@text='Order Lines (0)']");
	static public By txtCreateNewOrder = By.xpath("//android.widget.TextView[@text='Create New Order']");
	static public By txtmsgDestination = By.xpath("//android.widget.TextView[@text='Please select destination']");
	static public By txtOrderLineTitle = By.id("com.flourishsoftware:id/txt_title_order_line");
	public NewOrderScreenPageTest() 
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
		//newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		
		
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
	
	@Test(priority=1,description="Create New Order - Save & Continue")
	public void verifyCreateNewOrderDetails()
	{
		newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		boolean status = driver.findElement(txtOrderLines).isDisplayed();
		
		Assert.assertTrue(status,"Create New Order Details has not verified");
		logger.info("Create New Order Details has verified");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be Redirected to NEW ORDER page  <br /> Actual Result : ReDirected to NEW ORDER Page ", "");
	}
	
	@Test(priority=2,description="Verify that when a user clicks on Cancel then an order is not getting created.")
	public void verifyNewOrderCancelButtons()
	{
		newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		newOrderScreenPage.newOrderCancelButton();
		boolean status = driver.findElement(txtCreateNewOrder).isDisplayed();
		
		Assert.assertTrue(status,"Create New Order Cancel Button has not verified");
		logger.info("Create New Order Cancel Button has verified");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be Redirected to Outbound page  <br /> Actual Result : ReDirected to Outbound Page ", "");
	}
	
	@Test(priority=3,description="Verify Save&Continue Button Validation Message")
	public void verifyNewOrderSaveAndContinueButton()
	{
		//newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		newOrderScreenPage.newOrderSaveAndContinueButton();
		String ExpectedMessage="Please select destination";
		String ActualMessage = driver.findElement(txtmsgDestination).getText();
		System.out.println(ActualMessage);
		Assert.assertEquals(ActualMessage, ExpectedMessage, "Save & Continue Button Validation Not Verified");
		logger.info("Create New Order Save & Continue Button has verified");
		ReportGenerator.verificationTest("PASS", "Expected Result : should be Redirected to NewOrder page  <br /> Actual Result : ReDirected to NewOrder Page successfully ", "");
		
	}
	
	@Test(priority=4,description="Create Order redirect to Order line screen")
	public void verifyAddOrderLineManually()
	{
		newOrderScreenPage.createNewOrderDetails(properties.getProperty("customerPO"), properties.getProperty("searchRepName"));
		newOrderScreenPage.addOrderLineManually();
		boolean status = driver.findElement(txtOrderLineTitle).isDisplayed();
		Assert.assertTrue(status, "Add an Order Line Manually Not Verified");
		logger.info("Add an Order Line Manually Link Verified");
		ReportGenerator.verificationTest("PASS", "Expected Result :Order Line Manually click Should be Redirected to Add Order Line Page <br /> Actual Result : ReDirected to AddOrder Line Page successfully ", "");
		
	}

}
