package parallel.grid.pagObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import parallel.grid.utilities.DriverManager;

public class HomePage extends BasePage {


	//@FindBy(how=How.CSS, using="a.login") private WebElement CLICK_SIGNIN_BUTTON1;
	@FindBy(how=How.CSS, using="div.header_user_info") private WebElement CLICK_SIGNIN_BUTTON;
	
	
	public HomePage open(String url) {
		DriverManager.getDriver().navigate().to(url);
		return  (HomePage) openPage(HomePage.class);
		
	}
	

	public LoginPage clickToSingIn() throws InterruptedException {
		Actions act= new Actions(driver);
		try {
			act.moveToElement(CLICK_SIGNIN_BUTTON).click().build().perform();
		} catch (StaleElementReferenceException e) {
			
			act.moveToElement(CLICK_SIGNIN_BUTTON).click().build().perform();
		}
		return (LoginPage) openPage(LoginPage.class);
	}
	






@Override
protected ExpectedCondition getPageLoadCondition() {
	
	
	try {
		Thread.sleep(500);
		
	} catch (Exception e) {
		
	}
	 return ExpectedConditions.visibilityOf(CLICK_SIGNIN_BUTTON);
		
	}
	
}
