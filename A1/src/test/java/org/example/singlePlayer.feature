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

  Scenario: row 72
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Monkey", "Gold", "Gold"
    Then Score 600

#  part 2
#  Sorceress
  Scenario: row 77
    Given player was initialized
    When first roll is "Parrot", "Parrot", "Parrot", "Sword", "Monkey", "Gold", "Diamond", "Diamond"
    And fortune card is "Sorceress"
    And re-roll "Parrots" and get "Skull", "Monkey", "Monkey"
    And use sorceress to reroll and get "Monkey"
    Then Score 500

  Scenario: row 78
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Sword", "Sword"
    And fortune card is "Sorceress"
    And use sorceress to reroll and get "Parrot"
    And re-roll "Swords" and get "Parrot", "Parrot"
    Then Score 1000

  Scenario: row 79
    Given player was initialized
    When first roll is "Skull", "Monkey", "Monkey", "Monkey", "Parrot", "Parrot", "Parrot", "Parrot"
    And fortune card is "Sorceress"
    And re-roll "Monkeys" and get "Skull", "Parrot", "Parrot"
    And use sorceress to reroll and get "Parrot"
    Then Score 2000

# Monkey Business
  Scenario: row 82
    Given player was initialized
    When first roll is "Skull", "Monkey", "Monkey", "Monkey", "Parrot", "Parrot", "Parrot", "Gold"
    And fortune card is "Monkey Business"
    Then Score 1100

  Scenario: row 83
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Sword", "Sword", "Parrot", "Parrot", "Gold", "Gold"
    And fortune card is "Monkey Business"
    And re-roll "Swords" and get "Monkey", "Parrot"
    Then Score 1700

  Scenario: row 84
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Parrot", "Parrot"
    And fortune card is "Monkey Business"
    Then Die

#Treasure Chest (failed/missing)

#Full Chest
  Scenario: row 97
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Parrot"
    Then Score 400

  Scenario: row 98
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Gold", "Gold"
    And fortune card is "Captain"
    Then Score 1800

  Scenario: row 99
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword", "Gold"
    Then Score 1000

  Scenario: row 100
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Parrot", "Parrot", "Gold"
    And fortune card is "SeaBattle with 2 swords"
    And re-roll "Parrots" and get "Gold", "Sword"
    Then Score 1200

  Scenario: row 103
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Parrot", "Gold", "Gold", "Diamond", "Diamond", "Diamond"
    And fortune card is "Monkey Business"
    Then Score 1200


#Skulls Island and Skull Fortune Cards
 #roll one skull and 7 swords with FC with two skulls => die
  Scenario: row 106
    Given player was initialized
    When first roll is "Skull", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword"
    And fortune card is "2 Skulls"
    Then Die

# roll 2 skulls and 6 swords with FC with 1 skull  => die
  Scenario: row 107
    Given player was initialized
    When first roll is "Skull", "Skull", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword"
    And fortune card is "1 Skull"
    Then Die

# set other players score to 900 to show score dropped from 800 to 0 ( no negative numbers )
  Scenario: row 108
    Given player was initialized
    When first roll is "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Monkey", "Monkey", "Monkey"
    And other players score was 900
    And fortune card is "2 Skulls"
    And re-roll in skull island "Parrots" to get "Skull", "Skull", "Sword" then re-roll "Monkeys" and "Swords" and get "Skull", "Skull", "Skull", "Sword"
    Then player score is 0
    And other players score is 0

# other player score is 1400 and later reduced to 0 to show deduction
  Scenario: row 110
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Skull", "Skull", "Monkey", "Monkey", "Monkey"
    And other players score was 1400
    And fortune card is "Captain"
    And re-roll in skull island "Monkeys" to get "Skull", "Skull", "Gold"
    Then player score is 0
    And other players score is 0

  Scenario: row 111
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Sword", "Sword", "Sword", "Sword", "Sword"
    And other players score was 500
    And fortune card is "2 Skulls"
    And re-roll in skull island "Swords" to get "Gold", "Gold", "Gold", "Gold", "Gold"
    Then player score is 0
    And other players score is 0

#Sea Battles
  Scenario: row 114
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Monkey", "Sword"
    And fortune card is "SeaBattle with 2 swords"
    Then Die
    And player score is 0

  Scenario: row 115
    Given player was initialized
    When first roll is "Skull", "Skull", "Sword", "Sword", "Parrot", "Parrot", "Parrot", "Parrot"
    And fortune card is "SeaBattle with 3 swords"
    And re-roll "Parrots" and get "Skull", "Skull", "Skull", "Skull"
    Then Die
    And player score is 0

  Scenario: row 116
    Given player was initialized
    When first roll is "Skull", "Skull", "Skull", "Sword", "Sword", "Monkey", "Monkey", "Monkey"
    And fortune card is "SeaBattle with 4 swords"
    Then Die
    And player score is 0

  Scenario: row 117
    Given player was initialized
    When first roll is "Gold", "Parrot", "Parrot", "Sword", "Sword", "Monkey", "Monkey", "Monkey"
    And fortune card is "SeaBattle with 2 swords"
    Then Score 500

  Scenario: row 118
    Given player was initialized
    When first roll is "Parrot", "Parrot", "Skull", "Sword", "Monkey", "Monkey", "Monkey", "Monkey"
    And fortune card is "SeaBattle with 2 swords"
    And re-roll "Parrots" and get "Skull", "Sword"
    Then Score 500

  Scenario: row 120
    Given player was initialized
    When first roll is "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword", "Skull"
    And fortune card is "SeaBattle with 3 swords"
    Then Score 800

  Scenario: row 121
    Given player was initialized
    When first roll is "Skull", "Skull", "Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Sword"
    And fortune card is "SeaBattle with 3 swords"
    And re-roll "Monkeys" and get "Skull", "Skull", "Sword", "Sword"
    Then Die
    And player score is 0

  Scenario: row 123
    Given player was initialized
    When first roll is "Skull", "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword"
    And fortune card is "SeaBattle with 4 swords"
    Then Score 1300
    
  Scenario: row 121
    Given player was initialized
    When first roll is "Skull", "Monkey", "Monkey", "Monkey", "Sword", "Diamond", "Parrot", "Parrot"
    And fortune card is "SeaBattle with 4 swords"
    And re-roll "Parrots" and get "Sword", "Sword"
    And re-roll "Monkeys" and get "Sword", "Parrot", "Parrot"
    Then Score 1300