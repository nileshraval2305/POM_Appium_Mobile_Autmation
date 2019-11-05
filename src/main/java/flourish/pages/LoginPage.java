package flourish.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import flourish.testbase.AndroidTestBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidTestBase{
	
	
	public LoginPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.flourishsoftware:id/edt_username']")
	@CacheLookup
	AndroidElement txtEmail;
	
	@FindBy(how=How.XPATH,using="//android.widget.EditText[@resource-id='com.flourishsoftware:id/edt_pin']")
	@CacheLookup
	AndroidElement txtPass;
	
	@FindBy(how=How.XPATH,using="//android.widget.Button[@text='Sign In']")
	@CacheLookup
	AndroidElement btnLogin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.flourishsoftware:id/txt_show_hide_password']")
	@CacheLookup
	AndroidElement linkShowPassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.flourishsoftware:id/edt_pin']")
	@CacheLookup
	AndroidElement txtShowPwd;
	
	
	
	
	public SelectEnvironmentPage loginToAndroidFlourish(String email,String password)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPass.clear();
		txtPass.sendKeys(password);
		btnLogin.click();
		
		return new SelectEnvironmentPage();
	}
	
	public void clickOnShowPassword()
	{
		linkShowPassword.click();
	}
	
	
}
