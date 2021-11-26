Feature: Testing Newsletter link

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario: Successful subscription
    Given the newsletter 'newsletter-input' is filled with random 'randomEmail'
    When the Newsletter button is clicked
    Then the 'Newsletter : You have successfully subscribed to this newsletter.' newsletter error message is shown

  Scenario Outline: Unsuccessful subscription
    Given the newsletter '<field>' is filled with '<parameter>'
    When the Newsletter button is clicked
    Then the '<msg>' newsletter error message is shown
    Examples:
      | field            | parameter         | msg                                                                |
      | newsletter-input |                   | Newsletter : Invalid email address.                                |
      | newsletter-input | valid@gmail.com   | Newsletter : This email address is already registered.             |
