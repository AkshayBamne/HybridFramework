package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void logintest() {
		
		//driver.get(BaseUrl);
		logger.info("URL is opened");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername(username);
		logger.info("Entered username");
		
		loginPage.setPassword(password);
		logger.info("Entered password");
		
		loginPage.clickSubmit();
		logger.info("Clicked submit button");
		
		System.out.println(driver.getTitle());
		
	
		 if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){ 
			 Assert.assertTrue(true); 
			 logger.info("Login test passed");
		 } 
		 else {
		 Assert.assertTrue(false); 
		 logger.info("Login test failed");
		 }
		 
	}
	
}
 