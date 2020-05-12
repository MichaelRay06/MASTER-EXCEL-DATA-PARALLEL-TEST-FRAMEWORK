package parallel.grid.pagObject;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewWishListPage extends BasePage {
	


@FindBy(how=How.CSS, using="input#name") private WebElement SEND_WISHLIST_NAME;
@FindBy(how=How.ID, using="submitWishlist") private WebElement CLICK_SAVE_BUTTON;
@FindBy(how=How.CSS, using="i.icon-remove") private WebElement CLICK_DELETE_WISHLIST;
	





public NewWishListPage typeWishListName(String saveitems) throws InterruptedException  {

		
	Thread.sleep(5000);
		SEND_WISHLIST_NAME.sendKeys(saveitems);
		Thread.sleep(5000);
	return  (NewWishListPage) openPage(NewWishListPage.class);
	
}
	
	public NewWishListPage clickToSaveWhichList() {
		CLICK_SAVE_BUTTON.click();
		return this;

		
	}
	public NewWishListPage clickToDeleteWhishListItem() {
		CLICK_DELETE_WISHLIST.click();
		return this;

		
	}
	public NewWishListPage acceptAlert() {
		
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(SEND_WISHLIST_NAME);
	}
}

