package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	public static WebDriver driver;
	@DataProvider(name="DataProvider Class")
	public static Object[][]credentials(){
		return new Object[][]{{"un1","pwd1"},{"un2","pwd2"}};
	}@Test(dataProvider="DataProvider Class")
	public void login(String username,String password){
		//return new Object[][]{{"username"},{"password"}};
		System.out.println(username);
		System.out.println(password);
		
	}

}
