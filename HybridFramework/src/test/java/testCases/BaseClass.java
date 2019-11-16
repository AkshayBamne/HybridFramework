package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String BaseUrl="http://demo.guru99.com/v4/index.php";
	//public String BaseUrl="http://demo.guru99.com/Agile_Project/Agi_V1/";
	public String username="mngr233258";
	public String password="AgUhUru";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
	
		driver=new ChromeDriver();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
}
 