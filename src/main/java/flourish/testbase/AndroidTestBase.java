package flourish.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import flourish.pages.LoginPage;
import flourish.pages.NewOrderScreenPage;
import flourish.pages.OutboundPage;
import flourish.pages.PIN_Page;
import flourish.pages.SelectEnvironmentPage;
import flourish.pages.AddOrderLinePage;
import flourish.pages.Env_SettingsPage;
import flourish.pages.FlourishDashboardPage;
import flourish.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidTestBase {
	
	static public AndroidDriver<AndroidElement> driver;
	//static public WebDriver driver;
	
	static public FileInputStream fis;
	
	static public Properties properties;
	
	static public LoginPage loginPage;
	static public FlourishDashboardPage flourishDashboardPage;
	static public Env_SettingsPage uat_SettingsPage;
	static public PIN_Page pin_Page;
	static public Env_SettingsPage env_SettingsPage;
	static public SelectEnvironmentPage selectEnvironmentPage;
	static public OutboundPage outboundPage;
	static public NewOrderScreenPage newOrderScreenPage;
	static public AddOrderLinePage addOrderLinePage;
	
	static public Logger logger = Logger.getLogger(AndroidTestBase.class);
	
	public AndroidTestBase()
	{
		try 
		{
			fis = new FileInputStream("src/test/resources/or.properties");
			properties = new Properties();
			properties.load(fis);
		} 
		catch (Exception e) 
		{
			logger.error("Properties file not loaded properly...");
		}
	}
	public static void init()
	{

		try 
		{
			File f = new File("src/test/resources");
			File fs = new File(f,"automation.apk");
			String deviceName = properties.getProperty("device");
			DesiredCapabilities cap = new DesiredCapabilities();
			if(deviceName.equals("emulator"))
			{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Flourish");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			}
			else if(deviceName.contains("real"))
			{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			}
			else 
			{
				//logger.error("Something problem with Device");
			}
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<AndroidElement>(url,cap);
			//driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
			//driver = new IOSDriver<AndroidElement>(url,cap);
			
			
		} 
		catch (Exception e) 
		{
			System.out.println("Cause is : "+e.getCause());
			System.out.println("Message is :"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void teardown()
	{
		
	}

}
