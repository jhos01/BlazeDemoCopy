package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(name = "fromPort")
    private WebElement fromCityDropdown;

    @FindBy(name = "toPort")
    private WebElement toCityDropdown;

    @FindBy(xpath = "//input[@value='Find Flights']")
    private WebElement findFlightsButton;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectFromAndToCity(String fromCity, String toCity) {
        fromCityDropdown.sendKeys(fromCity);
        toCityDropdown.sendKeys(toCity);
    }

    public void clickFindFlight(){
        findFlightsButton.click();
    }
}
