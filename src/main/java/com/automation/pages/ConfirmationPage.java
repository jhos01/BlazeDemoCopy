package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    WebDriver driver;

    @FindBy(tagName = "h1")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//td[contains(text(),'Id')]/following-sibling::td")
    private WebElement bookingId;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public String getBookingId(){
        return bookingId.getText();
    }
}
