package pompackage;


import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.asserts.SoftAssert;

import basePackage.BaseAmazonClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PomShoppingCart extends BaseAmazonClass{
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchbox;
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]") WebElement submit;
	//@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']") WebElement searchoption;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement addtocartbtn; 
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]/span[1]") WebElement hellotest;  
	@FindBy(xpath="//a[contains(text(),'Go to cart')]") WebElement gotocart;
	@FindBy(xpath="//img[@class='sc-product-image']/parent::a[@class='a-link-normal sc-product-link']") WebElement img;
	@FindBy(xpath="//span[@class='a-truncate-cut']") WebElement name;
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']") WebElement price;
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")WebElement totalprice;
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]") WebElement itemquantity;
	@FindBy(xpath="//a[@id='quantity_2']")WebElement quantityincrease;
	@FindBy(xpath="//span[@id='nav-cart-count']") WebElement shoppingcart;
	@FindBy(css=".a-dropdown-prompt")WebElement multiplecheck;
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h2[1]/a[1]/span[1]") WebElement search2;
	@FindBy(xpath="//span[contains(text(),'One-time purchase')]") WebElement onepurchase;
	@FindBy(xpath="//img[@class='sc-product-image']") WebElement image;
	@FindBy(css=".a-truncate a-size-medium") WebElement nameincart;
	@FindBy(id="sc-subtotal-label-activecart") WebElement numberforclosing;
	@FindBy(css=".a-color-link")WebElement cl;
	
	@FindBy(id="nav-line-2 ") WebElement SignInbtn1;
	@FindBy(id="ap_email") WebElement Email;    
	@FindBy(id="continue") WebElement Continue;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="signInSubmit") WebElement SignInbtn2;
	Select sel;
	SoftAssert ass;
	PomSignIn log;
	public PomShoppingCart()
	{
				
		PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
		ass=new SoftAssert();
		log=new PomSignIn();
	}
	
	public void AddItem() throws InterruptedException
	{	
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(9000);
		boolean result1= img.isDisplayed();
		System.out.println("Image:"+result1); 	    
		boolean result2= name.isDisplayed();
		System.out.println("Name:"+result2); 
		boolean result3= price.isDisplayed();
		System.out.println("Price:"+result3); 
		boolean result4= totalprice.isDisplayed();
		System.out.println("TotalPrice:"+result4); 
			
	}
	public void IncreaseQuantity() throws InterruptedException
	{		
		shoppingcart.click();
		Thread.sleep(5000);
		cl.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(4000);
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(4000);
		Double quantity1= Double.parseDouble(totalprice.getText().replace("$", ""));
		Thread.sleep(4000);
		itemquantity.click();
		Thread.sleep(2000);
		quantityincrease.click();
		Thread.sleep(2000);
		Double quantityTotal1= quantity1*2;
		Double  quantityTotal2=Double.parseDouble(totalprice.getText().replace("$", ""));
		ass.assertEquals(quantityTotal1,quantityTotal2);
		System.out.println(quantityTotal1);
		System.out.println(quantityTotal2);
	}
	
	public void SameItemMultipleTimes() throws InterruptedException
	{ 
		shoppingcart.click();
		Thread.sleep(5000);
		cl.click();
		Thread.sleep(3000);
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(4000);
		addtocartbtn.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(2000);
		hellotest.click();
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(6000);
		double amt1= Double.parseDouble(price.getText().replace("$", ""));
		double count= Double.parseDouble(multiplecheck.getText());
		double totalincalculation= amt1*count;
		double totalfound= Double.parseDouble(totalprice.getText().replace("$", ""));
		ass.assertEquals(totalincalculation,totalfound);
		List<WebElement> item= driver.findElements(By.xpath("//*[@id=\"sc-item-C99fda1ee-1fa0-4462-ba2f-5822fce5bb1d\"]//span[@class='a-truncate-full a-offscreen']"));
		int size= item.size();
		if(size==0)
			System.out.println("Only one tye of item with quantity incresed");
		else
			System.out.println("Duplicate");
	}
	
	public void DifferentItemMultipleTime() throws InterruptedException
	{ 
		shoppingcart.click();
		Thread.sleep(5000);
		cl.click();
		Thread.sleep(3000);
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(4000);
		addtocartbtn.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		search2.click();
		Thread.sleep(3000);
		onepurchase.click();
		Thread.sleep(3000);
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(6000);
		
		
		List<WebElement> item1= driver.findElements(By.xpath("//img[@class='sc-product-image']"));
		for(WebElement w: item1)
		{
			boolean result1= w.isDisplayed();
			System.out.println("Image:"+result1); 	
		}
		List<WebElement> item2= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
		for(WebElement w: item2)
		{
			boolean result1= w.isDisplayed();
			System.out.println("Price:"+result1); 	
		}
		
			boolean result1= totalprice.isDisplayed();
			System.out.println("TotalPrice:"+result1); 	
			
	}
	public void RemoveItem() throws InterruptedException
	{	
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(4000);
		addtocartbtn.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		search2.click();
		Thread.sleep(3000);
		onepurchase.click();
		Thread.sleep(3000);
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(6000);
				
	  double total=Double.parseDouble(totalprice.getText().replace("$", ""));
	//  System.out.println(total);
	  shoppingcart.click();
	  Thread.sleep(8000);
	  WebElement clear= driver.findElement(By.className("a-color-link"));
	  clear.click();
	  Thread.sleep(4000);
	  double newtotal=Double.parseDouble(totalprice.getText().replace("$", ""));
	//  System.out.println(newtotal);
	if(newtotal<total)
		System.out.println("Price updated... Old price was:"+total+"New Price is:"+newtotal);
	}
	public void RemoveAll() throws InterruptedException
	{
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		hellotest.click();
		Thread.sleep(4000);
		addtocartbtn.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(3000);
		search2.click();
		Thread.sleep(3000);
		onepurchase.click();
		Thread.sleep(3000);
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(6000);
		
		List<WebElement> clear= driver.findElements(By.className("a-color-link"));
		 for(WebElement w:clear)
		 {
			 try {
			 w.click();
			 Thread.sleep(4000);
			 }
			 catch(StaleElementReferenceException e) {System.out.println("StaleElementReferenceException");}
		 }
		 

		 shoppingcart.click();
		 Thread.sleep(2000);
		// WebElement end= driver.findElement(By.className("a-color-link"));
		 cl.click();
		 try{
			 double newtotal=Double.parseDouble(totalprice.getText().replace("$", ""));
		 }catch(NumberFormatException ex)
		 {
		 System.out.println("Total is empty.SUCESSFUL");
		 }
	}
	
	public void ItemClick() throws InterruptedException
	{	
		WebElement c2= driver.findElement(By.className("a-color-link"));
		shoppingcart.click();
		Thread.sleep(5000);
		c2.click();
		searchbox.sendKeys(prop.getProperty("carttestdata"));
		submit.click();
		Thread.sleep(5000);
		hellotest.click();
		Thread.sleep(4000);	
		addtocartbtn.click();
		gotocart.click();
		Thread.sleep(9000);	
		String windHandleCurrent = driver.getWindowHandle();
		Thread.sleep(4000);
		img.click();
		Thread.sleep(2000);
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	    for(int i =0;i<windows.size();i++ ) {
	        String aWindow = windows.get(i);
	        if(aWindow != windHandleCurrent) {
	            driver.switchTo().window(aWindow);
	        }
	    }
	  
	/*    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	      
	    driver.close();
	 //   driver.switchTo().window(tabs2.get(0));*/
	}
	public void CloseafterAdd() throws InterruptedException
	{
		shoppingcart.click();
		Thread.sleep(8000);
		WebElement clear= driver.findElement(By.className("a-color-link"));
		clear.click();
		Thread.sleep(3000);
		
	searchbox.sendKeys(prop.getProperty("paginationtestdata"));
	submit.click();
	Thread.sleep(3000);
	hellotest.click();
	Thread.sleep(4000);
	addtocartbtn.click();
	gotocart.click();
	Thread.sleep(4000);
	
	String number1=numberforclosing.getText().split(" ")[1];

	driver.close();
	Thread.sleep(3000);
	
	try {
		WebDriverManager.chromedriver().setup();
		/*("webdriver.chrome.driver","chromedriver.exe");*/
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
	log.clickbutton1();
	log.typeemail(prop.getProperty("email"));
	log.continueSignIn();
	log.typepassword(prop.getProperty("password"));
	log.clickbutton2();	
	}catch(NoSuchSessionException e) { }
	Thread.sleep(3000);
	shoppingcart.click();
	Thread.sleep(3000);
	String number2=numberforclosing.getText().split(" ")[1];
	System.out.println(number1); 
	System.out.println(number2); 
	}
}
