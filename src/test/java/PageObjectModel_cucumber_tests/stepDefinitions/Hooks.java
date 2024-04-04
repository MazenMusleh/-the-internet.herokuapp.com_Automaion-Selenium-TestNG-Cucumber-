package PageObjectModel_cucumber_tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {


    public static WebDriver driver;

    @Before
    public void openBrowser(){
        //set property
        WebDriverManager.edgedriver().setup();

        //new object from web driver
        driver=new EdgeDriver();

        //configratuin
        //maximize , implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.navigate().to("https://the-internet.herokuapp.com/login");

    }
    @After
    public void quitDriver() throws InterruptedException {
        System.out.println("method to quit driver after execution");
        Thread.sleep(2500);
        driver.quit();
    }
}
