package CommunFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SuppliersAddClass {
	WebDriver driver;
	public SuppliersAddClass(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="(//a[text()='Suppliers'])[2]")
	WebElement  click_suppliers;
	@FindBy(xpath="//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")
	WebElement click_Add;
	@FindBy(name="x_Supplier_Number")
	WebElement suppliernum;
	@FindBy(id="x_Supplier_Name")
	WebElement suppliername;
	@FindBy(name="x_Address")
	WebElement Address;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement City;
	@FindBy(id="x_Country")
	WebElement Country;
	@FindBy(name="x_Contact_Person")
	WebElement cperson;
	@FindBy(id="x_Phone_Number")
	WebElement Phonenumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement Email;
	@FindBy(name="x_Mobile_Number")
	WebElement Mobilenumber;
	@FindBy(id="x_Notes")
	WebElement Notes;	
	@FindBy(id="btnAction")
	WebElement Click_Add;
	@FindBy(xpath="//button[contains(text(),'OK!')]")
	WebElement click_confirm_ok;
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
	WebElement click_Alert_Add_ok;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement searchpanel;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement searchtextbox;	
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement clickSearchbutton;
	@FindBy(xpath="//table[@id='tbl_a_supplierslist']")
     WebElement webtablepath;
	public String verifySupplier(String suppliername,String Address,String City,String Country,String cperson,String Phonenumber,String Email,String mobilenumber,String Notes) throws Throwable
	{
	String res="  ";
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(click_suppliers));
	this.click_suppliers.click();
	wait.until(ExpectedConditions.elementToBeClickable(click_Add));
	this.click_Add.click();
	wait.until(ExpectedConditions.elementToBeClickable(suppliernum));
	String expectednum=this.suppliernum.getAttribute("value");
		this.suppliername.sendKeys(suppliername);
		this.Address.sendKeys(Address);
		this.City.sendKeys(City);
		this.Country.sendKeys(Country);
		this.cperson.sendKeys(cperson);
		this.Phonenumber.sendKeys(Phonenumber);
		this.Email.sendKeys(Email);
		this.Mobilenumber.sendKeys(mobilenumber);
		this.Notes.sendKeys(Notes);
		this.Click_Add.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(click_confirm_ok));
		this.click_confirm_ok.click();
		wait.until(ExpectedConditions.elementToBeClickable(click_Alert_Add_ok));
		//Thread.sleep(5000);
		this.click_Alert_Add_ok.click();
		//Thread.sleep(5000);
		if(!this.searchtextbox.isDisplayed())
			this.searchpanel.click();
		wait.until(ExpectedConditions.visibilityOf(searchtextbox));
		//Thread.sleep(5000);
		this.searchtextbox.clear();
		this.searchtextbox.sendKeys(expectednum);
		//Thread.sleep(5000);
		this.clickSearchbutton.click();
		wait.until(ExpectedConditions.visibilityOf(webtablepath));
		String actualnum=driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr[1]/td[6]/div/span/span")).getText();
		if(actualnum.equals(expectednum))
		{
			Reporter.log("supplier added::"+expectednum+" "+actualnum);
			res="pass";
		}
		else
		{
			Reporter.log("supplier not  added::"+expectednum+" "+actualnum);
			res="fail";	
		}
		return res;
	}
	
	

}
