package pompackage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import basePackage.BaseAmazonClass;
import utility.TimeUtils;

public class PomSearchSortFilter extends BaseAmazonClass {

	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchbox;
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]") WebElement submit;
	
	
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]") WebElement image;
	
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]/span[1]/span[2]/span[2]") WebElement price;
	@FindBy(xpath=" //body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/span[1]/a[1]/i[1]") WebElement rating;
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[2]/a[1]/span[1]") WebElement reviewno;
	@FindBy(xpath="//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]") WebElement numofprod;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(xpath="//*[@id=\"a-autoid-0-announce\"]") WebElement sorting;
	@FindBy(xpath="//*[@id=\"s-result-sort-select_0\"]") WebElement popular;
	@FindBy(xpath="//*[@id=\"s-result-sort-select_1\"]") WebElement pricelow;
	@FindBy(xpath="//*[@id=\"s-result-sort-select_2\"]") WebElement pricehigh;
	@FindBy(xpath="//*[@id=\"s-result-sort-select_3\"]") WebElement ratingsort;
	@FindBy(xpath="//*[@id=\"s-result-sort-select_4\"]") WebElement newest;

	
	@FindBy(xpath="//span[contains(text(),'Last 90 days')]") WebElement arrival;
	@FindBy(linkText="& Up") WebElement rate;
	@FindBy(xpath="//span[contains(text(),'shirt')]") WebElement searchoption;
	@FindBy(css="#p_n_specials_match\\/21224829011 > span > a > span") WebElement deals;
//	@FindBy(xpath="//span[contains(text(),'All Discounts')or contains(text(),'Today's Deals')orcontains(text(),'Deals') ]") WebElement deals;
	@FindBy(xpath="//span[starts-with(text(),'Calvin') or starts-with(text(),'Tommy')or starts-with(text(),'Wrangler')or starts-with(text(),'Amazon')or starts-with(text(),'Under')]") WebElement brand;
	@FindBy(xpath="//span[contains(text(),'Under $25')or contains(text(),'$25 to $50') or contains(text(),'$50 to $100') ]") WebElement amountfilter;
	@FindBy(xpath="//span[contains(text(),'Availability')or contains(text(),'Include out of stock')]") WebElement availability;
	@FindBy(xpath="//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")WebElement nextButton;
