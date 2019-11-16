package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void logintest() {
		
		driver.get(BaseUrl);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		if(driver.getTitle().equals("home title")){
			Assert.assertTrue(true);
		}
		else {
			
			Assert.assertTrue(false);
		}
	}
	
}
 