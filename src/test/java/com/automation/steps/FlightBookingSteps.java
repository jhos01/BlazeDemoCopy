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

import static org.testng.AssertJUnit.*;

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

    @When("they select {string} as the departure city and they select {string} as the destination city")
    public void theySelectAsTheDepartureCityAndTheySelectAsTheDestinationCity(String fromCity, String toCity) {
        homePage = new HomePage(driver);
        homePage.selectFromAndToCity(fromCity, toCity);
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
        System.out.println("string de test");
        flightsPage.selectCheapestFlight();
    }

    @And("they enter the purchase information")
    public void theyEnterThePurchaseInformation() {
        purchasePage = new PurchasePage(driver);
        purchasePage.fillPurchaseFields("Fernando","123 The Kings, MX","Michigan","10301");
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
