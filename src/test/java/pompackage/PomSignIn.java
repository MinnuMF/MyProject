package pompackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseAmazonClass;
import utility.TimeUtils;

public class PomSignIn extends BaseAmazonClass{
	
//object repository

	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement SignInbtn1;
	@FindBy(id="ap_email") WebElement Email;    
	@FindBy(id="continue") WebElement Continue;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="signInSubmit") WebElement SignInbtn2;

	public PomSignIn()
	{
				
		PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
	}
	
	public void Verify()  
	{
		boolean result1= SignInbtn1.isDisplayed();
		 System.out.println("SignIn button avaialble "+result1);
	}
	
	
	public void clickbutton1() throws InterruptedException
	{
		//driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS); 
		Thread.sleep(8000);
		SignInbtn1.click();
	}
	
	public void typeemail(String name)
	{
		
		Email.sendKeys(name);	
		
	}
	public void continueSignIn()
	{
		
		Continue.click();
	}
	public void typepassword(String pass)
	{
		
		Password.sendKeys(pass);	
	}
	public void clickbutton2()
	{
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS); 
		SignInbtn2.click();
	}
	
	

	
	
	

	

}
