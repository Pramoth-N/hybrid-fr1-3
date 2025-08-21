package pages;

import uistore.IhclUI;
import utils.Reporter;
import utils.WebDriverHelper;

public class IhclHome {

    WebDriverHelper helper ;

    public IhclHome(WebDriverHelper helper){
        this.helper = helper;
    }

    public void clickOnAboutUs(){
        helper.hoverOverElement(IhclUI.company);
        Reporter.test.in
        helper.waitForElementToBeVisible(IhclUI.aboutUs, 5);
        helper.clickOnElement(IhclUI.aboutUs);
    }
    
}
