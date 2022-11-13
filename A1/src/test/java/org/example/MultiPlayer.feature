Feature: Player 1 Multi Player
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
