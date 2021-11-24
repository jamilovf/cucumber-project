Feature: Testing the Search

  Background:
    Given the home page is opened

  Scenario:
    When the Search button is clicked
    Then a "Please enter a search keyword" search error message is shown