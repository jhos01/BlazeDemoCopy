package com.automation.steps;

import com.automation.pages.ConfirmationPage;
import com.automation.pages.FlightsPage;
import com.automation.pages.HomePage;
import com.automation.pages.PurchasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class FlightBookingSteps {

    WebDriver driver;
    HomePage homePage;
    FlightsPage flightsPage;
    PurchasePage purchasePage;
    ConfirmationPage confirmationPage;

    @Given("the user is on the BlazeDemo homepage")
    public void theUserIsOnTheBlazeDemoHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
        homePage = new HomePage(driver);
    }

    @When("they select {string} as the departure city")
    public void theySelectAsTheDepartureCity(String fromCity) {
        homePage.selectFromCity(fromCity);
    }

    @And("they select {string} as the destination city")
    public void theySelectAsTheDestinationCity(String toCity) {
        homePage.selectToCity(toCity);
    }

    @And("they search for flights")
    public void theySearchForFlights() {
        homePage.clickFindFlight();
    }

    @Then("they should see the flight results page")
    public void theyShouldSeeTheFlightResultsPage() {
        String pageTitle = driver.getTitle();
        assertEquals("BlazeDemo - reserve", pageTitle );
    }

    @When("they select the cheapest available flight")
    public void theySelectTheCheapestAvailableFlight() {
        flightsPage = new FlightsPage(driver);
        flightsPage.selectFirstFlight();
    }

    @And("they enter the purchase information")
    public void theyEnterThePurchaseInformation() {
        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.enterName("Fernando");
        purchasePage.enterAddress("123 The Kings, MX");
        purchasePage.enterCity("Michigan");
        purchasePage.enterZipCode("10301");
        purchasePage.clickPurchaseFlight();
    }

    @Then("they should see a purchase confirmation with a success message")
    public void theyShouldSeeAPurchaseConfirmationWithASuccessMessage() {
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Thank you for your purchase today!", confirmationPage.getConfirmationMessage());
    }

    @And("they should see a booking ID")
    public void theyShouldSeeABookingID() {
        confirmationPage = new ConfirmationPage(driver);
        String bookingId = confirmationPage.getBookingId();
        assertNotNull(bookingId);
        assertFalse("El ID de reserva esta vació.", bookingId.isEmpty());
        driver.quit();
    }
}
