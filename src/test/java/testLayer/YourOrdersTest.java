package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomSignIn;
import pompackage.PomYourOrders;
import utility.TimeUtils;

public class YourOrdersTest extends BaseAmazonClass{

	PomYourOrders order;
	PomSignIn  log;
	public YourOrdersTest()
	{
		super();

	}
	@BeforeClass
	public void SignIn() throws InterruptedException
	{
		initiate();
		log=new PomSignIn();
		order=new PomYourOrders(); 
		log.clickbutton1();
		log.typeemail(prop.getProperty("email"));
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		log.clickbutton2();	
	}
	
	@Test(priority= 1, groups="YourOrders") 
	public void Ordermethod() throws InterruptedException
	{
		
		order.buttonorders1();
		order.orderHistory();
			
	}
	@Test(priority=2, groups="YourOrders")
	public void PastOrder1() throws InterruptedException
	{
		
		order.buttonorders1();
		order.orderHistory();
		order.Orders1();
			
	}
	
	@Test(priority=3, groups="YourOrders")
	public void Buyagain() throws InterruptedException
	{
		order.buttonorders1();
		order.orderHistory();
		order.BuyAgain();
	}
	@Test(priority=4, groups="YourOrders")
	public void Notshipped() throws InterruptedException
	{
		
		order.buttonorders1();
		order.orderHistory();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		order.NotYetShipped();
			
	}
	@Test(priority=5, groups="YourOrders")
	public void Cancel() throws InterruptedException
	{
		order.buttonorders1();
		order.orderHistory();
	//	Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		order.Cancelled();
	}
		
	@AfterClass
	public void close()
	{
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.MINUTES); 
		driver.close();
	}
	
	
	
}




