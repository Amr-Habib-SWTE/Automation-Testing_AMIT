package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06_advancedMethod {

    public List<WebElement> Categories()
    {
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }


    public List<WebElement> subCategories(int categoryNum)
    {
        categoryNum = categoryNum + 1;
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+categoryNum+"]/ul[@class=\"sublist first-level\"]/li"));
    }

    public WebElement category_page()
    {
        return  Hooks.driver.findElement(By.cssSelector("div[class=\"page category-page\"]"));
    }

    public WebElement page_title()
    {
        return  Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }
}
