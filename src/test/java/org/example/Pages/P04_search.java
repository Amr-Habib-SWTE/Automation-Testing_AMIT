package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P04_search {
    public WebElement searchForProduct() {
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement clickOnSearchButton() {
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"] "));
    }

    public WebElement display() {
        return driver.findElement(By.id("products-pagesize"));
    }

    public List<WebElement> countResult() {
        return driver.findElements(By.className("item-box"));
    }

    public WebElement searchForSku() {
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement clickOnTheProduct() {
        return driver.findElement(By.cssSelector("h2[class=\"product-title\"] a"));
    }

    public WebElement verifySku() {
        return driver.findElement(By.cssSelector("span[class=\"value\"]"));
    }

    public List<WebElement> verifyResult() {
        return driver.findElements(By.cssSelector("div[class=\"item-grid\"]"));
    }
}
// h2[class="product-title"] a