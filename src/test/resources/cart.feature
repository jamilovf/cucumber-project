Feature: Testing the Cart

  Background:
    Given the home page is opened

  Scenario:
    When the Cart link is clicked
    Then a "Your shopping cart is empty." cart error message is shown