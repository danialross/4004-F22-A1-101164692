Feature: Single Player Scoring

  Scenario: row 45
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Sword", "Sword", "Sword", "Sword", "Sword"
    Then Die

  Scenario: row 46
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Sword"
    And re-roll swords to and get "Skull", "Skull", "Sword"
    Then Die

#  roll 2 skulls, 4 parrots, 2 swords, reroll swords, get 1 skull 1 sword  die
  Scenario: row 47
    Given player was initialized
    When first roll is "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword"
    And re-roll swords to and get "Skull", "Sword"
    Then Die