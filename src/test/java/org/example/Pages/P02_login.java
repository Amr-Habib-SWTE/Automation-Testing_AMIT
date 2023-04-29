package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P02_login {

    public WebElement clickongotologinbutton() {
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement email() {
        return driver.findElement(By.name("Email"));
    }

    public WebElement password() {
        return driver.findElement(By.name("Password"));
    }

    public WebElement RememberMe() {
        return driver.findElement(By.id("RememberMe"));
    }

    public WebElement clickLogin() {
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\" ]"));
    }

    public WebElement invalidemail() {
        return driver.findElement(By.name("Email"));
    }

    public WebElement invalidpassword() {
        return driver.findElement(By.name("Password"));
    }

    public WebElement verfiymyaccountappered() {
        return driver.findElement(By.className("ico-logout"));
    }


}


