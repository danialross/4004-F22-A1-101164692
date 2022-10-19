package org.example;

import java.util.Scanner;

public class Player {

    public Game game = new Game();
    private String name;
    private Game.Dice[] playerRoll;
    private Game.FortuneCard fc;
    private int score;


    //if Treasure Chest is fc
    private Game.Dice[] savedDice;
    private int[] savedDicePos;

    // constructor initializes all variables needed to start the game
    public Player(String name){
        this.name = name;
        score = 0;
    }
    public void roundStarting(){
        Game.Dice[] emptyArr = {};
        Game.Dice[] newHand = {Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        playerRoll = game.rollDice(newHand,emptyArr);
        fc = Game.pickCard(null);

        game.printPlayerRole(playerRoll);
        System.out.println("---- Fortune Card : " + fc + " ----");
    }



}
