package CommunFunLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageClass {
	WebDriver driver;
	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;
	}
		@FindBy(xpath="//input[@id='username']")
		WebElement Enter_username;
		@FindBy(xpath="//input[@id='password']")
		WebElement Enter_password;
		@FindBy(name="btnsubmit")
		WebElement click_Login;
		@FindBy(xpath="//button[normalize-space()='Reset']")
		WebElement Click_reset;
		public void verifyLogin(String username,String password)
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.elementToBeClickable(Click_reset));
			this.Click_reset.click();
			this.Enter_username.sendKeys(username);
			this.Enter_password.sendKeys(password);
			this.click_Login.click();
		}
	}


