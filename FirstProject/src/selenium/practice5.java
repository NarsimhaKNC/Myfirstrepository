package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String str="http://www.toolsqa.com";
		driver.get(str);
		driver.findElement(By.xpath(("//ul[@id='primary-menu']//following-sibling:://(/span[@class='text-wrap'])//(/span[@class='menu-text']"))).click();

}

}