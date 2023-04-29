package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P05_hoverCategories;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D05_hoverCategoriesStepDef {
    SoftAssert soft = new SoftAssert();
    P05_hoverCategories hoverObj = new P05_hoverCategories();

    @Given("hover on the selected category")
    public void hoverOnTheSelectedCategory() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(hoverObj.hover()));
        Actions action1 = new Actions(Hooks.driver);
        action1.moveToElement(hoverObj.hover()).perform();

    }

    @And("select random one of the three sub categories")
    public void selectRandomOneOfTheThreeSubCategories() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(hoverObj.selectSub()));
        Actions action2 = new Actions(Hooks.driver);
        action2.moveToElement(hoverObj.selectSub()).perform();
        hoverObj.selectSub().click();
    }

    @Then("verify sub-category title is equal or contains the one you get")
    public void verifySubCategoryTitleIsEqualOrContainsTheOneYouGet() {
        String actualWord = hoverObj.verifySubCategory().getText();
        String expectedWord = "Software";
        soft.assertEquals(actualWord, expectedWord, "Wrong");
        System.out.println(actualWord.toLowerCase().trim());
        soft.assertAll();
    }

}