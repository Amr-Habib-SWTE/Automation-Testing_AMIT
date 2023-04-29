package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_currencies {
    public WebElement selectCurrency(){return driver.findElement(By.id("customerCurrency"));}
    public List<WebElement> products(){return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));}

}
