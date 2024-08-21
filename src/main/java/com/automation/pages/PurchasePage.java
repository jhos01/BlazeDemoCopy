package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
    WebDriver driver;
    @FindBy( id = "inputName")
    private WebElement nameField;

    @FindBy(id = "address")
    private WebElement addressField;

    @FindBy (id = "city")
    private WebElement cityField;

    @FindBy(id = "zipCode")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightButton;

    public PurchasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void fillPurchaseFields(String name, String address,String city, String zipCode){
        nameField.sendKeys(name);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zipCode);
    }

    public void clickPurchaseFlight() {
        purchaseFlightButton.click();
    }
}
