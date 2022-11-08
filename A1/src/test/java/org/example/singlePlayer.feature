Feature: Single Player Scoring

  Scenario: row 45
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Sword", "Sword", "Sword", "Sword", "Sword"
    Then Die

  Scenario: row 46
    Given player was initialized
    When first roll is "Skull", "Sword", "Sword", "Sword", "Parrot", "Parrot", "Parrot", "Parrot"
    And re-roll "Swords" and get "Skull", "Skull", "Sword"
    Then Die

  Scenario: row 47
    Given player was initialized
    When first roll is "Skull", "Skull", "Sword", "Sword", "Parrot", "Parrot", "Parrot", "Parrot"
    And re-roll "Swords" and get "Skull", "Sword"
    Then Die

  Scenario: row 48
    Given player was initialized
    When first roll is "Skull", "Sword", "Sword", "Sword", "Parrot", "Parrot", "Parrot", "Parrot"
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
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Sword", "Sword", "Parrot", "Parrot"
    And re-roll "Parrots" and get "Sword", "Monkey"
    Then Score 300

  Scenario: row 54
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword"
    Then Score 300

  Scenario: row 55
    Given player was initialized
    When first roll is "Skull", "Skull", "Diamond", "Diamond", "Diamond", "Monkey", "Sword", "Parrot"
    Then Score 500

  Scenario: row 56
    Given player was initialized
    When first roll is "Skull", "Skull", "Gold", "Gold", "Gold", "Gold", "Sword", "Sword"
    And fortune card is "Diamond"
    Then Score 700

  Scenario: row 57
    Given player was initialized
    When first roll is "Skull", "Sword", "Sword", "Sword", "Parrot", "Parrot", "Parrot", "Parrot"
    Then Score 400

  Scenario: row 58
    Given player was initialized
    When first roll is "Skull", "Gold", "Gold", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And re-roll "Parrots" and get "Gold", "Sword"
    Then Score 800

  Scenario: row 59
    Given player was initialized
    When first roll is "Skull", "Gold", "Gold", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And fortune card is "Captain"
    And re-roll "Parrots" and get "Gold", "Sword"
    Then Score 1200

  Scenario: row 60
    Given player was initialized
    When first roll is "Skull", "Monkey", "Monkey", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And re-roll "Monkeys" and get "Skull", "Sword"
    And re-roll "Parrots" and get "Sword", "Monkey"
    Then Score 600

  Scenario: row 62
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey"
    Then Score 1100

  Scenario: row 63
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Parrot"
    Then Score 2100

  Scenario: row 64
    Given player was initialized
    When first roll is "Gold", "Gold", "Gold", "Gold", "Gold", "Gold", "Gold", "Gold"
    Then Score 5400

  Scenario: row 65
    Given player was initialized
    When first roll is "Diamond", "Diamond", "Diamond", "Diamond", "Diamond", "Diamond", "Diamond", "Diamond"
    Then Score 5400

  Scenario: row 66
    Given player was initialized
    When first roll is "Sword", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword"
    And fortune card is "Captain"
    Then Score 9000

  Scenario: row 67
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Sword"
    And re-roll "Swords" and get "Monkey", "Monkey"
    Then Score 4600

  Scenario: row 68
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Sword", "Sword", "Parrot", "Parrot"
    And fortune card is "Diamond"
    And re-roll "Parrots" and get "Diamond", "Diamond"
    Then Score 400

  Scenario: row 69
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Sword", "Sword", "Diamond", "Parrot"
    And re-roll "Monkeys" and get "Diamond", "Diamond"
    Then Score 500

  Scenario: row 70
    Given player was initialized
    When first roll is "Skull", "Gold", "Gold", "Monkey", "Parrot", "Sword", "Sword", "Sword"
    And re-roll "Swords" and get "Gold", "Monkey", "Parrot"
    Then Score 600

  Scenario: row 71
    Given player was initialized
    When first roll is "Skull", "Gold", "Gold", "Monkey", "Parrot", "Sword", "Sword", "Sword"
    And fortune card is "Diamond"
    And re-roll "Swords" and get "Gold", "Monkey", "Parrot"
    Then Score 500

  Scenario: row 71
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Monkey", "Gold", "Gold"
    Then Score 600