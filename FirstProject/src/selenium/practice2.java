package selenium;
import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class practice2 {
	private static final String Boolean = null;
	private static final String WebDriver = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String str="http://www.hdfcbank.com";
		driver.get(str);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//driver wait for the 10seconds
		practice2 obj=new practice2();
		float i=678094;
		String str1="eshwar";
		
		



	//private static void login(float f,String str1) {
		//driver.findElement(By.id("loginsubmit")).click();
		driver.findElement(By.xpath("//a[@class='homeloginbtn']")).click();
		String parentwindow=driver.getWindowHandle();
		//Thread.sleep(3000);
		Set<String> childwindow=driver.getWindowHandles();{
		for(String a:childwindow)
		{
			driver.switchTo().window(a);
		}
		/*WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='impMsgs']/preceding-sibling::div/a")))).click();*/
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='impMsgs']/preceding-sibling::div/a")).click();
		
		driver.switchTo().frame(0); 
		//driver.switchTo().defaultContent();
		
		driver.findElement(By.name("fldLoginUserId")).sendKeys("67809460");
		driver.findElement(By.xpath("//table[@class='lForm']/tbody/tr[6]/td/a/img")).click();
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame(1);*/
		//driver.findElement(By.partialLinkText("Terms")).click();
		 //Thread.sleep(1000);
		
		FluentWait<WebDriver> wait_fluent = new FluentWait<WebDriver>(driver);
		wait_fluent.pollingEvery(3,TimeUnit.SECONDS);
		wait_fluent.withTimeout(10,TimeUnit.SECONDS);
		//wait_fluent.ignoring(null);
		Boolean ele=wait_fluent.until(new Function<WebDriver,Boolean>()){
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>(){
			public Boolean apply(WebDriver dri){
				WebElement ele=dri.findElement(By.xpath("//input[@name='fldPassword']"));
				
				if(ele!=null){
					return true;
					
			}
				return false;
			}
			};
			wait_fluent.until(function);
				driver.findElement(By.xpath("//input[@name='fldPassword']")).sendKeys("eshwar");
			}
			
			
		}
		
		/*WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@name='fldPassword']")))).sendKeys("eshwar");*/
		//driver.findElement(By.xpath("//input[@name='fldPassword']")).sendKeys("eshwar");
		driver.findElement(By.xpath("//*[@id='chkrsastu']")).click();;
			
		driver.findElement(By.xpath("//*[@class='login_tab1']/a/img")).click();
			//e.printStackTrace();
		}
		
		
		}
	


