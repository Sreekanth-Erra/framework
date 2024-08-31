package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountrRgistration extends BaseClass {
	
	@Test (groups = {"Regression","Master"})
	public void  verify_account_registration()
	{
		logger.info("Starting");
		
		logger.info("Clicking on HomePage");
		
		try {
			
		
		HomePage hp = new HomePage(driver);
		
		hp.clickAccount();
		
		logger.info("***** Registration started *****");
		hp.clickregister();
		
		AccountRegistration regpage = new AccountRegistration(driver);
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+ "@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String Password = alphanumeric();
		regpage.setPassword(Password);
		regpage.setConfirmPassword(Password);
		regpage.click();
		regpage.actioncontinue();
		
		logger.info("Validating Expected Message");
		String confmsg = regpage.getconfirmsg();
		if (confmsg.equals("Your Account Has Been Created"))
		{
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("Test Failed");
			logger.debug("Test Failed-Debug");
		}
		
		}
		
		catch (Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("Registration Process Completed");
	}
	@AfterClass (groups = {"Regression","Master"})
	public void teardown()
	{
		driver.close();
	}
}
