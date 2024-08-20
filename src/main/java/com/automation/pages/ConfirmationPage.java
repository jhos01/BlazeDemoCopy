package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    WebDriver driver;

    By confirmationMessage = By.tagName("h1");
    By bookingId = By.xpath("//td[contains(text(),'Id')]/following-sibling::td");

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }

    public String getBookingId(){
        return driver.findElement(bookingId).getText();
    }
}
