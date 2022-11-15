Feature: Multi Player
#    multi-player test

  Scenario: row 130
    Given players initialized
    When "Player 1" first roll is "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "Captain" fortune card
    And "Player 2" first roll is "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "1 Skull" fortune card
    And "Player 3" first roll is "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" with "Gold" fortune card
    And Players score are updated
    Then "Player 1" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "Captain" fortune card and score 4000
    And "Player 2" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "1 Skull" fortune card and score 2000
    And "Player 3" had roll of "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" and "Gold" fortune card and score 0
    And "Player 1" is the winner

  Scenario: row 134
    Given players initialized
    When "Player 1" first roll is "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "Captain" fortune card
    And "Player 2" first roll is "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" with "Gold" fortune card
    Then "Player 1" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "Captain" fortune card and score 4000
    And "Player 3" skull island roll is "Skull","Skull","Skull","Skull","Skull","Skull","Parrot","Parrot" with "Captain" fortune card
    And "Player 3" reduced "Player 1" score with skull island roll with 6 skulls
    And Players score are updated
    Then "Player 1" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "Captain" fortune card and score 2800
    And "Player 2" had roll of "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" and "Gold" fortune card and score 0
    #   remaining dice when entering skull island defaults as Diamond
    And "Player 3" had roll of "Diamond","Diamond" and "Captain" fortune card and score 0
    And "Player 1" first roll is "Parrot","Parrot","Parrot","Parrot","Monkey","Monkey","Monkey","Monkey" with "Gold" fortune card
    And "Player 2" first roll is "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" with "Captain" fortune card
    And "Player 3" first roll is "Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey" with "1 Skull" fortune card
    And Players score are updated
    Then "Player 1" had roll of "Parrot","Parrot","Parrot","Parrot","Monkey","Monkey","Monkey","Monkey" and "Gold" fortune card and score 3800
    And "Player 2" had roll of "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" and "Captain" fortune card and score 0
    And "Player 3" had roll of "Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey" and "1 Skull" fortune card and score 0
    And "Player 1" is the winner

  Scenario: row 142
    Given players initialized
    When "Player 1" first roll is "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" with "Captain" fortune card
    And "Player 2" first roll is "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "Captain" fortune card
    And "Player 3" first roll is "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "2 Skulls" fortune card
    And Players score are updated
    Then "Player 1" had roll of "Skull","Skull","Skull","Monkey","Monkey","Monkey","Monkey","Monkey" and "Captain" fortune card and score 0
    And "Player 1" first roll is "Sword","Sword","Sword","Sword","Sword","Sword","Sword","Sword" with "Captain" fortune card
    And Players score are updated
    And "Player 2" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "Captain" fortune card and score 4000
    And "Player 3" had roll of "Skull","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "2 Skulls" fortune card and score 0
    And "Player 1" had roll of "Sword","Sword","Sword","Sword","Sword","Sword","Sword","Sword" and "Captain" fortune card and score 9000
    And "Player 1" is the winner

    Scenario: row 147
      Given players initialized
      When "Player 1" first roll is "Skull","Skull","Sword","Sword","Sword","Sword","Sword","Sword" with "Gold" fortune card
      Then "Player 1" had roll of "Skull","Skull","Sword","Sword","Sword","Sword","Sword","Sword" and "Gold" fortune card and score 1100
      And "Player 2" skull island roll is "Skull","Skull","Skull","Skull","Skull","Skull","Skull","Gold" with "Sorceress" fortune card and do a sorceress reroll to get a "Parrot" and roll remaining dice to get "Skull", "Skull"
      And "Player 2" reduced "Player 1" score with skull island roll with 8 skulls
      Then "Player 1" had roll of "Skull","Skull","Sword","Sword","Sword","Sword","Sword","Sword" and "Gold" fortune card and score 300
      And "Player 2" score is 0
      And "Player 3" score is 0

