package PageObjectModel.Open_Edge_Site1_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //variables

    WebDriver driver;

    //constructor
    public LoginPage(WebDriver setDriver) {
        driver = setDriver;
    }

    //Elements
    By username = By.id("username");
    By password = By.id("password");
    By loginbutn = By.className("radius");


    //Actions
    public void insertUsername(String username1) {
        driver.findElement(username).sendKeys(username1);
    }

    public void insertPassword(String password1) {
        driver.findElement(password).sendKeys(password1);
    }

    public void clickLoginButton() {
        driver.findElement(loginbutn).click();
    }
    }





