package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P07_homeSliders;
import org.testng.asserts.SoftAssert;

public class D07_homeSlidersStepDef {
    P07_homeSliders home = new P07_homeSliders();

    @When("user clicks on first slider")
    public void click_first_slider() {
        home.sliders().get(0).click();
    }

    @Then("relative product for first slider is displayed")
    public void first_product_details_opened() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com"));
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        soft.assertAll();
    }

    @When("user clicks on second slider")
    public void click_second_slider() {
        home.sliders().get(1).click();
    }

    @And("relative product for second slider is displayed")
    public void second_product_details_opened() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com"));
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        soft.assertAll();
    }

}