package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Requestaquote {
	WebDriver driver;

	public Requestaquote(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(how=How.XPATH,using="//*[@class='btn-orange btn btn--primary ']")
	public WebElement Req_aQuote_btn;
	
	@FindBy(how=How.ID,using="Form_request_Package")
	public WebElement Package;
	
	
	@FindBy(how=How.ID,using="Form_request_FirstName")
	public WebElement Firstname;   
	
	@FindBy(how=How.ID,using="Form_request_LastName")
	public WebElement Lastname;
	
	@FindBy(how=How.ID,using="Form_request_CompanyName")
	public WebElement CompanyName;
	
	@FindBy(how=How.ID,using="Form_request_NoOfEmployees")
	public WebElement Employees;
	
	@FindBy(how=How.ID,using="Form_request_Industry")
	public WebElement Industry;
	
	
	@FindBy(how=How.ID,using="Form_request_JobTitle")
	public WebElement Title;  
	
	@FindBy(how=How.ID,using="Form_request_BusinessEmail")
	public WebElement BEmail;   
	

	@FindBy(how=How.ID,using="Form_request_ContactPhone")
	public WebElement PhoneNo;  
	
	@FindBy(how=How.ID,using="Form_request_CouponCode")
	public WebElement Couponcode;
	
	@FindBy(how=How.ID,using="Form_request_Country")
	public WebElement Country;
	
	@FindBy(how=How.ID,using="Form_request_State")
	public WebElement State;
	
	/*@FindBy(how=How.ID,using="identifierId")
	public WebElement username;
	
	@FindBy(how=How.XPATH,using="//content[contains(.,'Next')]")
	public WebElement next;
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='password']/div[1]/div[1]/div/input")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//content[contains(.,'Next')]")
	public WebElement next1;
	
	*/
}
