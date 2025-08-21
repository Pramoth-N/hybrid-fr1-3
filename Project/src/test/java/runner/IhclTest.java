package runner;

import java.util.Set;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import pages.IhclHome;
import utils.Base;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class IhclTest extends Base{
    WebDriverHelper helper;
    ExtentReports extent;
    IhclHome home;


    @BeforeClass
    public void extentSetUp(){
        extent = Reporter.generateExtentReport("testReport");
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
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            Reporter.test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            Reporter.attachScreenshotToReport("fail-ss", Reporter.test ,"Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Reporter.test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            Reporter.test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }
        if(driver != null){
            driver.quit();
        }
    }


    @Test
    public void testOne(){
        Reporter.test = extent.createTest("Test Execution");
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
        Reporter.attachScreenshotToReport("Book_btn", Reporter.test,"Clicked Book Btn");
    }

    @Test
    public void testTwo(){
        home.clickContactUs();
        helper.waitTillPageReady();
        Reporter.attachScreenshotToReport("contact_screenshot", Reporter.test,"Clicked constactus");
        Screenshot.captureScreenShot("contact_screenshot");
    }

    @Test
    public void testThree(){
        Set<String> parentHandles = driver.getWindowHandles();
        home.clickOnPrivacyPolicy();
        helper.waitForNewWindow(5, parentHandles.size());
        helper.switchToNewWindow(parentHandles);
        home.subscribe();
    }
}
