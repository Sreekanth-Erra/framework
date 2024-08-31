package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") //getting data providers from different class
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		
		logger.info("**** Starting TC_003LoginDDT execution");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		HomePage hp1 = new HomePage(driver);
		hp1.clickLogin();
		
		
		//Login Page
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		//My Account
		MyAccount mac = new MyAccount(driver);
		boolean targetpage = mac.ismyaccountpageexist();
		Assert.assertTrue(targetpage);
		
		/*  Condition 1 : Data is valid - Login Successful- Test is Passed - Logout 
		 * 				 - Login failed - Test is fail 
		 * Condition 2: Data is invalid - Login Successful- Test is filed - Logout 
		 * 				 - Login failed - Test is Passed */
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (targetpage == true)
			{
				mac.clicklogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if (targetpage == true)
			{
				mac.clicklogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}	
			catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_003LoginDDT execution");
		}
	@AfterClass (groups = "Datadriven")
	public void teardown()
	{
		driver.close();
}
	}

