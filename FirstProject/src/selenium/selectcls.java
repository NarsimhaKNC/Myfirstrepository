package selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectcls {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String str2="file:\\C:\\Users\\Divya\\Documents\\fourthpractice.html";
		driver.get(str2);
		WebElement ele=driver.findElement(By.id("FirDDL"));
		Select sle=new Select(ele);
		System.out.println(sle.getFirstSelectedOption().getText());//default value will b selected
		sle.selectByVisibleText("Ruby");// it will allow you to select the value by providing the ddl value 
		sle.deselectByIndex(1);
		sle.selectByVisibleText("C");
		sle.selectByIndex(1);//it will allow you to select the value with index no
		sle.selectByValue("1");
		List<WebElement> sle1=sle.getOptions();
		for(int i=0;i<sle1.size();i++){
			System.out.println(sle1.get(i).getText());
		}
		
	}

}
