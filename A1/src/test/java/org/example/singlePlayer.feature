Feature: Single Player Scoring

  Scenario: row 45
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Sword", "Sword", "Sword", "Sword", "Sword"
    Then Die

  Scenario: row 46
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And re-roll "Swords" and get "Skull", "Skull", "Sword"
    Then Die

  Scenario: row 47
    Given player was initialized
    When first roll is "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword"
    And re-roll "Swords" and get "Skull", "Sword"
    Then Die

  Scenario: row 48
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And re-roll "Swords" and get "Skull", "Monkey", "Monkey"
    And re-roll "Monkey" and get "Skull", "Monkey"
    Then Die

  Scenario: row 50
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Sword", "Sword", "Sword", "Gold", "Gold"
    And re-roll "Parrots" and get "Gold", "Gold"
    And re-roll "Swords" and get "Gold", "Gold", "Gold"
    Then Score 4800

  Scenario: row 52
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Parrot", "Parrot", "Diamond", "Diamond", "Gold", "Gold"
    And fortune card is "Captain"
    Then Score 800

  Scenario: row 53
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Skull", "Skull", "Sword", "Sword", "Parrot", "Parrot"
    And re-roll "Parrots" and get "Sword", "Monkey"
    Then Score 300