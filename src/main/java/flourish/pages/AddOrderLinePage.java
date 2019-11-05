package flourish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import flourish.utils.TestUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddOrderLinePage extends AndroidTestBase 
{
	public AddOrderLinePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Select Item
	@AndroidFindBy(id="com.flourishsoftware:id/rl_item")
	@CacheLookup
	AndroidElement dropdownSelectItem;
	
	//Search Item
	@AndroidFindBy(id="com.flourishsoftware:id/edt_search")
	@CacheLookup
	AndroidElement txtSearchItem;
	
	//Select Strain
	@AndroidFindBy(id="com.flourishsoftware:id/rl_strain")
	@CacheLookup
	AndroidElement dropdownSelectStrain;
	
	//Quantity Ordered
	@AndroidFindBy(id="com.flourishsoftware:id/edt_quantity_order")
	@CacheLookup
	AndroidElement nubQtyOrdered;
	
	@AndroidFindBy(id="com.flourishsoftware:id/edt_unit_price")
	@CacheLookup
	AndroidElement nubUnitPrice;
	
	@AndroidFindBy(id="com.flourishsoftware:id/edt_total_price")
	@CacheLookup
	AndroidElement nubTotalPrice;
	
	@AndroidFindBy(id="com.flourishsoftware:id/btn_add_to_order")
	@CacheLookup
	AndroidElement btnSave;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(text(),'Automation_test_Item_1_variation_retail_vari')]")
	@CacheLookup
	AndroidElement btnradios;
	
	public void addOrderLineDetail(String item)
	{
		dropdownSelectItem.click();
		txtSearchItem.click();
		txtSearchItem.sendKeys(item);
		Actions actions = new Actions(driver);
		actions.click(btnradios).build().perform();
		//sbtnradios.click();
		//TestUtils.staticWait(1500);
		//driver.findElements(By.className("android.widget.RadioButton")).get(0).click();
		//driver.findElement(By.xpath("//android.widget.TextView[contains(text(),'Automation_test_Item_1_variation_retail_vari')]")).click();
		nubQtyOrdered.sendKeys("30");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save\"));").click();
		
	}

}
