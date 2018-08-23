package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	
	
	WebDriver driver ;

	public Keywords(WebDriver webdriver) {
	 driver=webdriver;
	 PageFactory.initElements(webdriver, this);
	}
	
    /* Function for Explicit wait*/
    public String WaitForElementPresent(WebElement sElement) throws Exception {
    	String strReturn = "";
		int TimeInSeconds = 60;
		try {
			WebElement result =sElement ;
			if (result != null) {		
				try {
					ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver webDriver) {
							WebElement element = sElement;
							if (element != null) {
								return true;

							} else {
								return false;
							}
						}
					};
					Wait<WebDriver> wait = new WebDriverWait(driver, TimeInSeconds);
					try {
						wait.until(expectation);
					} catch (Exception e) {
						strReturn = "Timeout Error: Element '" + sElement + "' not found with in " + TimeInSeconds + " seconds";
		
					}
				} catch (Exception e) {
					strReturn = "Timeout Error: Element '" + sElement + "' not found with in " + TimeInSeconds + " seconds";
				}
			} else {
				strReturn = "Element '" + sElement + "' not found in Object Repository";				
			}
		} catch (Exception e) {
			strReturn = "Error: Excetption occured while retriving element '" + sElement + "' - " + e.getMessage();
		}	
		return strReturn;
	}
    
    
    /*Click Method*/
    public void click(final WebElement sElement) {
 		String strResult = "";
		
		try {
			strResult = WaitForElementPresent(sElement);
			if (strResult.equals("")) {
				if (sElement != null) {					
					sElement.click();				
					System.out.println("Report Pass");
				} else {
					System.out.println("Report failuer");
				}
			} else {
				
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2.getMessage());
		}
	}

    /*To check weather alert is present*/
    public boolean isAlertPresent(int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds );
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("Report Failure");
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Alert is not present");
			return false;
		}
	}
    

	

}

