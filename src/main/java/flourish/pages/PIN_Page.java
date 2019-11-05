package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PIN_Page extends AndroidTestBase {
	
	public PIN_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//PIN Flourish Window
		@AndroidFindBy(xpath="//android.widget.Button[@text='5']")
		@CacheLookup
		AndroidElement keyPress5;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='2']")
		@CacheLookup
		AndroidElement keyPress2;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='9']")
		@CacheLookup
		AndroidElement keyPress9;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='8']")
		@CacheLookup
		AndroidElement keyPress8;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='0']")
		@CacheLookup
		AndroidElement keyPress0;
		
		public FlourishDashboardPage enterPIN()
		{
			keyPress5.click();
			keyPress2.click();
			keyPress9.click();
			keyPress8.click();
			keyPress0.click();
			keyPress9.click();
			return new FlourishDashboardPage();
		}

}
