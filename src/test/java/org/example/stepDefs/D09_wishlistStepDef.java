package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P09_wishlist;
import org.example.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D09_wishlistStepDef {
    int beforeadding;
    int afteradding;

    P09_wishlist wishlist = new P09_wishlist();

    @When("user add product to wishlist")
    public void product_to_wishlist()
    {
        beforeadding = BrowserUtils.convertStringToInt(wishlist.wishlist_qty().getText());
        wishlist.addToWishlistBtn().get(2).click();
    }

    @Then("wishlist notification success is visible")
    public void success_visible()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(wishlist.success_notification()));
        SoftAssert soft = new SoftAssert();
        String actualColor = wishlist.success_notification().getCssValue("background-color");
        String expectedColor = "#4bb07a";
        actualColor = Color.fromString(actualColor).asHex();
        Assert.assertEquals(actualColor,expectedColor);
        System.out.println(actualColor);
        soft.assertAll();
    }


    @And("user get the number of wishlist items after adding product")
    public void wishlist_items_adding_product()
    {
        int num = 0;
        while (BrowserUtils.convertStringToInt(wishlist.wishlist_qty().getText()) == beforeadding && num < 7)
        {
            BrowserUtils.waitFor(1);
            num++;
        }
        afteradding = BrowserUtils.convertStringToInt(wishlist.wishlist_qty().getText());
    }


    @And("number of wishlist items increased")
    public void number_of_wishlist_items_increased()
    {
        System.out.println(beforeadding);
        System.out.println(afteradding);
        Assert.assertEquals(beforeadding+1, afteradding);
    }

    @And("user go to wishlist page")
    public void user_open_wishlist_page()
    {
        wishlist.wishlist_tab().click();
    }

    @Then("number of quantities are greater than zero in wishlist page")
    public void quantities_are_greater_than_zero()
    {
        int rows = wishlist.item_rows().size();
        int qty = 0;
        for (int x=0; x<rows; x++)
        {
            qty = qty + BrowserUtils.convertStringToInt(wishlist.item_rows().get(x).getAttribute("value"));
        }
        System.out.println(qty);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(qty>0, "qty is greater than zero");
        soft.assertEquals(qty,afteradding, "qty in wishlist page is similar to number in wishlist tab in home page");
        soft.assertAll();
    }


}
