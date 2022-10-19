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

    public int playBaseRound(){
        Game.Dice[] emptyArr = {};

        game.printStatus("start");
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;

        while(stop == false){
            System.out.println("Select an action:");
            System.out.println("1. Choose dice to roll again");
            System.out.println("2. Reroll all dice");
            System.out.println("3. Score with current hand");

            if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
                System.out.println("4. Reroll a skull");

            }else if(fc == Game.FortuneCard.TREASURECHEST){
                System.out.println("4. Save Dice in treasure chest");

                if(savedDice.length != 0 ){
                    System.out.println("5. Take dice out from treasure chest");
                }
            }

            int action = scanner.nextInt();

            if(action == 1){

            }else if(action == 2){


            }else if(action == 3){


            }else if(action == 4){


            }else if(action == 5){
                
            }

        }
        game.printStatus("end");
        return score;
    }


}