SoftAssert ass;
Actions act;	
	public PomSearchSortFilter()
	{
				
		PageFactory.initElements(driver, this);  //initialize all elements located at @FindBy
		act=new Actions(driver);
		ass=new SoftAssert();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
	
	}
	public void SearchingOptions(String searchdata) 
	{

	searchbox.sendKeys(searchdata);
//	obj.pressEnter();
	submit.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)", "");
	
	boolean result1= searchoption.isDisplayed();
	System.out.println("Relevant produuct found:"+result1); 
	
	act.moveToElement(searchoption).build().perform();
	searchoption.click();
	}
	
	public void ProductInfo()
	{

	searchbox.clear();
	searchbox.sendKeys(prop.getProperty("searchdata1"));
	submit.click();
	driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
	boolean result1= image.isDisplayed();
	System.out.println("Image:"+result1); 	    
	boolean result2= searchoption.isDisplayed();
	System.out.println("Name:"+result2); 
	boolean result3= price.isDisplayed();
	System.out.println("Price:"+result3); 
	boolean result4= rating.isDisplayed();
	System.out.println("Rating:"+result4); 
	boolean result5= reviewno.isDisplayed();
	System.out.println("Number of reviews:"+result5); 
	}
	
	public void PerpageProducts()
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		String result1= numofprod.getText();
		System.out.println("Default Number of pages:"+result1); 
		ass.assertEquals(result1,"1-60 of over 100,000 results for"); 
		ass.assertAll(); 
	
		
		}
	
	public void Nextbutton() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)", "");
		Thread.sleep(3000);
		boolean result= nextButton.isEnabled();
		System.out.println("Next Button Enabled:"+result);
		nextButton.click();
	}
	public void SortPrice() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		List<WebElement>beforefilterPrice=driver.findElements(By.className("a-price-whole"));
		//List<String> beforeFilterPriceList= new ArrayList<String>();
		List<Integer> beforeFilterPriceList= new ArrayList<Integer>();
		for(WebElement w: beforefilterPrice) {
		//	System.out.println(w.getText());
			String s= w.getText();
			int count= Integer.parseInt(s);
	//		System.out.println(count);
			beforeFilterPriceList.add(count);
			
		}
		Thread.sleep(6000);
		sorting.click();
		Thread.sleep(2000);
		pricelow.click();
		Thread.sleep(5000);
		
		List<WebElement> afterfilterPrice=driver.findElements(By.className("a-price-whole"));
		List<Integer> afterFilterPriceList= new ArrayList<Integer>();
	//	List<String> afterFilterPriceList= new ArrayList<String>();
		for(WebElement w: afterfilterPrice) {
		//	System.out.println(w.getText());
			String s= w.getText();
			int count= Integer.parseInt(s);
	//		System.out.println(count);
			afterFilterPriceList.add(count);
	
	//		System.out.println(afterFilterPriceList);
		//	afterFilterPriceList.add(Double.valueOf(w.getText()));
			//afterFilterPriceList.add(Double.valueOf(w.getText().replace("$","")));
		}
		
		Collections.sort(beforeFilterPriceList);							//ASCENDING-LOW TO HIGH
		ass.assertEquals(beforeFilterPriceList,afterFilterPriceList);		
		Thread.sleep(4000);
		
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		Thread.sleep(6000);
		sorting.click();
		Thread.sleep(2000);
		pricehigh.click();
		List<WebElement> afterfilterPrice1=driver.findElements(By.className("a-price-whole"));
		List<Integer> afterFilterPriceList1= new ArrayList<Integer>();
		for(WebElement w: afterfilterPrice1) {
			String s= w.getText();
			int count= Integer.parseInt(s);
			afterFilterPriceList1.add(count);	
		}
		Collections.reverse(beforeFilterPriceList);
		ass.assertEquals(beforeFilterPriceList,afterFilterPriceList1);		
		Thread.sleep(4000);
	}
	
	public void SortReview() throws InterruptedException
	{
	searchbox.clear();
			searchbox.sendKeys(prop.getProperty("searchdata1"));
			submit.click();
			driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
			List<WebElement>beforefilterRating=driver.findElements(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[3]/span[2]/a"));
			
			List<Integer> beforeFilterRatingList= new ArrayList<Integer>();
			for(WebElement w: beforefilterRating) {
				System.out.println(w.getText());
				String s= w.getText();
				String numberOnly= s.replaceAll("[^0-9]", "");
		//		System.out.println(numberOnly);
				int count= Integer.parseInt(numberOnly);
		//		System.out.println(count);
				beforeFilterRatingList.add(count);
		//		System.out.println("------------------");
//				System.out.println(beforeFilterRatingList);
				//	beforeFilterPriceList.add(Double.valueOf(w.getText()));
				//	beforeFilterPriceList.add(Double.valueOf(w.getText().replace("$","")));*/
			}
			Thread.sleep(6000);
			sorting.click();
			Thread.sleep(2000);
			ratingsort.click();
			Thread.sleep(5000);
			
			List<WebElement> afterfilterRating=driver.findElements(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[3]/span[2]/a"));
			List<Integer> afterFilterRatingList= new ArrayList<Integer>();
		//	List<String> afterFilterPriceList= new ArrayList<String>();
			for(WebElement w: afterfilterRating) {
			//	System.out.println(w.getText());
				String s= w.getText();
				String numberOnly= s.replaceAll("[^0-9]", "");
			int count= Integer.parseInt(numberOnly);
		//		System.out.println(count);
				afterFilterRatingList.add(count);
		//		System.out.println("------------------");
		//		System.out.println(afterFilterPriceList);
			//	afterFilterPriceList.add(Double.valueOf(w.getText()));
				//afterFilterPriceList.add(Double.valueOf(w.getText().replace("$","")));
			}
			
			Collections.reverse(beforeFilterRatingList);							
			ass.assertEquals(beforeFilterRatingList,afterFilterRatingList);		
			Thread.sleep(4000);
	}
	
	public void SortingNewest() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		sorting.click();
		Thread.sleep(2000);
		boolean result1= newest.isDisplayed();
		System.out.println("Newest:"+result1); 
		newest.click();
		
	}
	public void SortingPopular() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		sorting.click();
		Thread.sleep(2000);
		boolean result1= popular.isDisplayed();
		System.out.println("Popular:"+result1); 
		popular.click();
	}
	
	public void FilterationNewArrival() throws InterruptedException{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(5000);
		boolean result1= arrival.isDisplayed();
		System.out.println("Filter-Newest Arrivals:"+result1); 
	
	}
	
	public void FilterationRating() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(1000);
		boolean result1= rate.isEnabled();
		System.out.println("Filter-Customer rating:"+result1); 
		
	}
	public void FilterationSaving() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(1000);
		boolean result1= deals.isEnabled();
		System.out.println("Filter-Online Saving:"+result1); 
		
	}

	public void FilterationBrand() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(1000);
		boolean result1= brand.isEnabled();
		System.out.println("Filter-Brand:"+result1); 
		
	}
	public void FilterationPrice() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(1000);
		boolean result1= amountfilter.isEnabled();
		System.out.println("Fliter-Price:"+result1); 
		
	}
	public void FilterationAvaialbility() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("filtertestdata"));
		submit.click();
		Thread.sleep(1000);
		boolean result1= availability.isEnabled();
		System.out.println("Fliter-Avaialbility:"+result1); 
		
	}
	public void Pagination() throws InterruptedException
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("paginationtestdata"));
		submit.click();
		Thread.sleep(3000);
		WebElement nextButton=driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
		
		Thread.sleep(2000);
		String totalCount= driver.findElement(By.xpath("//span[contains(text(),'1-48 of ')]")).getText().split(" ")[2];
		System.out.println(totalCount);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8500);");
	//	js.executeScript("arguments[0].scrollIntoView(true);",next);
	//span[contains(text(),'Neutrogena Mineral Ultra Sheer ')]/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']
		//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']	
		
	List<WebElement>products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']"));
	List<String> productNames=new ArrayList<String>();
	for(WebElement names: products)
	{
		productNames.add(names.getText());
	//	System.out.println(names.getText());
	}

	nextButton.click();
	while(true)
	{
		Thread.sleep(5000);
		next.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,8500);");
	//	js.executeScript("arguments[0].scrollIntoView(true);",next);
		Thread.sleep(3000);
		products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']"));
		for(WebElement names: products)
		{
			productNames.add(names.getText());
	//		System.out.println(names.getText());
		}

		System.out.println("-----------------");
		try {
			nextButton= driver.findElement(By.linkText("Next"));
		}catch(Exception e) {
			System.out.println("NO MORE PRODUCTS");
			break;
		}
		
	}
