package selenium;
	import java.util.Set;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class practice1 {
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			String str="http://youtube.com/";
			driver.get(str);
           driver.findElement(By.id("search")).click();
           driver.findElement(By.id("search")).sendKeys("telugu video songs 2018");
           driver.findElement(By.id("search-icon-legacy")).click();
           System.out.println(driver.getTitle());
           Thread.sleep(3000);
           driver.manage().window().maximize();
           driver.navigate().to("https://www.gmail.com");
           driver.navigate().back();
           driver.navigate().forward();
           driver.navigate().refresh();
           driver.getCurrentUrl();
           driver.quit();
           Set<String> str1=driver.getWindowHandles();
           for(String s:str1){
        	   System.out.println(s);
        	   driver.switchTo().window(s);
        	   System.out.println(driver.getTitle());
           }
           
}
	}
