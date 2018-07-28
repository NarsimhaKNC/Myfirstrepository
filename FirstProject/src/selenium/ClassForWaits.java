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

public class ClassForWaits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//String path= "D:\\Sharath\\Selenium_Workspace\\JARS\\BrowserExes\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
/*		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("FirstTextBox")),"type","text"));
		
		*/
		
		
		
		
		
		
		
		
		driver.get("https://www.hdfcbank.com"); 
		
		
		driver.findElement(By.id("loginsubmit")).click();
		//waitFor(driver, 10, "loginsubmit");
		
		//Thread.sleep(2000);
		Set<String> win = driver.getWindowHandles();
	
		for(String w:win){
			driver.switchTo().window(w);
		}
		
		waitFor(driver, 30, "//div[@class='impMsgs']/preceding-sibling::div/a");
		
		//waitForText(driver, 60, xapth);
		
		driver.findElements(By.xpath("//div[@class='impMsgs']/preceding-sibling::div/a")).get(0).click();
		
		Set<String> win2 = driver.getWindowHandles();
		
		for(String w:win2){
			driver.switchTo().window(w);
		}
		
		driver.switchTo().frame(driver.findElement(By.id("login_page")));
		
		driver.findElement(By.name("fldLoginUserId")).sendKeys("test");
		
/*		Explict
		Fulent */
		
		
		
		
		
/*//		implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		 explicit wait
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("sdfds"))));
		*/
		
		
		
		
		
		
		
		
//		FluentWait
		FluentWait<WebDriver> wait_fluent = new FluentWait<WebDriver>(driver);
		wait_fluent.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait_fluent.withTimeout(2, TimeUnit.SECONDS);
 
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
				{
					public Boolean apply(WebDriver dri) {
						WebElement element = dri.findElement(By.id("idvalue"));						
						if(element!=null)
						{
							return true;
						}
						return false;
					}
				};
				wait_fluent.until(function);		

	}

	public static void waitFor(WebDriver driver, int time, String xpathExpression){
		FluentWait<WebDriver> wait_fluent = new FluentWait<WebDriver>(driver);
		wait_fluent.pollingEvery(2,  TimeUnit.SECONDS);
		wait_fluent.withTimeout(time, TimeUnit.SECONDS);
		wait_fluent.ignoring(null);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
				{
					public Boolean apply(WebDriver dri) {
						WebElement element = dri.findElement(By.xpath(xpathExpression));						
						if(element!=null)
						{
							return true;
						}
						return false;
					}
				};
				wait_fluent.until(function);	

	}
	
}

