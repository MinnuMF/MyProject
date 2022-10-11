package testLayer;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.BaseAmazonClass;
import pompackage.PomSignIn;
import utility.TimeUtils;



public class SignInTest extends BaseAmazonClass {
	
	PomSignIn log;
	
	public SignInTest()
	{
		super();
	}
	
	@BeforeClass
	public void initsetup()
	{
		initiate();
		log=new PomSignIn(); 
	}
	
	@Test(priority=1, groups="SignIn")
	public void VerifySignInbutton()
	{
		log.Verify();
	}
	
	@Test(priority= 2, groups="SignIn")
 
	public void SignIn() throws InterruptedException
	{
		//Thread.sleep(9000);
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS); 
		log.clickbutton1();
		Thread.sleep(2000);
		log.typeemail(prop.getProperty("email"));
		Thread.sleep(2000);
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		Thread.sleep(2000);
		log.clickbutton2();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
	
	
}

