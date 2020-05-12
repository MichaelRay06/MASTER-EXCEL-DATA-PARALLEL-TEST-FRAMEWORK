package parallel.grid.pagObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {
	
WebDriver driver;

@FindBy(how=How.CSS, using="i.icon-heart") private WebElement CLICK_WISHLIST_LINK;
@FindBy(how=How.ID, using="search_query_top") private WebElement Type_SEARCH_BOX;  
@FindBy(how=How.NAME, using="submit_search") private WebElement CLICK_SEARCH_BOX;

	
	


     public NewWishListPage myWishListLink() throws InterruptedException {
    	 Thread.sleep(5000);
    	 try {
			CLICK_WISHLIST_LINK.click();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CLICK_WISHLIST_LINK.click();
		}
    	 return (NewWishListPage) openPage(NewWishListPage.class);
    	 
     
     
     }
     
    	 public LandingPage typeInSearchBox(String searchProduct) {
    		 Type_SEARCH_BOX.sendKeys(searchProduct);
    		 return this;
    		 
    	 }
    	 
    	 public ProductSearchPage clickToSearch() {
    		 CLICK_SEARCH_BOX.click();
    			return  (ProductSearchPage) openPage(ProductSearchPage.class);
		
			
			
    		
    		 
    	 }


	
	
     

 	@Override
 	protected ExpectedCondition getPageLoadCondition() {
 		
 		return ExpectedConditions.visibilityOf(CLICK_WISHLIST_LINK);
 		
 	}
}