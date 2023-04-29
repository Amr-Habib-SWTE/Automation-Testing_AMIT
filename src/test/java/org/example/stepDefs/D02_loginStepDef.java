package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {

    P02_login loginObj = new P02_login();
    SoftAssert soft = new SoftAssert();

    @Given("user go to login page")
    public void logindata() {
        loginObj.clickongotologinbutton().click();
    }

    @When("user login with \"valid\" \"test1@example.com\" and \"P@ssw0rd\"")
    public void validemail() {
        loginObj.email().sendKeys("test22@example.com");
        loginObj.password().sendKeys("P@ssw0rd");
    }

    @And("user clicks on login button")
    public void loginbutton() {
        loginObj.RememberMe().click();
        loginObj.clickLogin().click();
    }

    @Then("verify that user logged in successfully")
    public void userlogged() {
        Assert.assertTrue(loginObj.verfiymyaccountappered().isDisplayed());
    }

    @And("getCurrentUrl and verify it")
    public void getCurrentUrl() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
        soft.assertAll();
    }

    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invalidlogin() {
        loginObj.invalidemail().sendKeys("wrong@example.com");
        loginObj.invalidpassword().sendKeys("P@ssw0rd");
    }

    @Then("verify that user didn't logged in successfully")
    public void unsuccessfullylogin() {
        String actualerrormessage = driver.findElement(By.className("message-error")).getText();
        String expectederrormessage = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertTrue(actualerrormessage.contains(expectederrormessage));
        System.out.println(actualerrormessage);
        soft.assertAll();
    }

    @And("verify the color of this message is red")
    public void redcoloredmessage() {
        String actualcolor = driver.findElement(By.className("message-error")).getCssValue("color");
        String expectedcolor = "#e4434b";
        actualcolor = Color.fromString(actualcolor).asHex();
        Assert.assertEquals(actualcolor, expectedcolor);
        System.out.println(actualcolor);
        soft.assertAll();

    }


}