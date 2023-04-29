package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;


public class P01_register {

    public WebElement clickonregistericon() {
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement selectgender() {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement enterfirstname() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement enterlastname() {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement selectdayofbirth() {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement selectmonthofbirth() {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement selectYearOfBirth() {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement enteremail() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement entercompanyname() {
        return driver.findElement(By.id("Company"));
    }

    public WebElement unselectcheckboxnewsletter() {
        return driver.findElement(By.id("Newsletter"));
    }

    public WebElement enterpassword() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement enterconfirmpassword() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement clickonregisterbutton() {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement accountiscreatedsuccessfully() {
        return driver.findElement(By.className("result"));
    }
}
