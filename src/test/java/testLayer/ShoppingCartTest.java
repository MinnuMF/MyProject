package testLayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomShoppingCart;
import pompackage.PomSignIn;


public class ShoppingCartTest extends BaseAmazonClass {

	PomSignIn  log;
	PomShoppingCart shop;
	public ShoppingCartTest()
	{
		super();
		
		
	}
	@BeforeClass
	public void SignIn() throws InterruptedException
	{
		initiate();
		log=new PomSignIn();
		shop=new PomShoppingCart();
		log.clickbutton1();
		log.typeemail(prop.getProperty("email"));
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		log.clickbutton2();	
	}	
	@Test(priority=1, groups="ShoppingCart")
	public void Click() throws InterruptedException
	{
		shop.AddItem();
	}
	
	@Test(priority=2, groups="ShoppingCart")
	public void QuantityIncrease() throws InterruptedException
	{
		shop.IncreaseQuantity();
	}
	@Test(priority=3, groups="ShoppingCart")
	public void SameItemAddition() throws InterruptedException
	{
		shop.SameItemMultipleTimes();
	}
	@Test(priority=4, groups="ShoppingCart")
	public void differentItems() throws InterruptedException
	{
		shop.DifferentItemMultipleTime();
	}
	@Test(priority=5, groups="ShoppingCart")
	public void RemoveOneItem() throws InterruptedException
	{
		shop.RemoveItem();
	}
	@Test(priority=6, groups="ShoppingCart")
	public void RemoveallItems() throws InterruptedException
	{
		shop.RemoveAll();
	}
	@Test(priority=7, groups="ShoppingCart")
	public void ClickOnItem() throws InterruptedException
	{
		shop.ItemClick();
	}
	@Test(priority=8, groups="ShoppingCart")
	public void BrowserClosing() throws InterruptedException
	{
		shop.CloseafterAdd();
		
	}

	@AfterClass
	public void close()
	{
		driver.close();
	}
	
}
