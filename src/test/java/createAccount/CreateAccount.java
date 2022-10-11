package createAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class CreateAccount {

	
	WebDriver driver;
	WebDriver driver1;
	SoftAssert obj;
	
	
	@BeforeSuite
	public void diversetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	 	
	@BeforeClass  
	public void before() {
	
		ChromeDriverManager.getInstance().setup();
		WebDriverManager.chromedriver().setup();
		/*("webdriver.chrome.driver","chromedriver.exe");*/
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26gclid%3DEAIaIQobChMIzcWCuPer-gIV7evjBx0G1wYPEAAYASAAEgIiVPD_BwE%26hvadid%3D231036067831%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9000899%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3De%26hvrand%3D3126072953661256540%26hvtargid%3Dkwd-296458789801%26hydadcr%3D20061_10090748%26ref%3Dpd_sl_wsq6s5b26_e%26tag%3Dhydcaabkg-20%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		}
			
		
	@Test(priority=1, groups="CreateAccount")
	public void Account() throws InterruptedException { 
	
		driver.findElement(By.id("ap_customer_name")).sendKeys("annu");
		driver.findElement(By.id("ap_email")).sendKeys("annu@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Annu@1");
		driver.findElement(By.id("ap_password_check")).sendKeys("Annu@1");
		driver.findElement(By.id("ap_customer_name")).sendKeys("annu");
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		}
}	
