package com.automation.steps;

import com.automation.pages.ConfirmationPage;
import com.automation.pages.FlightsPage;
import com.automation.pages.HomePage;
import com.automation.pages.PurchasePage;
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

    @Given("el usuario esta en la pagina de inicio de BlazeDemo")
    public void el_usuario_esta_en_la_pagina_de_inicio_de_BlazeDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
        homePage = new HomePage(driver);
    }

    @When("selecciona {string} como ciudad de origen")
    public void selecciona_ciudad_de_origen(String fromCity) {
        homePage.selectFromCity(fromCity);
    }
    @When("selecciona {string} como ciudad de Destino")
    public void selecciona_ciudad_de_destino(String toCity){
        homePage.selectToCity(toCity);
    }

    @When("busca vuelos")
    public void busca_vuelo()
    {
        homePage.clickFindFlight();
    }

    @Then("debería ver la página de resultados de vuelos")
    public void debería_ver_la_página_de_resultados_de_vuelos(){
        String pageTitle = driver.getTitle();
        assertEquals("BlazeDemo - reserve",pageTitle, "El título no coincide.");
    }

    @When("selecciona el vuelo mas barato")
    public void selecciona_el_vuelo_mas_barato() {
        flightsPage = new FlightsPage(driver);
        flightsPage.selectFirstFlight();
    }

    @When("ingresa la informacion de compra")
    public void ingresa_la_informacion_de_compra(){
        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.enterName("Fernando");
        purchasePage.enterAddress("123 The Kings, MX");
        purchasePage.enterCity("Michigan");
        purchasePage.enterZipCode("10301");
        purchasePage.clickPurchaseFlight();
    }

    @Then("debería de ver la confirmacion de compra con un mensaje de exito")
    public void debería_de_ver_la_confirmacion_de_compra_con_un_mensaje_de_exito(){
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        assertEquals("Thank you for your purchase today!", confirmationPage.getConfirmationMessage(),"El mensaje se confirmacion no coincide");
    }

    @Then("debería de ver un ID de reserva")
    public void debería_de_ver_un_ID_de_reserva(){
        String bookingId = confirmationPage.getBookingId();
        assertNotNull(bookingId, "No se encontró el ID de la reserva.");
        assertFalse("El ID de reserva esta vació.", bookingId.isEmpty());
        driver.quit();
    }
}
