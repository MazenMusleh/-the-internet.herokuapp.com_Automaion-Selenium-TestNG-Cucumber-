package PageObjectModel_tests.garbagetest;


import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectModel.Open_Edge_Site1_Pages.ForgetPass;
import PageObjectModel.Open_Edge_Site1_Pages.LoginPage;
import PageObjectModel.Open_Edge_Site1_Pages.SecurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class Open_Edge3 {
    WebDriver driver;
    SoftAssert soft_assert;
    LoginPage loginpage;
    SecurePage securePage;
    ForgetPass forgetpass;


    @BeforeMethod
    public void Open_Browser(){
        WebDriverManager.edgedriver().setup();

        driver=new EdgeDriver();
        soft_assert=new SoftAssert();
        loginpage =new LoginPage(driver);
        securePage = new SecurePage(driver);
        forgetpass = new ForgetPass(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 1)
    public void loginvalid_pattern(){
        loginpage.insertUsername("tomsmith");
        loginpage.insertPassword("SuperSecretPassword!");
        loginpage.clickLoginButton();
        soft_assert.assertTrue(securePage.isLogoutButtonDisplayed());
        System.out.println(securePage.getSecureAreaText());
        System.out.println(securePage.getCurrentURL());
        soft_assert.assertAll();
    }


    @Test(enabled = true)
    public void logininvalid(){
        driver.findElement(By.id("username")).sendKeys("tomssmith");
        driver.findElement(By.id("password")).sendKeys("SecretPasswordd!");
        driver.findElement(By.className("fa-sign-in")).click();
        soft_assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        System.out.println(driver.findElement(By.id("flash")).getText());
        soft_assert.assertAll();

    }


    @AfterMethod
    public void quitDriver() throws InterruptedException{
        System.out.println("method to quit driver after execution");
        Thread.sleep(2500);
        driver.quit();
    }}

