package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		//object of Logger class for logging
				logger= Logger.getLogger(BaseClass.class);
				PropertyConfigurator.configure("log4j.properties");
		
//		if(br.equals("chrome")) {
//		
//		String projectPath=System.getProperty("user.dir");
//		System.out.println(projectPath);
//		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
//		driver=new ChromeDriver();
//		}
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
			driver=new ChromeDriver();
			}
//		 else if (br.equals("firefox")) {
//
//			System.setProperty("webdriver.firefox.driver", projectPath+"/Drivers/geckodriver.exe");
//		}
//		 else if (br.equals("ie")) {
//				
//				String projectPath=System.getProperty("user.dir");
//				System.out.println(projectPath);
//				System.setProperty("webdriver.ie.driver", projectPath+"/Drivers/IEDriverServer.exe");
//		}
		
		driver.get(BaseUrl);	
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
}
 