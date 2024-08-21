package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    WebDriver driver;
    @FindBy (xpath = "//input[@value='Choose This Flight']")
    private WebElement chooseFlightButton;

    public FlightsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectFirstFlight(){
        chooseFlightButton.click();
    }
}
