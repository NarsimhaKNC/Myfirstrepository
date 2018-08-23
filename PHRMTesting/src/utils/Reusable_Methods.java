package utils;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Reusable_Methods {

	
	WebDriver driver ;
	WebDriverWait wait;

	public Reusable_Methods(WebDriver webdriver) {
		driver=webdriver;
		PageFactory.initElements(webdriver, this);
		wait = new WebDriverWait(driver, 20);
		}
	
	
	public static boolean verify_PageTitle(WebDriver driver, String Title){
		try {
			WebElement element = driver.findElement(By.xpath("//*[@id='pageTitle']"));		
			if(element.getText().equalsIgnoreCase(Title)){
				return true;	
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
		
	}
	
	public static String getRandomString() {
		
        try {
        	String saltStr = "";
			//String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 3) { // length of the random string.
			    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			    salt.append(SALTCHARS.charAt(index));
			}
			saltStr = salt.toString();
			return saltStr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;		
		}
		

    }
	
	public static String getDate(){
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			return dateFormat.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	
	
	public static String generateRepeatingString(char c, Integer n) {
	    try {
			StringBuilder b = new StringBuilder();
			for (Integer x = 0; x < n; x++)
			    b.append(c);
			return b.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void scr_InDoc(String str){
	    try {
			XWPFDocument docx = new XWPFDocument();
			XWPFRun run = docx.createParagraph().createRun();
			FileOutputStream out = new FileOutputStream(".\\Screenshots\\"+str+".docx");
			try {
				captureScreenShot(docx,run,out);
				docx.write(out);
	            out.flush();
	            out.close();
	            docx.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	 public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out) throws Exception {

	        String screenshot_name = System.currentTimeMillis() + ".png";
	    
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        		
//	        		createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        File file = new File("./Screenshots/" + screenshot_name);
	        ImageIO.write(image, "png", file);
	        InputStream pic = new FileInputStream("./Screenshots/"+screenshot_name);
	        run.addBreak();
	       
	        run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(450), Units.toEMU(450));
	        pic.close();	        
	        file.delete();
	        
	    }

	 public  void captureScreenShot1() throws Exception {

	        String screenshot_name = System.currentTimeMillis() + ".png";
	    
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        		
//	        		createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        File file = new File("./ScreeShotsForReports/" + screenshot_name);
	        ImageIO.write(image, "png", file);
	        InputStream pic = new FileInputStream("./ScreeShotsForReports/"+screenshot_name);
//	        run.addBreak();
	       
//	        run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(450), Units.toEMU(450));
	        pic.close();	        
	        file.delete();
	        
	    }
	
		public File screenShot(WebDriver driver){
			File screenShotFile = null;
			try{
			 screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 
			}catch(Exception e){}
			return screenShotFile;

		}
		
		
		public  File captureScreenShot1(String obj) throws IOException {
			File screenshotFile=null;
		    try {
				screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshotFile,new File(".\\Screenshots\\"+obj+" "+GetTimeStampValue()+".png"));
				return screenshotFile;
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				return screenshotFile;
			}
		}

		//Creating a method getScreenshot and passing two parameters 
		//driver and screenshotName
		public static String getScreenshot(WebDriver driver) throws Exception {
		                //below line is just to append the date format with the screenshot name to avoid duplicate names		
		                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
				String destination = System.getProperty("user.dir") + "/ScreeShotsForReports/"+dateName+".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
		                //Returns the captured file path
				return destination;
		}

		
		public  void captureScreenShotForReport(String obj) throws IOException {
		    File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(screenshotFile,new File(".\\ScreeShotsForReports\\"+obj+" "+GetTimeStampValue()+".png"));
		}
		public  String GetTimeStampValue()throws IOException{
		    Calendar cal = Calendar.getInstance();       
		    Date time=cal.getTime();
		    String timestamp=time.toString();
		    System.out.println(timestamp);
		    String systime=timestamp.replace(":", "-");
		    System.out.println(systime);
		    return systime;
		}
		
		public void wait_For_Element(String element){
			try {
			
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
			} catch (Exception e) {
				System.out.println("Failed to find the element");
			}
			
		}
		
		
		public void wait_For_Element(WebElement element){
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {				
				System.out.println("Failed to find the element");
			}
			
		}

}
