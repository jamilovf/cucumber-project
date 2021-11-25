Feature: Testing the ContactUs page

  Background:
    Given the home page is opened
    And the Contact Us link is clicked

  Scenario Outline:
    Given the first field '<field>' is filled with '<parameter>'
    And the second field '<field2>' is filled with '<parameter2>'
    And the third field '<field3>' is filled with '<parameter3>'
    When the Send button is clicked
    Then a '<msg>' contact us error message is shown
    Examples:
      | field | parameter         | field2     | parameter2        | field3  | parameter3        | msg                                            |
      | email |                   | id_contact |                   | message |                   | Invalid email address.                         |
      | email | valid@email.com   | id_contact |                   | message |                   | The message cannot be blank.                   |
      | email | valid@email.com   | id_contact |                   | message | Hello             | Please select a subject from the list provided.|
