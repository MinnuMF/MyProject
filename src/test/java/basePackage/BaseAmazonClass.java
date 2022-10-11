package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import utility.TimeUtils;

public class BaseAmazonClass {
	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	public BaseAmazonClass()
	{
	try {
		FileInputStream file= new FileInputStream("C:\\Users\\minnu\\eclipse-workspace\\AmazonProject\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		}
		catch(FileNotFoundException e){					
		e.printStackTrace();
		}
		catch(IOException a) {							
		a.printStackTrace();
		}
	}

	public static void initiate()
	{
		
	/*	driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.get("https://www.amazon.ca/");
	}*/
		String browsername=prop.getProperty("browser");  	
		if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("Chrome"))
		{
		//	ChromeDriverManager.getInstance().setup();
			WebDriverManager.chromedriver().setup();
			/*("webdriver.chrome.driver","chromedriver.exe");*/
			driver=new ChromeDriver();
	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}
	
		
	
}
