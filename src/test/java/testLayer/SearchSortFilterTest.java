package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BaseAmazonClass;
import pompackage.PomSearchSortFilter;
import pompackage.PomSignIn;
import pompackage.PomYourAddress;
import pompackage.PomYourOrders;
import testdata.ExcelSheetSearch;
import utility.TimeUtils;
//import testdata.ExcelSheetSearch;

public class SearchSortFilterTest extends BaseAmazonClass{

	PomSearchSortFilter ssf;
	SoftAssert ass;
	PomSignIn  log;
	public SearchSortFilterTest()
	{
		super();
		
	}
	@BeforeClass
	public void SignIn() throws InterruptedException
	{
		initiate();
	//	log=new PomSignIn();
		ssf=new PomSearchSortFilter();
	/*	log.clickbutton1();
		Thread.sleep(1000);
		log.typeemail(prop.getProperty("email"));
		log.continueSignIn();
		log.typepassword(prop.getProperty("password"));
		log.clickbutton2();	*/
		
		
	}
	
	
/*	@DataProvider
	public Object[][] Searchdata()   //dataprovider read data from excel sheet
	{
		Object result[][]=ExcelSheetSearch.readdata("Sheet1");
		return result; 		 //data stored in result
	}*/
	
	@Test(priority=1,groups="Search")			
	public void Searching() throws InterruptedException   
	{
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		ssf.SearchingOptions(prop.getProperty("searchdata1"));
		Thread.sleep(2000);
		
	}
	@Test(priority=2,groups="Search")
	public void ProductInformation() throws InterruptedException
	{
		ssf.ProductInfo();
		Thread.sleep(3000);
		
	}
	@Test(priority=3,enabled=false)   //number of products per page is different
	public void PerPageProductNumber() throws InterruptedException
	{
		ssf.PerpageProducts();
		Thread.sleep(3000);
	}	
	
	@Test(priority=4)
	public void Next() throws InterruptedException
	{
		ssf.Nextbutton();
	}
	@Test(priority=5,groups="Sort")
	public void SortPriceLowandHigh() throws InterruptedException
	{
		ssf.SortPrice();
	}
	@Test(priority=6,groups="Sort")
	public void SortRating() throws InterruptedException
	{
		ssf.SortReview();
	}
	@Test(priority=7,groups="Sort")
	public void SortNewest() throws InterruptedException
	{
		ssf.SortingNewest();
		Thread.sleep(3000);
	}
	@Test(priority=8,groups="Sort")
	public void SortPopular() throws InterruptedException
	{
		ssf.SortingPopular();
		Thread.sleep(3000);
	}
	
	@Test(priority=9,groups="Sort")
	public void FilterNewArrivals() throws InterruptedException
	{
		ssf.FilterationNewArrival();	//error
	}
	@Test(priority=10,groups="Filter")
	public void FilterRating() throws InterruptedException
	{
		ssf.FilterationRating();
	}
	@Test(priority=11,groups="Filter")
	public void FilterSavings() throws InterruptedException
	{
		ssf.FilterationSaving();
	}
	@Test(priority=12,groups="Filter")
	public void FilterBrand() throws InterruptedException
	{
		ssf.FilterationBrand();
	}
	@Test(priority=13,groups="Filter")
	public void FilterPrice() throws InterruptedException
	{
		ssf.FilterationPrice();
	}
	@Test(priority=14,groups="Filter")
	public void FilterAvailability() throws InterruptedException
	{
		ssf.FilterationAvaialbility();
	}
	@Test(priority=15,groups="Pagination")
	public void PaginationCheck() throws InterruptedException
	{
		ssf.Pagination();
	}
	
	@Test(priority=16,groups="SortandFilter")
	public void SortandFilter() throws InterruptedException
	{
		ssf.SortingandFiltering();
	}
	@Test(priority=17,groups="SortFilterPagination")
	public void SortFilterPagination() throws InterruptedException
	{
		ssf.SortingFilteringPagination();
	}
	
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
