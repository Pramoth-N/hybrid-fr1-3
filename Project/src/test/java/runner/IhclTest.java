package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import pages.IhclHome;
import utils.Base;
import utils.Reporter;
import utils.WebDriverHelper;

public class IhclTest extends Base{
    WebDriverHelper helper;
    ExtentReports extent;
    IhclHome home;
    @BeforeMethod
    public void setUp(){
        openBrowser();
        helper = new WebDriverHelper(driver);
        home = new IhclHome(helper);
        extent = Reporter.generateExtentReport("IHCL TATA Test Report");
        
    }

    @Test
    public void testOne(){
        Reporter.test = extent.createTest("Test One");
        home.
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
