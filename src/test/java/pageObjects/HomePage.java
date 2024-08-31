package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
		
		WebDriver driver;
		
		public HomePage(WebDriver driver)
		{
			super(driver);
		}
		
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
@FindBy (xpath = ("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"))
WebElement lnkaccount;

@FindBy (xpath = ("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"))
WebElement clickRegister;

@FindBy (xpath = ("//a[normalize-space()='Login']"))
WebElement clicklogin;

public void clickAccount()
{
	lnkaccount.click();
}

public void clickregister()
{
	clickRegister.click();
}
public void clickLogin()
{
	clicklogin.click();
}

}



