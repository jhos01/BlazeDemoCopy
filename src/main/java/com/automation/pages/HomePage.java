package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By fromCityDropdown = By.name("fromPort");
    By toCityDropdown = By.name("toPort");
    By findFlightsButton = By.xpath("//input[@value='Find Flights']");

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity(String fromCity) {
        driver.findElement(fromCityDropdown).sendKeys(fromCity);
    }

    public void selectToCity(String toCity){
        driver.findElement(toCityDropdown).sendKeys(toCity);
    }

    public void clickFindFlight(){
        driver.findElement(findFlightsButton).click();
    }
}
