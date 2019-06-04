@view
Feature: View Student Visa Details
  In order to apply for a student visa
  I could view visa details

  @positive
  Scenario: Successful View Study Visa Details Cucumber
    Given I opens Visa Finder page
    And I select Study visa option
    When I select Study Full Time
    Then I could see visa details




