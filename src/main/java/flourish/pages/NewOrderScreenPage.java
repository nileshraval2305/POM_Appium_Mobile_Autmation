package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewOrderScreenPage extends AndroidTestBase {
	
	public NewOrderScreenPage() 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Cancel Button
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	@CacheLookup
	AndroidElement btnCancel;
	
	//Save&Continue Button
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save & Continue']")
	@CacheLookup
	AndroidElement btnSaveAndContinue;
	
		//Validation Message without Select AnyField
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Please select destination']")
		@CacheLookup
		AndroidElement msgDestination;	
		
		//Ok Button
		@AndroidFindBy(xpath="//android.widget.TextView[@text='OK']")
		@CacheLookup
		AndroidElement btnOK;
	
	//Customer PO Textbox
	@AndroidFindBy(id="com.flourishsoftware:id/edt_customer_po")
	@CacheLookup
	AndroidElement txtCustomerPO;
	
	//Sales Rep textbox
	@AndroidFindBy(id="com.flourishsoftware:id/txt_sales")
	@CacheLookup
	AndroidElement txtSalesRep;
		
		//SearchBox
		@AndroidFindBy(id="com.flourishsoftware:id/edt_search")
		@CacheLookup
		AndroidElement txtSearch;
			
			//Search wrong data to check validation correct or not
			@AndroidFindBy(xpath="//android.widget.TextView[@text='No data available.']")
			@CacheLookup
			AndroidElement txtNoDataAvl;
		
		//Select Radio
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Eric Grossman']")
		@CacheLookup
		AndroidElement radiobtnSalesRepName;
	
	//Requested Delivery Date Picker
	@AndroidFindBy(id="com.flourishsoftware:id/edt_delivery_date")
	@CacheLookup
	AndroidElement dateRequestedDeliveryDate;
	
	//Select Destination
	@AndroidFindBy(id="com.flourishsoftware:id/txt_destination")
	@CacheLookup
	AndroidElement txtDestination;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='AutoTest Lab']")
		@CacheLookup
		AndroidElement radiobtnDestination;
	
	//Expand LicenseImg
	@AndroidFindBy(id="com.flourishsoftware:id/img_expanded")
	@CacheLookup
	AndroidElement expandedLicense;
	
	//////////Order Lines/////////////////
	
	//Scan Package Logo
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan a Package to Add and Allocate']")
	@CacheLookup
	AndroidElement txtScanPackageLogo;
	
	//Add Order Line Manually
	@AndroidFindBy(id="com.flourishsoftware:id/txt_Add_order_line")
	@CacheLookup
	AndroidElement txtOrderLineManually;
	
	//Humbergur Menu
	@AndroidFindBy(id="com.flourishsoftware:id/img_humbergur_menu")
	@CacheLookup
	AndroidElement toggleMenu;
		
		//Home Link
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Home']")
		@CacheLookup
		AndroidElement linkHome;
		
		//Settings Link
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
		@CacheLookup
		AndroidElement linkSettings;
		
		//SignOut Link
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign Out']")
		@CacheLookup
		AndroidElement linkSignOut;
		
		
	public void createNewOrderDetails(String customerPo,String searchRepName)
	{
		txtCustomerPO.clear();
		txtCustomerPO.sendKeys(customerPo);
		
		txtSalesRep.click();
		txtSearch.clear();
		txtSearch.click();
		txtSearch.sendKeys(searchRepName);
		radiobtnSalesRepName.click();
		
		txtDestination.click();
		radiobtnDestination.click();
		
		expandedLicense.click();
		btnSaveAndContinue.click();
				
	}
	
	public OutboundPage newOrderCancelButton()
	{
		btnCancel.click();
		return new OutboundPage();
	}
	
	public void newOrderSaveAndContinueButton()
	{
		btnSaveAndContinue.click();
	}
	
	public AddOrderLinePage addOrderLineManually()
	{
		//txtOrderLineManually.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"or Add an Order Line Manually\"));").click();
		return new AddOrderLinePage();
	}

}
