package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Parameters;

public class Requestaquote {
	WebDriver driver;
	pages.Requestaquote arguep;
	
	public Requestaquote(WebDriver webdriver){
		driver=webdriver;
		arguep=new pages.Requestaquote(driver);
		
	   
	}
	public void createfrom(){
		
		arguep.Req_aQuote_btn.click();
		arguep.Package.sendKeys(Parameters.Package);
		arguep.Firstname.sendKeys(Parameters.FirstName);
		arguep.Lastname.sendKeys(Parameters.LastName);
		arguep.CompanyName.sendKeys(Parameters.CompanyName);
		Select sle=new Select(arguep.Employees);
		sle.selectByVisibleText(Parameters.Val2.toString());
		
		//sle.selectByVisibleText(Integer.toString(Parameters.Employees));
		//arguep.Employees.click();
		Select sle1=new Select(arguep.Industry);
		sle1.selectByVisibleText(Parameters.Industry);
		arguep.Industry.sendKeys(Parameters.Industry);
		arguep.Title.sendKeys(Parameters.Title);
		arguep.BEmail.sendKeys(Parameters.BEmail);
		arguep.PhoneNo.sendKeys(Parameters.Val1.toString());
		arguep.Couponcode.sendKeys(Parameters.Couponcode);
		arguep.Country.sendKeys(Parameters.Country);
		arguep.State.sendKeys(Parameters.State);
		
		driver.get("https://www.orangehrm.com");
		/*arguep.username.sendKeys(Parameters.username);
		arguep.next.click();
		arguep.password.sendKeys(Parameters.password);
		arguep.next1.click();*/
		
		
		
		
	}

}
