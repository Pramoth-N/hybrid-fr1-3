package uistore;

import org.openqa.selenium.By;

public class IhclUI {
    public static By company = By.xpath("//*[@id='__next']/main/div[1]/div/div[2]/div/div[2]/span");
    public static By aboutUs = By.xpath("//a[text()='About us']");
    public static By footer = By.className("footer-wrapper");
    public static By gingerImg = By.cssSelector(".footer-wrapper > div > div:nth-child(2) > div > div > div:nth-child(6)");
    public static By bookYourStayBtn = By.xpath("//*[@id='main__Header']/div/div[2]/div[2]/button");
    public static By contactUs = By.xpath("//*[@id='__next']/main/div[1]/div/div[2]/div/div[9]/span");
}
