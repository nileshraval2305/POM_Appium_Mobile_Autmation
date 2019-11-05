package flourish.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flourish.pages.LoginPage;
import flourish.pages.FlourishDashboardPage;
import flourish.reports.ReportGenerator;
import flourish.testbase.AndroidTestBase;

public class LoginPageTest extends AndroidTestBase {
	
	Logger logger = Logger.getLogger(LoginPageTest.class);

	static public By txtPassword = By.xpath("//android.widget.EditText[@resource-id='com.flourishsoftware:id/edt_pin']");
	static public By txtShowPwd = By.xpath("//android.widget.EditText[@resource-id='com.flourishsoftware:id/edt_pin']");
	static public By txtSelectEnvironment = By.xpath("//android.widget.TextView[@text='Select Environment']");
	static public By txtSettings = By.xpath("//android.widget.TextView[@text='SETTINGS']");
	
	public LoginPageTest()
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
	
	@Test(priority=1)
	public void verifyLoginToAndroidFlourish()
	{
		//welcomePage = loginPage.loginToAndroidFlourish()(email,pass);
		selectEnvironmentPage = loginPage.loginToAndroidFlourish(properties.getProperty("email"), properties.getProperty("password"));
		boolean status = driver.findElement(txtSelectEnvironment).isDisplayed();
		
		Assert.assertTrue(status,"Flourish Login to Application has not verified");
		logger.info("Flourish Login to Application has verified");
		ReportGenerator.verificationTest("PASS", "Flourish Login to Application has verified", "");
	}
	
	@Test(priority=2)
	public void verifyClickOnShowPassword()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(txtPassword).sendKeys(properties.getProperty("password"));
		loginPage.clickOnShowPassword();
		String expPassword="Flourish1!";
		String actualPassword = driver.findElement(txtShowPwd).getText();
		System.out.println(actualPassword);
		Assert.assertEquals(actualPassword, expPassword, "Show Password Functionality not verified");
		logger.info("Show Password Functionality has verified");
		ReportGenerator.verificationTest("PASS", "Show Password Functionality has Verified!", "");
	}
	
}
