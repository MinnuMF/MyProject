package pompackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import basePackage.BaseAmazonClass;
import utility.TimeUtils;

public class PomYourOrders extends BaseAmazonClass {

	
	//object repository
		
		@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]") WebElement hellobtn;  
		@FindBy(xpath="//h2[contains(text(),'Your Orders')]") WebElement orderbtn; 	
		@FindBy(id="a-autoid-1") WebElement dropdown1;
		@FindBy(xpath="//a[contains(text(),'Cancelled Orders')]") WebElement cancelled;
		@FindBy(xpath="//span[contains(text(),'past 3 months')]") WebElement defaultoption;
		@FindBy(xpath="//a[@id='time-filter_0']") WebElement optionmonth;
		@FindBy(xpath="//a[@id='orderFilter_2']") WebElement optionyear;
		@FindBy(xpath="//a[@id='time-filter_3']") WebElement optionarchived;
		@FindBy(xpath="//body/div[@id='a-page']/section[1]/div[1]/div[3]/ul[1]/li[2]/a[1]") WebElement buyagain;
		@FindBy(linkText="Not Yet Shipped")WebElement shipped1;
		@FindBy(linkText="Cancelled Orders")WebElement cancelled1;
		
		Actions act= new Actions(driver);
	
		//List<WebElement> options = driver.findElements(By.id("a-autoid-1"));	
		public PomYourOrders()
		{
					
			PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
		}
		
		
		public void buttonorders1()
		{
		
			hellobtn.click();
		}
					
		public void orderHistory()
		{
			String currentPage=driver.getCurrentUrl();
			orderbtn.click();
			String newPage = driver.getCurrentUrl();
			if(currentPage.equals(newPage))
			System.out.println("Failure, not navigated to Order history page");
		}
	
		public void Orders1() throws InterruptedException
		{
			driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
			defaultoption.click();
			optionmonth.click();
		
	/*	for(WebElement option : options) {
	 
		if (option.getText().contains("past 3 months")) 
			{
			option.click();
			break;
			}	
		}*/
		}
			
		public void Orders2()
		{
			
			defaultoption.click();
			optionyear.click();
		}
	
		public void Orders3()
		{
			defaultoption.click();
			optionarchived.click();
		}
	
		public void BuyAgain() throws InterruptedException
		{
			boolean result= buyagain.isEnabled();
			buyagain.click();
			System.out.println("Inside BuyAgain:"+result);
		}
		
		public void NotYetShipped() throws InterruptedException
		{
			act= new Actions(driver);		
			act.moveToElement(shipped1).build().perform();
			boolean result= shipped1.isEnabled();
			Thread.sleep(1000);
			shipped1.click();
			System.out.println("Inside Shipped:"+result);
			
		}
		public void Cancelled() throws InterruptedException
		{
	
			act= new Actions(driver);		
			act.moveToElement(cancelled1).build().perform();
			boolean result= cancelled.isEnabled();
			Thread.sleep(1000);
			cancelled1.click();
			System.out.println("Inside Cancelled:"+result);
		}
		
		
}
