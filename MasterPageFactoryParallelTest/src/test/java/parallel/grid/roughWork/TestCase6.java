//package parallel.grid.roughWork;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import parallel.grid.pagObject.HomePage;
//import parallel.grid.pagObject.LandingPage;
//import parallel.grid.pagObject.LoginPage;
//import parallel.grid.pagObject.NewWishListPage;
//
//
//public class TestCase6 extends BaseTest {
//	
//	 HomePage homePage=new HomePage();
//
//
//
//	@Test(dataProvider = "getData")
//	public void logIn(String email, String password, String browserName, String wishListItem) throws InterruptedException {
//		
//
//
//	
//		
//		 openBrowser(browserName);
//		 
//		 LoginPage LoginPage=homePage.clickToSingIn();
//		 LandingPage landingPage= LoginPage.logIn(email, browserName).clickLogInButton();
//		 NewWishListPage newWishListPage=landingPage.myWishListLink();
//		 newWishListPage.typeWishListName(wishListItem).clickToSaveWhichList().clickToDeleteWhishListItem().acceptAlert();
//			
//
//		quitBrowser();
//
//	}
//
//	@DataProvider(parallel = true)
//	public Object[][] getData() {
//		Object[][] data = new Object[5][4];
//		data[0][0] = "bfatogun@yahoo.com";
//		data[0][1] = "sonsofgod";
//		data[0][2] = "chrome";
//		data[0][3]= "Tommy";
//
//		data[1][0] = "bfatogun@yahoo.com";
//		data[1][1] = "sonsofgod";
//		data[1][2] = "chrome";
//		data[1][3]= "Mickel Kroise";
//		
//		data[2][0] = "bfatogun@yahoo.com";
//		data[2][1] = "sonsofgod";
//		data[2][2] = "chrome";
//		data[2][3]=  "Ralph Luren";
//		
//		data[3][0] = "bfatogun@yahoo.com";
//		data[3][1] = "sonsofgod";
//		data[3][2] = "chrome";
//		data[3][3]= "DKNY";
//		
//		data[4][0] = "bfatogun@yahoo.com";
//		data[4][1] = "sonsofgod";
//		data[4][2] = "chrome";
//		data[4][3]=  "Versace";
//
//		return data;
//
//	}
//
//}
