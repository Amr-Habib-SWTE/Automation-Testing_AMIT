package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_currencies;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class D03_currenciesStepDef {
    P03_currencies homePageObj = new P03_currencies();

    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void selectCurrency() {
        Select dropDownBox = new Select(homePageObj.selectCurrency());
        dropDownBox.selectByVisibleText("Euro");
    }

    @Then("verify Euro Symbol is shown on the 4 products displayed in Home page")
    public void firstProduct() {
            List<WebElement> actualPrice= homePageObj.products();
            WebElement Euro;
            for (int i=0; i<actualPrice.size(); i++){
                Euro=actualPrice.get(i);
                Assert.assertTrue(Euro.getText().contains("€"));
                System.out.println(Euro.getText());
            }
    }

}