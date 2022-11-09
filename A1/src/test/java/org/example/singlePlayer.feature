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

#
#Skulls Island and Skull Fortune Cards (10 marks)
#roll one skull and 7 swords with FC with two skulls => die
#roll 2 skulls and 6 swords with FC with 1 skull  => die
#roll 2 skulls  3(parrots/monkeys) with FC with two skulls: reroll 3 parrots get 2 skulls, 1 sword
#  reroll sword and 3 monkeys, get 3 skulls and 1 sword, stop => -900 for other players (no negative score) & you score 0
#roll 5 skulls, 3 monkeys with FC Captain, reroll 3 monkeys, get 2 skulls, 1 coin, stop => -1400 for other players
#roll 3 skulls and 5 swords with FC with two skulls: reroll 5 swords, get 5 coins, must stop  => -500 for other players
#
#Sea Battles (12 marks): your UI must report how much is the deduction if any. No negative scores are allowed.
#FC 2 swords, roll 4 monkeys, 3 skulls & 1 sword and die   => die and lose 300 points
#FC 3 swords, have 2 swords, 2 skulls and 4 parrots, reroll 4 parrots, get 4 skulls=> die and lose 500 points
#FC 4 swords, die on first roll with 2 monkeys, 3 (skulls/swords)  => die and lose 1000 points
#FC 2 swords, roll 3 monkeys 2 swords, 1 coin, 2 parrots  SC = 100 + 100 + 300 = 500
#FC 2 swords, roll 4 monkeys 1 sword, 1 skull & 2 parrots
#  then reroll 2 parrots and get 1 sword and 1 skull   SC = 200 +  300 = 500
#FC 3 swords, roll 3 monkeys 4 swords 1 skull SC = 100 + 200 + 500 = 800
#FC 3 swords, roll 4 monkeys 2 swords 2 skulls
#         then reroll 4 monkeys and get  2 skulls and 2 swords   => die and lose 500 points
#FC 4 swords, roll 3 monkeys 4 swords 1 skull  SC = 100 +200 + 1000 = 1300
#FC 4 swords, roll 3 monkeys, 1 sword, 1 skull, 1 diamond, 2 parrots
#  then reroll 2 parrots and get 2 swords thus you have 3 monkeys, 3 swords, 1 diamond, 1 skull
#  then reroll 3 monkeys and get  1 sword and 2 parrots  SC = 200 + 100 + 1000 = 1300