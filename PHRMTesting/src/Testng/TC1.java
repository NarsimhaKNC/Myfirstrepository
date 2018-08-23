package Testng;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DataManager;
import utils.Parameters;
import utils.ReusableMethods;
import utils.Reusable_Methods;

public class TC1 {
	static XWPFDocument docx;
	static XWPFRun run;
	static FileOutputStream out;
	String path=null;
	String str=null;
	public WebDriver driver;
	@BeforeTest
	//@Test
	public void initData() {				
		System.out.println();
				
		path = ".\\Testdata\\TC_PHRMBook.xlsx";
		new DataManager(path,"TC_PHRM");
	}
	
	
	
	@BeforeClass

	// Launch the application thru IE browser
	public void launchApplication() throws InvalidFormatException, IOException, AWTException, InterruptedException {

		try {		
			System.setProperty("webdriver.chrome.driver",".\\Browsers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.orangehrm.com");
		} catch (Exception e) {
			System.out.println("Failed to login");
			e.printStackTrace();
		}
	}
	@Test
	public void firstTC() throws InterruptedException, HeadlessException, InvalidFormatException, AWTException, IOException{
		
		
		int row=DataManager.rowNumber;
		for(int i=1;i<row;i++){
			DataManager.readData(i);
			if(Parameters.ExcutionFlag.equalsIgnoreCase("yes")){
				modules.Requestaquote TC1=new modules.Requestaquote(driver);
				TC1.createfrom();
				ReusableMethods.verify_PageTitle(driver,path);
				
				
			
			//RM.captureScreenShot(docx,run,out);
		}
		}
	}
		/*@Test(priority=1)
		public void secondTC(){
			int row1=DataManager.rowNumber;
	for(int j=1;j<row1;j++){
		DataManager.readData1(j);
		if(Parameters.ExcutionFlag.equalsIgnoreCase("N")){
			modules.Requestaquote TC1=new modules.Requestaquote(driver);
			TC1.createfrom();*/
		
	
			
			
		}
		
	
	

	
