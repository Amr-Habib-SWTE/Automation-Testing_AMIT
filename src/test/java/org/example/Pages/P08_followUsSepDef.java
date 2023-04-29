package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P08_followUsSepDef {
    public WebElement facebookLink() {
        return Hooks.driver.findElement(By.className("facebook"));
    }

    public WebElement twitterLink() {
        return Hooks.driver.findElement(By.className("twitter"));
    }

    public WebElement rssLink() {
        return Hooks.driver.findElement(By.className("rss"));
    }

    public WebElement youtubeLink() {
        return Hooks.driver.findElement(By.className("youtube"));
    }
}
