package Testng;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import utils.DataManager;
	import utils.Parameters;

	public class TC2 {
		String path=null;
		public WebDriver driver;
		@BeforeTest
		//@Test
		public void initData() {				
			System.out.println();
					
			path = ".\\Testdata\\TC_PHRMBook.xlsx";
			new DataManager(path,"TC2");
		}
		
		
		
		@BeforeClass

		// Launch the application thru IE browser
		public void launchApplication() throws InvalidFormatException, IOException, AWTException, InterruptedException {

			try {		
				System.setProperty("webdriver.chrome.driver",".\\Browsers\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("https://www.gmail.com");
			} catch (Exception e) {
				System.out.println("Failed to login");
				e.printStackTrace();
			}
		}
		@Test
		public void secondTC() throws InterruptedException{
			
			
			int row=DataManager.rowNumber;
			for(int i=1;i<row;i++){
				DataManager.readData(i);
				Thread.sleep(1000);
				if(Parameters.ExcutionFlag.equalsIgnoreCase("yes")){
					modules.Requestaquote TC1=new modules.Requestaquote(driver);
					TC1.createfrom();
				}
				
				
				
			}
			
		}
		

	}



