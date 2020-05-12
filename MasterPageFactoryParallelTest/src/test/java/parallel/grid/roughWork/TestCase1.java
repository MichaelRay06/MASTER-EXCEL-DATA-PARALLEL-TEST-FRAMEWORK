package parallel.grid.roughWork;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



import parallel.grid.pagObject.HomePage;
import parallel.grid.pagObject.LoginPage;
import parallel.grid.pagObject.LandingPage;
import parallel.grid.pagObject.NewWishListPage;
import parallel.grid.utilities.Constants;
import parallel.grid.utilities.DataProviders;
import parallel.grid.utilities.DataUtil;
import parallel.grid.utilities.ExcelReader;





public class TestCase1 extends BaseTest {

	
	    HomePage homePage;
		LoginPage LoginPage;
		LandingPage landingPage;
		NewWishListPage newWishListPage;
		
		
		


		@Test(dataProviderClass =DataProviders.class,dataProvider="masterTestCases")
		//public void logInTestMethod(String userName, String password,  String saveitems, String browserName) {
		public void DeleteWishListProduct(Hashtable<String,String> data) throws InterruptedException {
			logInfo("getting data sets"+ data);
		
			
			
			    openBrowser(data.get("browserName"));
			    logInfo("open browse of type:" + (data.get("broswerName")));
			   // String browserName = null;
			   
				
				ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
				logInfo("Feching Excel path");
				DataUtil.checkExecution("master", "DeleteWishListProduct", data.get("Runmode"), excel);
				logInfo("connecting to Excel path" );
			 
			 
		
			  homePage=new HomePage();
			  LoginPage= homePage.open("http://carguruji.com/shop/").clickToSingIn();
			  logInfo("open site" );
			  landingPage= LoginPage.logIn(data.get("userName"), data.get("password")).clickLogInButton();
			  logInfo("get logging details: username as:" + (data.get("userName") + "and password as:"+(data.get("password"))));
			 newWishListPage=landingPage.myWishListLink();
			 logInfo("navigating to landing page and clickling on myWishListLink ");
			 newWishListPage.typeWishListName(data.get("saveitems")).clickToSaveWhichList().clickToDeleteWhishListItem().acceptAlert();
			 logInfo("navigating to newWishListPage page and saving selected item :"+ (data.get("saveitems")) );
			 logInfo("accepting alert on  newWishListPage");
				

			

		}
		
		@AfterMethod
		public void tearDown() {
			quitBrowser();
			
		}

	}
