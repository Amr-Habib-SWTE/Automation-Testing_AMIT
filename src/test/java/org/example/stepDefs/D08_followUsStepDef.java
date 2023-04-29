package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P08_followUsSepDef;
import org.example.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import java.net.URL;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D08_followUsStepDef {
    // apply POM Design Pattern
    P08_followUsSepDef home = new P08_followUsSepDef();

    @When("user opens facebook link")
    public void facebook_link() {
        home.facebookLink().click();
    }

    @When("user opens twitter link")
    public void twitter_link() {
        home.twitterLink().click();
    }

    @When("user opens rss link")
    public void rss_link() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demo.nopcommerce.com/");
        home.rssLink().click();
    }

    @When("user opens youtube link")
    public void youtube_link() {
        home.youtubeLink().click();
    }

    @Then("^\"([^\"]*)\" is opened in new tab$")
    public void facebook_new_tab(String url) {
        BrowserUtils.waitFor(2);
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(Tabs.get(1));

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Assert.assertTrue(driver.getCurrentUrl().contains(url), driver.getCurrentUrl());
        driver.switchTo().window(Tabs.get(0));

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

}