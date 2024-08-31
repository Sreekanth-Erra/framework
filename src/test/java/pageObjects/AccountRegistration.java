package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration  extends BasePage{

	public AccountRegistration(WebDriver driver) 
	
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy (xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy (xpath = "//input[@name='agree']")
	WebElement checkboxconfirm;
	
	@FindBy (xpath = "//input[@value='Continue']")
	WebElement continureg;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstname (String fname)
	{
		txtFirstname.sendKeys(fname);
		String s = fname;
		System.out.println(s);
	}
	
	public void setLastname (String Lname)
	{
		txtLastName.sendKeys(Lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
		System.out.println(email);
	}
	public void setTelephone(String telenum)
	{
		telephone.sendKeys(telenum);
	}
	 public void setPassword(String pwd)
	 {
		 txtPassword.sendKeys(pwd);
		 System.out.println(pwd);
	 }
	public void setConfirmPassword(String cpwd)
	{
		txtConfirmPassword.sendKeys(cpwd);
	}
	
	public void click()
	{
		checkboxconfirm.click();
	}
	public void actioncontinue()
	{
		continureg.click();
	}
	
	public String getconfirmsg()
	{
		try {
			return (msgConfirmation.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
}
