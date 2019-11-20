package testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void logintest() throws IOException {
		
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
		
	
		 if(driver.getTitle().equals("Guru99 Bank Manager HomePage1234")){ 
			 Assert.assertTrue(true); 
			 logger.info("Login test passed");
		 } 
		 else {
			 
		 captureScreen(driver, "logintest");
		 Assert.assertTrue(false); 
		 logger.info("Login test failed");
		 }
		 
	}
	
}
 