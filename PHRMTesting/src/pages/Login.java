package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver ;

	public Login(WebDriver webdriver) {
		driver=webdriver;
		PageFactory.initElements(webdriver, this);
		}

	
	@FindBy(how=How.XPATH,using="//*[@id='ext-comp-1020']/tbody/tr[2]/td[2]")
	public WebElement LoginPopUP;
	
	

	@FindBy(how=How.ID,using="username")
	public WebElement username;
	
	@FindBy(how=How.ID,using="password")
	public WebElement passWord;

	
	@FindBy(how=How.XPATH,using="	//*[@id='home']/a/div[2]/span")
	public WebElement login;
	
	
	
	

	
}
