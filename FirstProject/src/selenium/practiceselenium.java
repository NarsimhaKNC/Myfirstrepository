package selenium;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practiceselenium {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	String str="https://www.facebook.com";
	driver.get(str);
	/*driver.findElement(By.name("email")).click();
	driver.findElement(By.name("email")).sendKeys("knarsi28@gmail.com");
	driver.findElement(By.id("pass")).click();
	driver.findElement(By.id("pass")).sendKeys("samudram");
	Thread.sleep(3000);
	driver.findElement(By.id("u_0_2")).click();
	driver.findElement(By.className("_54nh")).click();*/
	
	/*driver.findElement(By.id("u_0_k")).sendKeys("narsimha");
	driver.findElement(By.name("First name")).sendKeys("www");
	//driver.findElement(By.id("u_0_n")).clear();
	driver.findElement(By.id("u_0_n")).sendKeys("nar");*/
	
	WebElement ele1=driver.findElement(By.id("day"));
	WebElement ele2=driver.findElement(By.id("month"));
	WebElement ele3=driver.findElement(By.id("year"));
	Select sle1=new Select(ele1);
	Select sle2=new Select(ele2);
	Select sle3=new Select(ele3);
	System.out.println(sle1.getFirstSelectedOption().getText());
	System.out.println(sle2.getFirstSelectedOption().getText());
	System.out.println(sle3.getFirstSelectedOption().getText());
	sle1.selectByValue("16");
	sle2.selectByVisibleText("Dec");
	sle3.selectByValue("1991");
	
	List<WebElement> sle4=sle2.getOptions();
	for(int i=0;i<sle4.size();i++){
		System.out.println(sle4.get(i).getText());
		
	}
	
	
	
	

	}
}
