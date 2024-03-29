package parallel.grid.ExtentListiners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import parallel.grid.utilities.DriverManager;
public class ExtentManager {

	
	
		
private static ExtentReports extent;
//    
//    public static ExtentReports createInstance(String fileName) {
//    	if (extent == null)
//    		createInstance("test-output/extent.html");
//    	
//        return extent;
//    }

    
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        
        
      // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
      //  htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
   
        htmlReporter.config().setDocumentTitle("aventstack - ExtentReports");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setReportName("Build-1224");
        htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
        
        

   
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Micheal Ray");
        extent.setSystemInfo("SITE", "CAR VGURIJI");
        extent.setSystemInfo("BUILD", "1");
        
        return extent;
    }
        
        public static String screenshotPath;
        public static String screenshotName;
        
      
        	public static void captureScreenshot() {

    			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    		
    			Date d= new Date();
    			screenshotName =d.toString().replace(":", "_").replace("", "_") + ".jpg";
    			
    			
    			try {
					FileUtils.copyFile(scrFile,  new File (System.getProperty("user.dir") + "\\outputReport\\" + screenshotName));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	
        
        	
        }
        
        
        
        
    
}