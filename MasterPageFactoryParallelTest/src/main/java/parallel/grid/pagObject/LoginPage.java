package parallel.grid.pagObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import parallel.grid.utilities.DataProviders;


public class LoginPage  extends BasePage {

	WebDriver driver;
	
		@FindBy(how=How.CSS, using="input#email") private WebElement SEND_EMAIL_BOX;
		@FindBy(how=How.ID, using="passwd") private WebElement SEND_PASSWRD_BOX;
		@FindBy(how=How.ID, using="SubmitLogin") private WebElement CLICK_LOGIN_BUTTON;


	
	
 
	

	public LoginPage logIn(String userName, String password) {
		
		
			
		
		try {
			SEND_EMAIL_BOX.sendKeys(userName);
		} catch (StaleElementReferenceException  e) {
			{	
				SEND_EMAIL_BOX.sendKeys(userName);
			}
		}
		SEND_PASSWRD_BOX.sendKeys(password);
		return this;
	}
		
		public LandingPage clickLogInButton() throws InterruptedException {
			Thread.sleep(5000);
			CLICK_LOGIN_BUTTON.click();
			return (LandingPage) openPage(LandingPage.class);
			


			
		}
		
		protected ExpectedCondition getPageLoadCondition() {
			return ExpectedConditions.visibilityOf(CLICK_LOGIN_BUTTON);
		}
	
}
