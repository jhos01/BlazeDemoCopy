package resources.features.flight_booking;

Feature: Reservar vuelo en BlazeDemo

  Scenario: Realizar la compra de un vuelo
    Given el usuario esta en la pagina de inicio de BlazeDemo
    When selecciona "Boston" como ciudad de origen
    And selecciona "Lodon" como ciudad de Destino
    And busca vuelos
    Then debería ver la página de resultados de vuelos
    When selecciona el vuelo mas barato
    And ingresa la informacion de compra
    Then debería de ver la confirmacion de compra con un mensaje de exito
    And debería de ver un ID de reserva

