package com.automation.tests;

import com.automation.pages.ConfirmationPage;
import com.automation.pages.FlightsPage;
import com.automation.pages.HomePage;
import com.automation.pages.PurchasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlightBookingTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
    }

    @Test
    public void testFlightBooking(){
        HomePage homePage = new HomePage(driver);
        homePage.selectFromCity("Boston");
        homePage.selectToCity("London");
        homePage.clickFindFlight();

        String pageTitle = driver.getTitle();
        assertEquals("BlazeDemo - reserve",pageTitle, "El título no coincide.");

        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFirstFlight();

        assertTrue(driver.getCurrentUrl().contains("purchase"),"No se redirigió correctamente a la pagina de compra.");

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.enterName("Fernando");
        purchasePage.enterAddress("123 The Kings, MX");
        purchasePage.enterCity("Michigan");
        purchasePage.enterZipCode("10301");
        purchasePage.clickPurchaseFlight();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Thank you for your purchase today!", confirmationPage.getConfirmationMessage(),"El mensaje se confirmacion no coincide");

        String bookingId = confirmationPage.getBookingId();
        assertNotNull(bookingId, "No se encontró el ID de la reserva.");
        assertFalse(bookingId.isEmpty(), "El ID de reserva esta vació.");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
