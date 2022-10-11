package pompackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import basePackage.BaseAmazonClass;

public class PomYourAddress extends BaseAmazonClass {
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span") WebElement hellobtn;  
	@FindBy(xpath="//h2[contains(text(),'Your Addresses')]") WebElement addressbtn; 
	@FindBy(id="ya-myab-plus-address-icon") WebElement addaddress;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-countryCode\"]/span/span") WebElement country;
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement name;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement phone;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement address1;
	@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement address2;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement city;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span/span") WebElement province;
	@FindBy(css="#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8") WebElement province1;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement postalcode;
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/span[1]/span[1]/span[1]/input[1]") WebElement submit;
	@FindBy(xpath="//span[contains(text(),'default address')]") WebElement defaultaddress;
	@FindBy(xpath=" //span[contains(text(),'Original Address:')]") WebElement originaladdress;
	@FindBy(xpath="//span[contains(text(),'Suggested Address:')]") WebElement suggestedaddress;
	@FindBy(xpath="//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']") WebElement saveaddresstest; 
	SoftAssert ass;
	public PomYourAddress()
	{
				
		PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
	}
	
	
	public void ClickbtnforAddress()
	{
		hellobtn.click();
		
	}
	public void YourAddress()
	{
		String currentPage=driver.getCurrentUrl();

		addressbtn.click();
		String newPage = driver.getCurrentUrl();
		if(currentPage.equals(newPage))
		    System.out.println("Failure, not navigated to Your Address Page");
		else
		{
		    boolean result1= addaddress.isEnabled();
			System.out.println("Add Address option:"+result1); 	    
			addaddress.click();
		}
	
	}
	public void Country()
	{
		ass=new SoftAssert();
		String result2= country.getText();
		System.out.println("Default country selected:"+result2); 
		ass.assertEquals("Canada",result2);
		ass.assertAll();
			
	}
	public void Name()
	{
		name.sendKeys("anna");
	}
	public void Phone()
	{
		phone.sendKeys("234");
	}
	public void Address()
	{
		address1.sendKeys("apache");
		address2.sendKeys("23");
	}
	public void City()
	{
		city.sendKeys("scarborough");
	}
	public void Province() throws InterruptedException
	{
	province.click();
	Thread.sleep(2000);
	province1.click();
	/*	List<WebElement> options = province.findElements(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8"));
		options.get(4).click();
		for(WebElement option : options) 
		{
				option.click();
				break;
		}*/
	}
	public void PostalCode()
	{
		postalcode.sendKeys("m1l2L2");
	}
	
	public void Submit()
	{
		submit.click();
		
	}
	public void CheckboxforDefaultAddress()
	{
		defaultaddress.click();
		boolean result1= defaultaddress.isSelected();
		System.out.println("Orginal Address option:"+result1); 
		
	}
	public void OrginalAddress() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean result1= originaladdress.isEnabled();
		System.out.println("Orginal Address option:"+result1); 
		
	//	originaladdress.click();
		
	}
	public void SuggestedAddress()
	{
		boolean result1= suggestedaddress.isEnabled();
		System.out.println("Suggested Address option:"+result1); 
		
	}
	public void SaveAddress() throws InterruptedException
	{
	
		Thread.sleep(6000);
		saveaddresstest.click();
				
	}
	
	
}

	

