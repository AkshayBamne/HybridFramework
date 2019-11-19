package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
//	public String BaseUrl="http://demo.guru99.com/v4/index.php";
//	public String username="mngr233258";
//	public String password="AgUhUru";
//	public static WebDriver driver;
	
	public String BaseUrl=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//object of Logger class for logging
		logger= Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
}
 