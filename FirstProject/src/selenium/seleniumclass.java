package selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumclass {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String str="file:\\C:\\Users\\Divya\\Documents\\secondpractice.html";
		driver.get(str);
		String str1="NARSIMHA";
		System.out.println("title of the page is:" +str1);
		//driver.get("https://www.toolsqa.com");
		driver.findElement(By.id("FirstTextBox1")).sendKeys("narsimha");
		driver.findElement(By.name("Secondbox")).click();
		driver.findElement(By.className("MiddleName")).clear();
		driver.findElement(By.className("MiddleName")).sendKeys("narsimha");
		/*driver.findElement(By.className("main-button")).click();
		driver.findElement(By.tagName("value")).click();
		driver.findElement(By.tagName("input")).sendKeys("Narsimha");
		driver.findElement(By.linkText("Selenium")).click();
		 driver.findElement(By.partialLinkText("niu")).click();*/
		Thread.sleep(5000);
		driver.manage().window().maximize();
		//driver.close();
		/*driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();*/
		/*driver.navigate().to("https://www.gmail.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();*/
	    driver.findElements(By.name("gender")).get(0).clear();
		driver.findElements(By.name("gender")).get(2).click();
		Select sle=new Select(driver.findElement(By.id("ddl")));
		//sle.selectByVisibleText("12");
		sle.selectByValue("3");
		System.out.println(sle.getFirstSelectedOption().getText());
	
		
	}
		
	}


