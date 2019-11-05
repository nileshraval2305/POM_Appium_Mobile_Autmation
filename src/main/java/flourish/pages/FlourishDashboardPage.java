package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FlourishDashboardPage extends AndroidTestBase{
	
	public FlourishDashboardPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cultivation']")
	@CacheLookup
	AndroidElement txtCultivation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Inventory']")
	@CacheLookup
	AndroidElement txtInventory;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Outbound']")
	@CacheLookup
	AndroidElement txtOutbound;
	
	
	public OutboundPage clickOnOutbound()
	{
		txtOutbound.click();
		return new OutboundPage();
	}
	

}
