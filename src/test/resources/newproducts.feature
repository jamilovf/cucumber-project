Feature: Testing the New Products link

  Background:
    Given the home page is opened

  Scenario:
    When the New Products link is clicked
    Then a "No new products." new products error message is shown