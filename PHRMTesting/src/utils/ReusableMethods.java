package utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ReusableMethods {
	WebDriver driver;
	public ReusableMethods(WebDriver webdriver) {
		WebDriver driver ;
		driver = webdriver;
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver",".\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com");
		//this.takeSnapShot(driver,"c://PhrmScreenshot1.docx") ;   
	}
	public static boolean verify_PageTitle(WebDriver driver, String Title){
		try {
			WebElement element = driver.findElement(By.xpath("//*[@class='btn-orange btn btn--primary ']"));		
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
	public  String GetTimeStampValue()throws IOException{
	    Calendar cal = Calendar.getInstance();       
	    Date time=cal.getTime();
	    String timestamp=time.toString();
	    System.out.println(timestamp);
	    String systime=timestamp.replace(":", "-");
	    System.out.println(systime);
	    return systime;
	}
	
	public  void captureScreenShotForReport(WebDriver webdriver,String obj){
		TakesScreenshot sht=(TakesScreenshot)webdriver;
	    File screenshotFile=sht.getScreenshotAs(OutputType.FILE);
	    String str="C:\\Users\\Divya\\workspace\\PHRMTesting\\Screen shots\\PhrmScreenshot1.docx";
	    try {
			FileUtils.copyFile(screenshotFile,new File(str+".\\ScreeShotsForReports\\"+obj+" "+GetTimeStampValue()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out) throws HeadlessException, AWTException, IOException, InvalidFormatException {
		 String screenshot_name = System.currentTimeMillis() + ".png";
		    
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        File file = new File("./Screenshots/" + screenshot_name);
	        ImageIO.write(image, "png", file);
	        InputStream pic = new FileInputStream("./Screenshots/"+screenshot_name);
	        run.addBreak();
	       
	        run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(450), Units.toEMU(450));
	        pic.close();	*/ 
		
	}
	


