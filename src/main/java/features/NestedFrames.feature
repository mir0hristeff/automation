@nested-frames
Feature: Nested frames
  As a user
  I want to be able to verify text in iFrames

  Background:
    Given I am on base page
    When I open 'Nested Frames'

  @regression
  Scenario: Verify iFrames text
    Then upper left frame text should be 'LEFT'
    Then upper middle frame text should be 'MIDDLE'
    And upper right frame text should be 'RIGHT'
    And bottom frame text should be 'BOTTOM'

  @smoke-test
  Scenario Outline: Verify iFrame text by position
    Then <framePosition> frame text should be '<expectedText>'
    Examples:
    |framePosition|expectedText|
    |upper left   |LEFT        |
    |upper middle |MIDDLE      |
    |upper right  |RIGHT       |
    |bottom       |BOTTOM      |