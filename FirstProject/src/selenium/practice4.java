package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.toolsqa.com");
		driver.findElement(By.xpath(".//*[@id='primary-menu']/li[8]/a/span[1]/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='primary-menu']/li[8]/ul/li[2]/a/span[1]/span/span")).click();
        driver.manage().window().maximize();
        driver.getWindowHandle();
        driver.findElement(By.xpath(".//*[@id='menu-item-148']/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='ui-id-1']")).click();
        driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).sendKeys("www.google.com");
}
}