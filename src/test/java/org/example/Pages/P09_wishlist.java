package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P09_wishlist {
    public WebElement wishlist_tab() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"header-links\"] a[href=\"/wishlist\"]"));
    }

    public WebElement wishlist_qty() {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]"));
    }

    public List<WebElement> addToWishlistBtn() {
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement success_notification() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public List<WebElement> item_rows() {
        return Hooks.driver.findElements(By.cssSelector("td[class=\"quantity\"] input"));
    }
}
