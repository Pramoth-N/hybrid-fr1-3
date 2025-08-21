package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import pages.IhclHome;
import utils.Base;
import utils.Reporter;
import utils.WebDriverHelper;

public class IhclTest extends Base{
    WebDriverHelper helper;
    ExtentReports extent;
    @BeforeMethod
    public void setUp(){
        openBrowser();
        helper = new WebDriverHelper(driver);
        IhclHome home = new IhclHome(helper);
        extent = Reporter.generateExtentReport("IHCL TATA Test Report");
        
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
