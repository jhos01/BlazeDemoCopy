package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {
    WebDriver driver;

    By nameField = By.id("inputName");
    By addressField = By.id("address");
    By cityField = By.id("city");
    By zipCodeField = By.id("zipCode");
    By purchaseFlightButton = By.xpath("//input[@value='Purchase Flight']");

    public PurchasePage(WebDriver driver){
        this.driver=driver;
    }

    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickPurchaseFlight() {
        driver.findElement(purchaseFlightButton).click();
    }
}
