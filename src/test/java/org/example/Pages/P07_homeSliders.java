package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07_homeSliders {
    public List<WebElement> sliders()
    {
        return Hooks.driver.findElements(By.cssSelector("a[class=\"nivo-imageLink\"]"));
    }
}
