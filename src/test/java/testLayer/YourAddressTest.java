package testLayer;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomSignIn;
import pompackage.PomYourAddress;
import utility.TimeUtils;


public class YourAddressTest extends BaseAmazonClass {
	
	PomSignIn log;

	PomYourAddress tes;
	
	public YourAddressTest()
	{
		super();

	}
	@BeforeClass
	public void SignIn() throws InterruptedException
	{
		initiate();
		log=new PomSignIn();
		tes=new PomYourAddress();
		log.clickbutton1();
		Thread.sleep(1000);
		log.typeemail(prop.getProperty("email"));
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		log.clickbutton2();	
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
	}
		

	@Test(priority=1,groups="YourAddress")
	public void YourAddressButton()
	{
		tes.ClickbtnforAddress();
		tes.YourAddress();
	}
		
	@Test(priority= 2) 
	public void Addressmethod() throws InterruptedException
	{
		
		tes.ClickbtnforAddress();
		tes.YourAddress();
		tes.Country();
		tes.Name();
		tes.Phone();
		tes.Address();
		tes.City();
		tes.Province();
		tes.PostalCode();
		tes.CheckboxforDefaultAddress();
		tes.Submit();
		tes.OrginalAddress();
		tes.SuggestedAddress();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		tes.SaveAddress();
		Thread.sleep(1000);
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
}
