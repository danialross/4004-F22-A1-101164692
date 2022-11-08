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

#    roll 1 skull, 2 parrots, 3 swords, 2 coins, reroll parrots get 2 coins
#        reroll 3 swords, get 3 coins (SC 4000 for seq of 8 (with FC coin) + 8x100=800 = 4800)

  Scenario: row 50
    Given player was initialized
    When first roll is "Skull", "Parrot", "Parrot", "Sword", "Sword", "Sword", "Gold", "Gold"
    And re-roll "Parrots" and get "Gold", "Gold"
    And re-roll "Swords" and get "Gold", "Gold", "Gold"
    Then Score 4800