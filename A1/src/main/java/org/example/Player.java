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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Game.Dice[] getPlayerRoll() {
        return playerRoll;
    }

    public void setPlayerRoll(Game.Dice[] playerRoll) {
        this.playerRoll = playerRoll;
    }

    public Game.FortuneCard getFc() {
        return fc;
    }

    public void setFc(Game.FortuneCard fc) {
        this.fc = fc;
    }

    public Game.Dice[] getSavedDice() {
        return savedDice;
    }

    public void setSavedDice(Game.Dice[] savedDice) {
        this.savedDice = savedDice;
    }

    public int[] getSavedDicePos() {
        return savedDicePos;
    }

    public void setSavedDicePos(int[] savedDicePos) {
        this.savedDicePos = savedDicePos;
    }

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

        System.out.println("---- Fortune Card : " + fc + " ----");
        game.printPlayerRole(playerRoll);
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

                System.out.println("Select indexes of die to hold (not rolled) i.e: 0,1,2.. ");
                String[] DicePosInString = (scanner.next()).replaceAll("\\s", "").split(",");

                int[] savedDicePos = new int[DicePosInString.length];
                for(int i = 0; i<DicePosInString.length;i++){
                    savedDicePos[i] = Integer.parseInt(DicePosInString[i]);
                }


                playerRoll = game.changeDiceToNull(playerRoll,savedDicePos);
                playerRoll = game.rollDice(playerRoll,emptyArr);
                stop = true;

            }else if(action == 2){


                playerRoll = game.rollDice(playerRoll,emptyArr);
                game.printPlayerRole(playerRoll);
                stop = true;

            }else if(action == 3){

                score = game.scorePoints(playerRoll,fc);
                stop = true;

            }else if(action == 4){
                if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
                    playerRoll = game.sorceressReroll(playerRoll,null);

                } else if (fc == Game.FortuneCard.TREASURECHEST){

                    System.out.println("Select indexes of die to store in treasure chest (save score) i.e: 0,1,2.. ");
                    String[] DicePosInString = (scanner.next()).replaceAll("\\s", "").split(",");

                    int[] userInputPos = new int[DicePosInString.length];
                    for(int i = 0; i<DicePosInString.length;i++){
                        userInputPos[i] = Integer.parseInt(DicePosInString[i]);
                    }

                    savedDicePos = userInputPos;
                    savedDice = new Game.Dice[savedDicePos.length];
                    savedDice = game.getSavedDiceForTC(playerRoll,userInputPos);
                    playerRoll = game.changeDiceToNull(playerRoll,savedDicePos);

                } else if (fc == Game.FortuneCard.SORCERESS && !game.isContainSkull(playerRoll)){
                    System.out.println("No skull dice in players hand");
                }

            }else if(action == 5){
                if(fc == Game.FortuneCard.TREASURECHEST){

                    String showTC = "---- Treasure Chest : [";

                    for(int i = 0 ; i < savedDice.length; i++){
                        if(i == savedDice.length-1){
                            showTC += savedDice[i] + "] ----";
                        }else{
                            showTC += savedDice[i] + ",";
                        }
                    }

                    System.out.println(showTC);

                    System.out.println("Select the index of the dice in the treasure chest to take out i.e: 0,1,2...");
                    String[] DicePosInString = (scanner.next()).replaceAll("\\s", "").split(",");

                    int[] userInputPos = new int[DicePosInString.length];
                    for(int i = 0; i<DicePosInString.length;i++){
                        userInputPos[i] = Integer.parseInt(DicePosInString[i]);
                    }

                    for(int i = 0;i<userInputPos.length;i++){
                        savedDice[userInputPos[i]] = null;
                        savedDicePos[userInputPos[i]] = -1;
                    }

                    Game.Dice[] newSavedDice = new Game.Dice[savedDice.length-userInputPos.length];
                    int[] newSavedDicePos = new int[savedDice.length-userInputPos.length];
                    for( int i = 0; i< newSavedDice.length;i++){
                        if(this.savedDice[i]!=null){
                            newSavedDicePos[i] = this.savedDicePos[i];
                            newSavedDice[i] = this.savedDice[i];
                        }
                    }
                    this.savedDice = newSavedDice;
                    this.savedDicePos = newSavedDicePos;
                    game.changeNullToDice(playerRoll,userInputPos,savedDice);

                }
            }

        }
        game.printStatus("end");
        return score;
    }


}
