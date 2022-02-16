package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseDriver {


	public String baseURL="https://www.phptravels.net/login";
	public String username="admin@phptravels.com";
	public String password="demoadmin";
	public static WebDriver driver;
	public static Logger logger;
	
	
	


    @BeforeMethod
	public void setUp() {
		
		logger = Logger.getLogger(baseDriver.class); //Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger

		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		
		
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver ,String  tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
		
		
		
		
		
		
	}
}


