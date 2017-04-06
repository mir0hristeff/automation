@tiny-mce
Feature: Tiny MCE Editor
  As a user
  I want to be able to format a text

  Background:
    Given I am on base page
    When I open 'WYSIWYG Editor'
    Then I should be on 'WYSIWYG Editor' page

  @smoke-test
  Scenario: Clear editor and enter text
    When I type 'some text' in the tiny mce editor
    Then the tiny mce editor text should be 'some text'

  Scenario Outline: Clear editor and enter other text
    When I type '<text>' in the tiny mce editor
    Then the tiny mce editor text should be '<text>'
    Examples:
    |text             |
    |some other text  |
    |yet another text |