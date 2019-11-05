package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import flourish.utils.TestUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectEnvironmentPage extends AndroidTestBase{
	
	public SelectEnvironmentPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Select Environment
		@AndroidFindBy(xpath="//android.widget.RadioButton[@text='UAT']")
		@CacheLookup
		AndroidElement radioBtnUAT;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
		@CacheLookup
		AndroidElement btnOk;
		
		public Env_SettingsPage selectEnvironment() 
		{
			TestUtils.staticWait(1000);
			radioBtnUAT.click();
			TestUtils.staticWait(1000);
			btnOk.click();
			return new Env_SettingsPage();
		}

}
