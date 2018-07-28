package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Forparameter {
	@Test
	@Parameters({"br"})
	//@BeforeClass
	void launchbrowser(String br){
	if(br.equalsIgnoreCase("chrome")){
		System.out.println(br);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}else if(br.equalsIgnoreCase("ie")){
		System.out.println("launch ie");
	}
	}

}
