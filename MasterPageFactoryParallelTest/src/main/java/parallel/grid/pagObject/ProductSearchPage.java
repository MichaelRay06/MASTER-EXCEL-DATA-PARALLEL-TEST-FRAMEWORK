package parallel.grid.pagObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductSearchPage extends BasePage {

	
	@FindBy(how=How.CSS, using="div>h1[itemprop='name']") private WebElement SEARCH_PRODUCT;

	
	
	
	public String verifySearchProduct() {
		String actualProduct= SEARCH_PRODUCT.getText();
		return actualProduct;
		
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
	
		return ExpectedConditions.visibilityOf(SEARCH_PRODUCT);
	}
}

