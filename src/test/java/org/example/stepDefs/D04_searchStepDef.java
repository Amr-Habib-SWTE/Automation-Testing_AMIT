package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_search;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D04_searchStepDef {
    P04_search searchObj = new P04_search();
    SoftAssert soft = new SoftAssert();

    @When("^user type product name (.*)$")
    public void typeInSearchBar(String itemName) {
        searchObj.searchForProduct().sendKeys(itemName);
    }

    @And("user click on search button")
    public void clickOnSearchButton() {
        searchObj.clickOnSearchButton().click();
    }

    @Then("^verify url contains (.*)$")
    public void verifyUrlContainsBooks(String URL) {
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl, URL);
        System.out.println(actualUrl);
        soft.assertAll();
    }

    @And("select display per page")
    public void display18() {
        Select dropList = new Select(searchObj.display());
        dropList.selectByVisibleText("18");
    }

    @And("Count number of search result")
    public void countNumberOfSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(searchObj.verifyResult()));
        System.out.println(searchObj.countResult().size());
    }

    @And("^verify each result contains (.*)$")
    public void VerifyEachResultContainsTheSearchWord(String searchWord) {
        List<WebElement> actualResult = searchObj.verifyResult();
        WebElement Result;
        for (int i = 0; i < actualResult.size(); i++) {
            Result = actualResult.get(i);
            soft.assertTrue(Result.getText().toLowerCase().contains(searchWord));
            System.out.println(Result.getText().toLowerCase().contains(searchWord));
            soft.assertAll();
        }
    }


    @When("^user type serial number (.*)$")
    public void userTypeSku(String sku) {
        searchObj.searchForSku().sendKeys(sku);
    }

    @And("user clicks on product")
    public void userClicksOnProduct() throws InterruptedException {
        searchObj.clickOnTheProduct().click();
        Thread.sleep(5000);
    }

    @Then("^verify result contains (.*)$")
    public void verifyResultContainSKU(String wantedSku) {
        soft.assertTrue(searchObj.verifySku().getText().toLowerCase().contains(wantedSku));
        System.out.println(searchObj.verifySku().getText());
        soft.assertAll();
    }

}