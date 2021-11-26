Feature: Testing the Registration page

  Background:
    Given the home page is opened
    And the Sign In link is clicked
    And the create an account 'email_create' is filled with 'xavi6@gmail.com'
    And the Create an account button is clicked

  Scenario Outline:
    Given the registration '<field>' is filled with '<parameter>'
    Given the registration '<field2>' is filled with '<parameter2>'
    Given the registration '<field3>' is filled with '<parameter3>'
    When the Register button is clicked
    Then the '<msg>' registration error message is shown
    Examples:
    | field              | parameter | field2             | parameter2 | field3 | parameter3 |  msg               |
    | customer_firstname |           |  customer_lastname |            | passwd |            | There are 8 errors |
    | customer_firstname | John      |  customer_lastname |            | passwd |            | There are 7 errors |
    | customer_firstname | John      |  customer_lastname | Doe        | passwd |            | There are 6 errors |
    | customer_firstname | John      |  customer_lastname | Doe        | passwd | 12345      | There are 5 errors |