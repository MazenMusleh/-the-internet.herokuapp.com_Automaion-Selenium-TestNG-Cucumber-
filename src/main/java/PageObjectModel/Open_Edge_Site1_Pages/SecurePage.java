package PageObjectModel.Open_Edge_Site1_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    WebDriver driver;

    public SecurePage(WebDriver setDriver){
        driver=setDriver;
    }
    //Elemments
    By logoutButton=By.cssSelector("a[href='/logout']");
    By secureAreaText=By.cssSelector(".example h2");

    public boolean isLogoutButtonDisplayed(){
        return driver.findElement(logoutButton).isDisplayed();
    }

    public String getSecureAreaText(){
        return driver.findElement(secureAreaText).getText();
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
