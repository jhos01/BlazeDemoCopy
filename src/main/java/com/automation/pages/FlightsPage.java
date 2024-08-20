package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsPage {
    WebDriver driver;

    By chooseFlighButton = By.xpath("//input[@value='Choose This Flight']");

    public FlightsPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFirstFlight(){
        driver.findElement(chooseFlighButton).click();
    }
}
