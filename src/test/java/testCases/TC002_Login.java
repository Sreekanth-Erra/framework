package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_Login extends BaseClass{
	
	@Test (groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("Starting Login Test ");
		
	try {
	//Home Page
	
	HomePage hp = new HomePage(driver);
	hp.clickAccount();
	HomePage hp1 = new HomePage(driver);
	hp1.clickLogin();
	
	
	//Login Page
	LoginPage lp = new LoginPage(driver);

	lp.setEmail(p.getProperty("username"));
	lp.setPassword(p.getProperty("password"));
	lp.clicklogin();
	
	//My Account
	MyAccount mac = new MyAccount(driver);
	boolean targetpage = mac.ismyaccountpageexist();
	Assert.assertTrue(targetpage);
	}
	catch (Exception e) {
		Assert.fail();
}
}
	@AfterClass (groups = {"Sanity","Master"})
	public void teardown()
	{
		driver.close();
}
}