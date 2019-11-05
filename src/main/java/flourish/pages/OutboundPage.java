package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OutboundPage extends AndroidTestBase {
	
	public OutboundPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Create New Order']")
	@CacheLookup
	AndroidElement txtCreateNewOrder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Allocate Order']")
	@CacheLookup
	AndroidElement txtAllocateOrder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='View Orders']")
	@CacheLookup
	AndroidElement txtViewOrders;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='View Shipments']")
	@CacheLookup
	AndroidElement txtViewShipments;
	
	public NewOrderScreenPage clickOnCreateNewOrder()
	{
		txtCreateNewOrder.click();
		return new NewOrderScreenPage();
	}

}
