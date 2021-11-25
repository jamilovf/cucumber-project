Feature: Testing the Search

  Background:
    Given the home page is opened

  Scenario: Successful Search
    Given the search 'search_query_top' is filled with 't-shirt'
    When the Search button is clicked
    Then a '1 result has been found.' search result message is shown

  Scenario Outline: Unsuccessful Search
    Given the search '<field>' is filled with '<parameter>'
    When the Search button is clicked
    Then a '<msg>' search error message is shown
    Examples:
      | field            | parameter | msg                                       |
      | search_query_top |           | Please enter a search keyword             |
      | search_query_top | a         | No results were found for your search "a" |
