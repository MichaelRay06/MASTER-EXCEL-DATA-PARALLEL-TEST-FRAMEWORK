package parallel.grid.pagObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import parallel.grid.utilities.DriverManager;

public abstract class BasePage<T> {
	protected WebDriver driver;
	
	public BasePage() {
		this.driver=  DriverManager.getDriver();
		
	}
	
	
	
	public T openPage(Class<T> clazz) {
		T page= null;
		driver= DriverManager.getDriver();
		AjaxElementLocatorFactory ajaxElementFactory = new AjaxElementLocatorFactory(driver, 20);
		page= PageFactory.initElements(driver, clazz);
		PageFactory.initElements(ajaxElementFactory, page);
		ExpectedCondition pageLoadCondition =((BasePage) page).getPageLoadCondition();
		return page;
	
		
	}


private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	WebDriverWait  wait = new WebDriverWait(driver,10);
	wait.until(pageLoadCondition);
}
protected abstract ExpectedCondition getPageLoadCondition();
}

