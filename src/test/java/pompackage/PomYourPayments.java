package pompackage;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class PomYourPayments extends BaseAmazonClass {

	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span") WebElement hellobtn;  
	@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement paymentsbtn; 
	@FindBy(linkText="Add a payment method") WebElement addpayment; 
	@FindBy(xpath="//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]") WebElement card;
	@FindBy(xpath="//*[@id=\"pp-tgNOOm-13\"]/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div")WebElement cardno;
	@FindBy(css=".a-input-text a-form-normal apx-add-credit-card-account-holder-name-input")WebElement nameOncard;
	@FindBy(id="//*[@id=\"pp-zMdGuS-21\"]/span/span") WebElement month1;
	@FindBy(css=".a-dropdown-link a-active") WebElement month2;
	@FindBy(css=".a-dropdown-prompt") WebElement year1;
	@FindBy(id="a-dropdown-link") WebElement year2;
	
	Actions act= new Actions(driver);
	public PomYourPayments()
	{
				
		PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
	}
	
	public void ClickbtnforPayment()
	{
		hellobtn.click();
		
	}
	public void YourPayment() throws InterruptedException
	{
		String currentPage=driver.getCurrentUrl();

		paymentsbtn.click();
		String newPage = driver.getCurrentUrl();
		if(currentPage.equals(newPage))
		    System.out.println("Failure, not navigated to Payment Page");
		else
		{
		    boolean result1= addpayment.isEnabled();
			System.out.println("Add Payment option:"+result1); 	    
			addpayment.click();
			Thread.sleep(2000);
			card.click();
			Thread.sleep(3000);
			
			
			
		}
	
	}
	public void Cardnum(String num) throws InterruptedException 
	
	{	
		Thread.sleep(2000);
		cardno.sendKeys(num);
		
	}
	public void Cardname(String name) 
	{
		nameOncard.sendKeys(name);
		
	}
	public void Expiry() 
	{
		month1.click();
		month2.click();
		year1.click();
		year2.click();
		
	}
	
}
