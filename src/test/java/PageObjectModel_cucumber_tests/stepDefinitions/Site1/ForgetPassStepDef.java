package PageObjectModel_cucumber_tests.stepDefinitions.Site1;

import PageObjectModel.Open_Edge_Site1_Pages.ForgetPass;
import PageObjectModel_cucumber_tests.stepDefinitions.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ForgetPassStepDef {

    SoftAssert soft_assert = new SoftAssert();
    ForgetPass forgetPass = new ForgetPass(Hooks.driver);


    @Given("user navigate to HomePage")
    public void userNavigateToHomePage() {
        Hooks.driver.navigate().to("https://the-internet.herokuapp.com");
    }

    @When("user click on forget pass link")
    public void userClickOnForgetPassLink() {
        forgetPass.clickonforgetpass();
    }

    @And("user type its email")
    public void userTypeItsEmail() {
        forgetPass.setemail("mazen112@gmail.com");
    }

    @And("user click on forget pass Button")
    public void userClickOnForgetPassButton() {
        forgetPass.clickonforgetbutton();
    }

    @Then("user changed Forget pass successfully")
    public void userChangedForgetPassSuccessfully() {
        soft_assert.assertTrue(Hooks.driver.findElement(By.xpath("//h1[text()='Internal Server Error']")).isDisplayed());
        System.out.println(Hooks.driver.findElement(By.xpath("//h1[text()='Internal Server Error']")).getText());
        soft_assert.assertAll();
    }
}