//	System.out.println("-----------------");
//	System.out.println("NO OF PRODUCTS"+productNames.size());
	System.out.println("DISPLAYED PRODUCTS"+totalCount);
	HashSet<String> set = new HashSet<String>();
    List<String> duplicateList = new ArrayList<String>();
   // List<String> list = Arrays.asList("abc", "b", "c", "d", "b", "c", "abc");
    for (String item :productNames) {
        // If String is not in set, add it to the list and the set.
        if (!set.contains(item)) {              
            set.add(item);
        } else {
            duplicateList.add(item);
        }
    }
    System.out.println("DUPLICATES FOUND");
    for (String element :duplicateList ) {
    	
        System.out.println(element);
       
    }
	

	}
	
	public void SortingandFiltering() throws InterruptedException
	{
		searchbox.clear();
		Thread.sleep(2000);
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		List<WebElement>beforefilterPrice=driver.findElements(By.className("a-price-whole"));
		//List<String> beforeFilterPriceList= new ArrayList<String>();
		List<Integer> beforeFilterPriceList= new ArrayList<Integer>();
		for(WebElement w: beforefilterPrice) {
		//	System.out.println(w.getText());
			String s= w.getText();
			int count= Integer.parseInt(s);
	//		System.out.println(count);
			beforeFilterPriceList.add(count);
	//		System.out.println("------------------");
	//		System.out.println(beforeFilterPriceList);
		//	beforeFilterPriceList.add(Double.valueOf(w.getText()));
		//	beforeFilterPriceList.add(Double.valueOf(w.getText().replace("$","")));
		}
		Thread.sleep(6000);
		sorting.click();
		Thread.sleep(2000);
		pricelow.click();
		Thread.sleep(4000);
		
		boolean result1= rate.isEnabled();
		System.out.println("Filter-Customer rating:"+result1); 
		rate.click();
		Thread.sleep(4000);
	}
	public void SortingFilteringPagination() throws InterruptedException
	{
		searchbox.clear();
		Thread.sleep(2000);
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
		List<WebElement>beforefilterPrice=driver.findElements(By.className("a-price-whole"));
		//List<String> beforeFilterPriceList= new ArrayList<String>();
		List<Integer> beforeFilterPriceList= new ArrayList<Integer>();
		for(WebElement w: beforefilterPrice) {
		//	System.out.println(w.getText());
			String s= w.getText();
			int count= Integer.parseInt(s);
	//		System.out.println(count);
			beforeFilterPriceList.add(count);
	//		System.out.println("------------------");
	//		System.out.println(beforeFilterPriceList);
		//	beforeFilterPriceList.add(Double.valueOf(w.getText()));
		//	beforeFilterPriceList.add(Double.valueOf(w.getText().replace("$","")));
		}
		Thread.sleep(6000);
		sorting.click();
		Thread.sleep(2000);
		pricelow.click();
		Thread.sleep(4000);
		
		boolean result1= rate.isEnabled();
		System.out.println("Filter-Customer rating:"+result1); 
		rate.click();
		
		
	/*	searchbox.sendKeys(prop.getProperty("paginationtestdata"));
		submit.click();*/
		Thread.sleep(3000);
		WebElement nextButton=driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
		
		Thread.sleep(2000);
		String totalCount= driver.findElement(By.xpath("//span[contains(text(),'1-48 of ')]")).getText().split(" ")[2];
		System.out.println(totalCount);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,9000);");
		
		
	List<WebElement>products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']"));
	List<String> productNames=new ArrayList<String>();
	for(WebElement names: products)
	{
		productNames.add(names.getText());
//		System.out.println(names.getText());
	}
//	System.out.println("-----------------");
	nextButton.click();
	while(true)
	{
		Thread.sleep(4000);
		next.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,8500);");
	//	js.executeScript("arguments[0].scrollIntoView(true);",next);
		Thread.sleep(3000);
		products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/parent::a//parent::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']"));
		for(WebElement names: products)
		{
			productNames.add(names.getText());
	//		System.out.println(names.getText());
		}

	//	System.out.println("-----------------");
		try {
			nextButton= driver.findElement(By.linkText("Next"));
		}catch(Exception e) {
	//		System.out.println("NO MORE PRODUCTS");
			break;
		}
		
	}
//	System.out.println("-----------------");
	
   
    
	}
	public void Scrolldown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)", "");
	}
	public void ClickwithExecutor(WebElement element, WebElement driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
		
	}
	public void pressEnter()
	{
		act.sendKeys(Keys.ENTER).build().perform();
	}
	public void preformMouseHover(WebElement element)
	{
		act.moveToElement(element).build().perform();
	}
	public void Search()
	{
		searchbox.clear();
		searchbox.sendKeys(prop.getProperty("searchdata1"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage,TimeUnit.SECONDS); 
	}
	
}
