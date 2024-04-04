package PageObjectModel_tests.test_cases_Site1;

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

public class Open_Edge {
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
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.navigate().to("https://the-internet.herokuapp.com/");
        //driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test()
    public void loginvalid_pattern(){
        loginpage.insertUsername("tomsmith");
        loginpage.insertPassword("SuperSecretPassword!");
        loginpage.clickLoginButton();
        soft_assert.assertTrue(securePage.isLogoutButtonDisplayed());
        System.out.println(securePage.getSecureAreaText());
        System.out.println(securePage.getCurrentURL());
        //Assert.assertFalse(driver.findElement(By.xpath("//i[@text()=' Logout']")).isDisplayed());
        //Assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertAll();
    }

    @Test()
    public void forgetpass_pattern(){
        forgetpass.clickonforgetpass();
        forgetpass.setemail("massen@gmail.com");
        forgetpass.clickonforgetbutton();
        soft_assert.assertTrue(forgetpass.conirmation());
    }

    @Test(enabled = false)
    public void loginvalid(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//i[@text()=' Logout']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertAll();
    }

    @Test(enabled = false)
    public void loginvalid2(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        soft_assert.assertFalse(driver.findElement(By.xpath("//i[text()=' Logout']")).isDisplayed());
        soft_assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertEquals(driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText()," Secure Area");
        //soft_assert.assertAll();
    }

    @Test(enabled = false)
    public void logininvalid(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
        soft_assert.assertFalse(driver.findElement(By.id("flash")).isDisplayed());
        System.out.println(driver.findElement(By.id("flash")).getText());
        soft_assert.assertAll();

    }

    @Test(enabled = false)
    public void forgetpass() {
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.id("email")).sendKeys("tomsmith@gmail.com");
        driver.findElement(By.className("radius")).click();
        driver.findElement(By.xpath("//h1[text()='Internal Server Error']")).isDisplayed();
        soft_assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Internal Server Error']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//h1[text()='Internal Server Error']")).getText());
        soft_assert.assertAll();
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException{
        System.out.println("method to quit driver after execution");
        Thread.sleep(2500);
        driver.quit();
    }}


        /*driver.findElement(By.id("username")).sendKeys("tomsmith");
       // driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       // driver.findElement(By.className("fa-sign-in")).click();
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.id("password")).sendKeys("secret_sauce");
       // driver.findElement(By.id("login-button")).click();
        //System.out.println(driver.findElement(By.className("title")).isDisplayed());
        //System.out.println(driver.findElement(By.className("title")).getText());
        //soft_assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
       // soft_assert.assertAll();
        //driver.findElement(By.className("fa-sign-in")).click();
        //driver.findElement(By.linkText("Elemental Selenium")).click();
        //driver.findElement(By.partialLinkText("Element")).click();
        //driver.findElement(By.partialLinkText("Sauce L")).click();
        //driver.findElement(By.xpath("//img[@src=\"/img/forkme_right_green_007200.png\"]")).click();
        //driver.findElement(By.cssSelector("img[src=\"/img/forkme_right_green_007200.png\"]")).click();
    }

   /*@Test(priority = 2)
    public void test2(){
        driver.findElement(By.id("username")).sendKeys("smith");
        driver.findElement(By.id("password")).sendKeys("SecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user");
     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secretsauce");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
     System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
     soft_assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
     soft_assert.assertAll();
    } */

