package org.example;

public class Player {

    Game game = new Game();
    String name;
    Game.Dice[] playerRoll;
    Game.FortuneCard fc;
    int score;


    //if Treasure Chest is fc
    Game.Dice[] savedDice;
    int[] savedDicePos;

    // constructor initializes all variables needed to start the game
    public Player(String name){
        this.name = name;
        Game.Dice[] newHand = {Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        Game.Dice[] emptyHand = {};
        playerRoll = game.rollDice(newHand,emptyHand);
        fc = Game.pickCard(null);
        score = 0;

        if(fc == Game.FortuneCard.TREASURECHEST){
            savedDice = newHand;
            savedDicePos = new int[8];
        }
    }

}
