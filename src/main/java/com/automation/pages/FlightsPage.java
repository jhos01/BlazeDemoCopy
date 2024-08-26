package com.automation.pages;

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

    public String selectCheapestFlight(){
        createPricesList();
        List<String> flightInfo = new ArrayList<>();
        double smallestNumber = Double.MAX_VALUE;
        int cheapestFlightPosition = -1;
        for (int i = 0; i < priceList.size(); i++ ){
            String priceAsText = priceList.get(i).getText().replace("$", "");
            double priceAsNumber = Double.parseDouble(priceAsText);
            flightInfo.add(priceAsText);
            if (priceAsNumber < smallestNumber){
                smallestNumber =priceAsNumber;
                cheapestFlightPosition = i;
            }
        }

        if (cheapestFlightPosition != 1){
            String cheapestFlight = "- Cheapest Price: " + flightInfo.get(cheapestFlightPosition);
            buttons.get(cheapestFlightPosition).click();
            return cheapestFlight;
        }
        else {
            return "No flights available";
        }
    }
}
