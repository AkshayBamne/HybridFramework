package testCases;

import java.io.IOException;

import org.apache.poi.xssf.XLSBUnsupportedException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pass) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("user name provided");
		lp.setPassword(pass);
		logger.info("password provided");
		lp.clickSubmit();
		
		
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int cocount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String [rownum][cocount];
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<cocount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
			return logindata;
			

	
	
	}

}
