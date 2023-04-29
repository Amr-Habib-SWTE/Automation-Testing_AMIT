package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P05_hoverCategories {

    public WebElement hover() {
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
    }

    public WebElement selectSub() {
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/software\"]"));
    }

    public WebElement verifySubCategory() {
        return driver.findElement(By.cssSelector("div[class=\"page-title\"] h1"));
    }

}
