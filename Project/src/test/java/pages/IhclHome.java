package pages;

import uistore.IhclUI;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class IhclHome {

    WebDriverHelper helper ;

    public IhclHome(WebDriverHelper helper){
        this.helper = helper;
    }

    public void clickOnAboutUs(){
        helper.hoverOverElement(IhclUI.company);
        Reporter.test.pass("Hovered on Company");
        LoggerHandler.info("Hovered on Company");
        helper.waitForElementToBeVisible(IhclUI.aboutUs, 5);
        helper.clickOnElement(IhclUI.aboutUs);
        Reporter.test.info("Clicked on About Us");
        LoggerHandler.info("Clicked on About Us");
    }

    public void clickOnGinger(){
        helper.javascriptScroll(IhclUI.footer);
        helper.waitForElementToBeVisible(IhclUI.gingerImg, 5);
        helper.clickOnElement(IhclUI.gingerImg);
        LoggerHandler.info("Clicked on Ginger Image");
    }


    public void bookRooms(){
        helper.clickOnElement(IhclUI.bookYourStayBtn);
    }
    
}
