package PageObjectModel_cucumber_tests.stepDefinitions.Site1;

import PageObjectModel.Open_Edge_Site1_Pages.LoginPage;
import PageObjectModel.Open_Edge_Site1_Pages.SecurePage;
import PageObjectModel_cucumber_tests.stepDefinitions.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class LoginStepDef {

    SoftAssert soft_assert=new SoftAssert();
    LoginPage loginpage = new LoginPage(Hooks.driver);
    SecurePage securePage = new SecurePage(Hooks.driver);

    @Given("user navigate to homePage")
    public void userNavigateToHomePage() {
        Hooks.driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginpage.insertUsername("tomsmith");
        loginpage.insertPassword("SuperSecretPassword!");
    }

    @When("user enter invalid username and valid password")
    public void userEnterinvledUsernameAndvalidPassword() {
        loginpage.insertUsername("tomdsmith");
        loginpage.insertPassword("SuperSecretPassword!");
    }

    @When("user enter valid username and invalid password")
    public void userEnterValidUsernameAndinvalidPassword() {
        loginpage.insertUsername("tomsmith");
        loginpage.insertPassword("SecretPassword!");
    }

    @When("user enter invalid username and invalid password")
    public void userEnterinValidUsernameAndinvalidPassword() {
        loginpage.insertUsername("smith");
        loginpage.insertPassword("SuperSecret!");
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        loginpage.clickLoginButton();
    }

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() throws InterruptedException {
        soft_assert.assertTrue(securePage.isLogoutButtonDisplayed());
        System.out.println(securePage.getSecureAreaText());
        System.out.println(securePage.getCurrentURL());
        soft_assert.assertAll();
    }

    @Then("user cant log in successfully")
    public void usercantloginsuccessfully() {
        soft_assert.assertTrue(Hooks.driver.findElement(By.id("flash")).isDisplayed());
        System.out.println(Hooks.driver.findElement(By.id("flash")).getText());
        soft_assert.assertAll();
    }
}