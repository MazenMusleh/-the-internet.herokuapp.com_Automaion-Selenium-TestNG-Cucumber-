package PageObjectModel.Open_Edge_Site1_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPass {
    WebDriver driver;

    //constructor
    public ForgetPass(WebDriver setDriver){
        driver=setDriver;
    }

    By link = By.linkText("Forgot Password");
    By Setmail = By.id("email");
    By forgetButton = By.className("radius");

    By confirm = By.xpath("//h1[text()='Internal Server Error']");

    public void clickonforgetpass(){
        driver.findElement(link).click();
    }
    public void setemail(String email1){
        driver.findElement(Setmail).sendKeys(email1);
    }

    public void clickonforgetbutton(){
        driver.findElement(forgetButton).click();
    }

    public boolean conirmation(){
        return driver.findElement(confirm).isDisplayed();
    }
}
