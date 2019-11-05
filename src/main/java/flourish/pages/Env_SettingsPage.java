package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import flourish.utils.TestUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Env_SettingsPage extends AndroidTestBase{
	
	public Env_SettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Setting Page
		//Select Facility Id
		@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
		@CacheLookup
		AndroidElement dropDownFacility;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='CULTIVATION FACILITY']")
		@CacheLookup
		AndroidElement selectFacilityId;
		
		/*//Select Scanner
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Mobile Camera']")
		@CacheLookup
		AndroidElement dropDownScanner;
		
		@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Zebra TC70x / TC75x']")
		@CacheLookups
		AndroidElement radioScannerDevice;
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
		@CacheLookup
		AndroidElement btnScannerOk;*/
		
		@AndroidFindBy(xpath="//android.widget.Button[@text='Save']")
		@CacheLookup
		AndroidElement btnSave;
		
		public PIN_Page selectFacilityAndScanner()
		{
			dropDownFacility.click();
			selectFacilityId.click();
			btnSave.click();
			TestUtils.staticWait(2000);
			return new PIN_Page();
		}

}
