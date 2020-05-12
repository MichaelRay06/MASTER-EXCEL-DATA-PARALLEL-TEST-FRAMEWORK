package parallel.grid.roughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import parallel.grid.ExtentListiners.ExtentListeners;
import parallel.grid.utilities.DriverFactory;
import parallel.grid.utilities.DriverManager;


public class BaseTest {
	
	
	private  WebDriver driver;
	public boolean grid =false;
	private Properties Config= new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	
	
	
	@BeforeSuite
	public void setUp() {
		configLogger();
		DriverFactory.setGridPath("http://localhost:444/wd/hub");
		DriverFactory.setConfigPropertyFilePath(System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
		
		if(System.getProperty("os.name").contains("mac")) {
			
			DriverFactory.setChromeDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
			DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
			
			
		  }else {
				
				
			  DriverFactory.setChromeDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
			  DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
			  DriverFactory.setIeDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");
		
		  }
		
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public void configLogger() {
		String log4jConfs_File=(System.getProperty("user.dir") + "//src//test//resources//properties//log4j.properties");
		PropertyConfigurator.configure(log4jConfs_File);
		
	}
	
	public void logInfo(String message) {
		ExtentListeners.testReport.get().info(message); 
	}
	

	public void openBrowser(String browserName) {
		if(System.getenv("executionType")!=null && System.getenv("executionType").equals("Grid")) {
			grid=true;
			
		}
		
		
		
		
		DriverFactory.setRemote(grid);
		if(DriverFactory.isRemote()) {
			
DesiredCapabilities capabilities = null;
		
		if(browserName.equalsIgnoreCase("firefox")) {
			capabilities=DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			
		}else if (browserName.equalsIgnoreCase("chrome")){
			capabilities=DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
			
		}else if (browserName.equalsIgnoreCase("IE")){
			capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setBrowserName("IE");
			capabilities.setPlatform(Platform.WIN10);
			
		}
		
		try {
			driver= new RemoteWebDriver(new URL("http://192.168.99.1:4444/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			log.info("Starting session on Grid >>>>>>connecting to remote driver:" + e.toString());
		}
		
		
		
		}else 
	
	
		
		  if (browserName.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			 // System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
			  driver = new ChromeDriver();
			  log.info("Luching Browser: " + browserName );

			  
			  } else if (browserName.equalsIgnoreCase("firefox")) {
			    WebDriverManager.firefoxdriver().setup();
				 // System.setProperty("webdriver.gecko.driver",DriverFactory.getGeckoDriverExePath()); 
			  driver = new FirefoxDriver();
			  log.info("Luching Browser: " + browserName );
			 
			  }
		
				
			
			DriverManager.setWebDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
}


	public void quitBrowser() {
		DriverManager.getDriver().close();
		DriverManager.getDriver().quit();
	
	}
	
	
	}



