package modules;

import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reporting.Reports;
import utils.Parameters;
import utils.Reusable_Methods;

public class Login {
	
	Parameters parameter = new Parameters();
	WebDriver driver;
	pages.Login l;
	ExtentTest test;
	Reusable_Methods RM;

	
	public Login(WebDriver webdriver, ExtentTest test1) {
		driver=webdriver;
		l=new pages.Login(driver);
		test = test1;
		RM = new Reusable_Methods(driver);
	}
	
	
	public void populateLogin(XWPFDocument docx,XWPFRun run,FileOutputStream out) throws InterruptedException{	
	try {	
		l.username.sendKeys(parameter.userName);
		l.passWord.sendKeys(parameter.password);
		RM.captureScreenShot(docx,run,out);		
		l.login.click();
		
		
		Thread.sleep(3000);
		test.pass("Sucessfully Loged In");
	} catch (Exception e) {
		System.out.println("Failed to Login");
		e.printStackTrace();
	}
}
}


