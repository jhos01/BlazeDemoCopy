package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FlightsPage {
    WebDriver driver;

    @FindBy(css = ".btn.btn-small")
    public List<WebElement> buttons;

    @FindBy(tagName = "td")
    public List<WebElement> tdElements;

    public List<WebElement> priceList = new ArrayList<>();

    public FlightsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createPricesList() {
        for (WebElement td: tdElements){
            if (td.getText().contains("$")){
                priceList.add(td);
            }
        }
    }
    public void selectCheapestFlight(){
        createPricesList();
        double smallestNumber = Double.MAX_VALUE;
        int cheapestFlightPosition = 0;
        for (int i = 0; i < priceList.size(); i++ ){
            String priceAsText = priceList.get(i).getText().replace("$", "");
            double priceAsNumber = Double.parseDouble(priceAsText);
            if (priceAsNumber < smallestNumber){
                smallestNumber =priceAsNumber;
                cheapestFlightPosition = i;
            }
        }
        buttons.get(cheapestFlightPosition).click();
    }
}
