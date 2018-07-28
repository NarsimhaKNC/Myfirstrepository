package testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng1 {
	
	public class TC1{
		//@BeforeMethod
		//@BeforeClass
		//@BeforeTest
		//@Test(priority=2)
		@Test(dependsOnMethods="returntravel")
		void launchtravel(){
		System.out.println("coming from nlg to hyd");	
		}
		//@AfterMethod
		//@AfterClass
		//@AfterTest
		//@Test(priority=1)
		@Test
		void returntravel(){
			System.out.println("moving to NLG");
			assertEquals("mytitle","mytitle");
		}
		@Test
		void m1(){
			System.out.println("im in hyd");
		}
		@Test
		void m2(){
			System.out.println("im in office");
		}
		@Test
		void m3(){
			System.out.println("im in room");
		}
	}

}
