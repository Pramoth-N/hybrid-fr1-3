package runner;

import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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


    @BeforeClass
    public void extentSetUp(){
        extent = Reporter.generateExtentReport("IHCL TATA Test Report");
    }

    @AfterClass
    public void flushOut(){
        extent.flush();
    }
    @BeforeMethod
    public void setUp(){
        openBrowser();
        helper = new WebDriverHelper(driver);
        home = new IhclHome(helper);
        
    }

    
    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


    @Test
    public void testOne(){
        Reporter.test = extent.createTest("Test One");
        home.clickOnAboutUs();
        Set<String> parentHandles = driver.getWindowHandles();
        home.clickOnGinger();
        helper.waitForNewWindow(5, parentHandles.size());
        helper.switchToNewWindow(parentHandles);
        home.bookRooms();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
