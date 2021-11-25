Feature: Testing the Create an account page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario Outline:
    Given the create an account '<field>' is filled with '<parameter>'
    When the Create an account button is clicked
    Then the '<msg>' create an account error message is shown
    Examples:
      | field        | parameter         | msg                        |
      | email_create |                   | Invalid email address.     |
      | email_create | invalid.email.com | Invalid email address.     |
      | email_create | a@gmail.com       | An account using this email address has already been registered. Please enter a valid password or request a new one.       |