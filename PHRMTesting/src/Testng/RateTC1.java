package Testng;
	

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.xwpf.usermodel.XWPFDocument;
	import org.apache.poi.xwpf.usermodel.XWPFRun;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import utils.DataManager;
	import utils.Parameters;
	import utils.Reusable_Methods;
	
	public class RateTC1 {


		/*ExtentReports extent;
		ExtentTest test;*/
		XWPFDocument docx;
		XWPFRun run;
		FileOutputStream out;
		public static WebDriver driver;

		String projPath = System.getProperty("user.dir");
		String path="";

		@BeforeTest
		public void initData() {				
			System.out.println();
					
			path = "\\\\NBFC.COM\\departments\\QA\\Northbridge_QA\\IRCA_ExecutionWorkSpace\\RateTesting_CV_NB\\CV_RateTesting_NB\\TestData\\CV_RateTest_DataSheet_NL.xlsx";
			new DataManager(path,"CV_RateTestData_NL");
		}

		@BeforeClass
		// Launch the application thru IE browser
		public void launchApplication() throws InvalidFormatException, IOException, AWTException, InterruptedException {

			try {		
				System.setProperty("webdriver.edge.driver","\\\\NBFC.COM\\departments\\QA\\IRCA Automation\\RateTesting\\Browsers\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				driver.get("http://azcde04pasvm01:8080/Express/default.aspx");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("Failed to login");
				e.printStackTrace();
			}
		}

		
		// Call Login
		@Test 
		public void test() throws InterruptedException {

//			 DataManager DM = new DataManager();
			Reusable_Methods RM = new Reusable_Methods(driver);
			Thread.sleep(2000);
			int rnunmber = DataManager.rowNumber;

			for (int row = 1; row < rnunmber; row++) {
				DataManager.readData(row);		

				if (Parameters.flag.equalsIgnoreCase("Y")) {				
					try {
						System.out.println("Execution Row:" + row);
						 docx = new XWPFDocument();
						 run = docx.createParagraph().createRun();
						out = new FileOutputStream(".\\Screenshots\\"+Parameters.TCID+".docx");
						
						
						// Call Login
						System.out.println("Starated Login");
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date date = new Date();
						
						if(row>1){
							driver.get("http://azcde04pasvm01:8080/Express/default.aspx");
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(5000);
							Robot r = new Robot();
							r.keyPress(KeyEvent.VK_ENTER);
							r.keyRelease(KeyEvent.VK_ENTER);
							Thread.sleep(2000);
						}
						System.out.println("Execution Start Time: " + dateFormat.format(date));
						modules.Login login = new modules.Login(driver,test);
						login.populateLogin(docx,run,out);
						RM.captureScreenShot(docx,run,out);
						
					
					// Verfiy Page Dashboard
							boolean flag = RM.verify_PageTitle(driver, "Dashboard");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Verify the dashboard page");
						} catch (AssertionError e) {
							System.out.println("Failed to Navigate to Dashboard page");
						}

						// Call Customer Search
						System.out.println("Starated CustomerSearch");
						test.pass("Enter the Customer details to search");
						modules.CustomerSearch customerSearch = new modules.CustomerSearch(driver);
						customerSearch.customerSearch(docx,run,out);

						// VerfiyCustomerPage
						flag = false;
						flag = RM.verify_PageTitle(driver, "Customer");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Customer Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Customer Page");
							System.out.println("Failed to Navigate to Customer page");
						}

						// Call Customer Information
						System.out.println("Starated CustomerInformation");
						test.pass("Enter the customer details");
						modules.CustomerInformation customerInformation = new modules.CustomerInformation(driver);
						customerInformation.customerInformation(docx,run,out);
						
						// VerfiySubmissionPage
						flag = false;
						flag = RM.verify_PageTitle(driver, "Submission");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Submission Page");
							System.out.println("Sucessfully Navigated to Submission Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Submission Page");
							System.out.println("Failed to Navigate to Submission page");
						}

						// Call Submission
						test.pass("Enter the Submission details");
						modules.Submission submission = new modules.Submission(driver);
						submission.submission(docx,run,out);								
						
						//Verify Business Page
						flag = false;
						flag = RM.verify_PageTitle(driver, "Business");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Business Page");
						}catch(AssertionError e){
							e.printStackTrace();
							test.fail("Failed to Navigate Business Page");
							System.out.println("Failed to Navigate to Business page");
						}

						// Call Business Module
						test.pass("Enter the Business details");
						modules.Business Business = new modules.Business(driver);
						Business.business(docx,run,out);
						test.pass("Click On Next and Verify the Location page");
						
						// Verify Location Page
						flag = false;
						flag = RM.verify_PageTitle(driver, "Location");
						try {											
							if(flag){
							// Call Location
							test.pass("Enter the Location details");
							modules.Location Location = new modules.Location(driver);
							Location.location(docx,run,out);
							test.pass("Click on Next and Verfiy the Premium Page");
							}
						} catch (Exception e) {
							System.out.println("Failed to Navigate to Location page");
						}

					// Call Add Vehicle 
						modules.AddVehicle AddVehicle = new modules.AddVehicle(driver);
						AddVehicle.AddVehicle(docx,run,out);
											
					// Verfiy Driverpage Page					
						flag = false;
						flag = RM.verify_PageTitle(driver, "DRIVER");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Driver Page");
							System.out.println("Sucessfully Navigated to Driver Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Driver Page");
							System.out.println("Failed to Navigate to Driver page");
						}

						// Call Add Driver
						test.pass("Enter the Location details");
						modules.AddDriver AddDriver = new modules.AddDriver(driver);
						AddDriver.AddDriver(docx,run,out);

						// Verfiy Driver Assignment Page
						flag = false;
						flag = RM.verify_PageTitle(driver, "Assignment");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Driver Assignment Page");
							System.out.println("Sucessfully Navigated to Driver Assignment Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Driver Assignment Page");
							System.out.println("Failed to Navigate to Driver Assignment page");
						}
						
						
						// Call Driver_Assignment 
						test.pass("Enter the Location details");
						modules.Assignment Assignment = new modules.Assignment(driver);
						Assignment.Driver_Assignment(docx,run,out);
						
						// Verfiy Claims Page
						flag = false;
						flag = RM.verify_PageTitle(driver, "Claims");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Claims Page");
							System.out.println("Sucessfully Navigated to Claims Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Claims Page");
							System.out.println("Failed to Navigate to Claims page");
						}
											
						// Call Claims 					
						modules.ClaimInfo ClaimInfo = new modules.ClaimInfo(driver);
						ClaimInfo.ClaimInfo(docx,run,out);
						
						// Verfiy Coverage Page
						flag = false;
						flag = RM.verify_PageTitle(driver, "Premium");
						try {
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Premium Page");
							System.out.println("Sucessfully Navigated to Premium Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Premium Page");
							System.out.println("Failed to Navigate to Premium page");
						}
						
						// Capture the Quote No/PolicyNumber
						String PolicyNumber = null;
						try{
							PolicyNumber = driver
									.findElement(By.xpath("//*[@fieldref='ConstantsPolicy.CurrentPolicyNumberIdentifier']"))
									.getText();
							test.pass("PolicyNumber Captured from the application:" +PolicyNumber);
						}catch(Exception e){
							test.fail("Failed to capture PolicyNumber from the application");
						}
						
						//Entering the captured PolicyNumber to excel input sheet 
						DataManager.writeData(path,row, 5, PolicyNumber);

						// Call Coverage
						modules.Coverage Coverage = new modules.Coverage(driver);
						Coverage.Coverage_New(docx,run,out);
						
						// Verify Premium Page
						flag = false;
						try {
							RM.wait_For_Element("//a[contains(text(),'Coverage')]");
							flag = RM.verify_PageTitle(driver, "Premium");
							Assert.assertEquals(flag, true);
							test.pass("Sucessfully Navigated to Premium Page");
						} catch (AssertionError e) {
							e.printStackTrace();
							test.fail("Failed to Navigate Premium Page");					
							System.out.println("Failed to Navigate to Premium page");
						}
						
						//Entering the  ApplicationPremium to excel input sheet 
						
						try {
							RM.wait_For_Element("//*[@fieldref='PolicyInput.QuotePremiumAutoDisplay']");
							String ApplicationPremium="";
							 WebElement ele_ApplicationPremium = driver.findElement(By.xpath("//*[@fieldref='PolicyInput.QuotePremiumAutoDisplay']"));
							 ApplicationPremium = ele_ApplicationPremium.getText();
							DataManager.writeData(path,row, 2, ApplicationPremium);
						} catch (Exception e) {
						}


						// Call Premium
						modules.Premium Premium = new modules.Premium(driver,test);
						Premium.Premium(row,docx,run,out);									
						
					
					} catch (Exception e) {
//						DataManager.writeData(path,row, 4, "Skip");
						e.printStackTrace();
					} finally {

						// LogOut
						try {
							try {	
								docx.write(out);
								out.flush();
								out.close();
								docx.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							DateFormat dateFormater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date1 = new Date();
							System.out.println("Execution End Time: " + dateFormater.format(date1));
							JavascriptExecutor js = (JavascriptExecutor) driver;
							WebElement ele_LogOut = driver.findElement(By.id("id_LogOut"));
							js.executeScript("arguments[0].scrollIntoView(true);", ele_LogOut);
							Thread.sleep(2000);
							ele_LogOut.click();
							Thread.sleep(5000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} else {
					continue;
				}
			}
		}

		@AfterTest
		public void tearDown() {
			extent.flush();
			//driver.quit();

		}
	}


}
