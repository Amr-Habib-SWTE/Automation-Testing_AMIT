package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class D01_registerStepDef {
    P01_register registerObj = new P01_register();

    @And("click on register button")
    public void registerbutton() {
        registerObj.clickonregistericon().click();
    }

    @When("user select gender")
    public void selectgender() {
        registerObj.selectgender().click();
    }

    @And("user enter firstname \"automation\"")
    public void enterfirstname() {
        registerObj.enterfirstname().sendKeys("automation");
    }

    @And("user enter lastname \"tester\"")
    public void enterlastname() {
        registerObj.enterlastname().sendKeys("tester");
    }

    @And("user select day of birth")
    public void selectdayofbirth() {
        Select dropdownbox = new Select(registerObj.selectdayofbirth());
        dropdownbox.selectByIndex(19);
    }

    @And("user select month of birth")
    public void selectmonthofbirth() {
        Select dropdownbox = new Select(registerObj.selectmonthofbirth());
        dropdownbox.selectByIndex(3);
    }

    @And("user select year of birth")
    public void SelectYearOfBirth() {
        Select dropdownbox = new Select(registerObj.selectYearOfBirth());
        dropdownbox.selectByVisibleText("1995");
    }

    @And("user enter email \"test1@example.com\"")
    public void enteremail() {
        registerObj.enteremail().sendKeys("test22@example.com");
    }

    @And("user enter company name \"automation\"")
    public void entercompanyname() {
        registerObj.entercompanyname().sendKeys("automation");
    }

    @And("user unselect checkbox newsletter")
    public void unselectcheckboxnewsletter() {
        registerObj.unselectcheckboxnewsletter().click();
    }

    @And("user enter password \"P@ssw0rd\"")
    public void enterpassword() {
        registerObj.enterpassword().sendKeys("P@ssw0rd");
    }

    @And("user enter confirm password \"P@ssw0rd\"")
    public void enterconfirmpassword() {
        registerObj.enterconfirmpassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void clickonregisterbutton() {
        registerObj.clickonregisterbutton().click();
    }

    @Then("verify account is created successfully")
    public void accountiscreatedsuccessfully() {
        SoftAssert soft = new SoftAssert();
//1- get text and verify it contains "Your registration completed"
        soft.assertTrue(registerObj.accountiscreatedsuccessfully().getText().contains("Your registration completed"));
//2- get css value and verify color is green #4cb17c Hex
        String actualColor = registerObj.accountiscreatedsuccessfully().getCssValue("color");
        String expectedColor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actualColor, expectedColor);
        System.out.println(actualColor);
//  soft.assertEquals(Color.fromString(actualColor).asHex(),"#4cb17c");
        soft.assertAll();
    }
}

