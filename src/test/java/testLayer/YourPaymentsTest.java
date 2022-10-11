package testLayer;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomSignIn;
import pompackage.PomYourAddress;
import pompackage.PomYourPayments;
import utility.TimeUtils;

public class YourPaymentsTest extends BaseAmazonClass {
	
	PomSignIn log;
	PomYourPayments pay;
	
	public YourPaymentsTest()
	{
		super();

	}
	@BeforeClass
	public void SignIn() throws InterruptedException
	{
		initiate();
		log=new PomSignIn();
		pay=new PomYourPayments();
		log.clickbutton1();
		Thread.sleep(1000);
		log.typeemail(prop.getProperty("email"));
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		log.clickbutton2();	
		
	}

	@Test(priority= 1) 
	public void YourPaymentbutton() throws InterruptedException
	{
		pay.ClickbtnforPayment();
		pay.YourPayment();
		
	}
	@Test(priority= 2) 
	public void CardDetails() throws InterruptedException
	{
	/*	pay.Cardnum(prop.getProperty("cardno"));
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		Thread.sleep(2000);
		pay.Cardname(prop.getProperty("nameOncard"));
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		Thread.sleep(2000);*/
		pay.Expiry();
		Thread.sleep(2000);
	}
	@AfterClass
	public void close()
	{
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.MINUTES); 
		driver.close();
	}
	
}
