package org.example;

import java.util.Scanner;

public class Player {

    public Game game = new Game();
    private String name;
    private Game.Dice[] playerRoll;
    private Game.FortuneCard fc;
    private int score;

    private Player[] players = new Player[3];

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

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

        Game.Dice[] init = {Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        Game.Dice[] empty = {};

        playerRoll = game.rollDice(init,empty);
        fc = Game.pickCard(null);

        for( int i = 0; i<players.length; i++){

            players[i] = new Player(String.valueOf(i));

        }
    }


    public void checkDead(){
        if(game.didDie(this.playerRoll,this.fc) == -1 ){
            this.score = 0;
        }
    }

    public void lockInPoints(Game.Dice[] riggedDice, Game.FortuneCard riggedFc){
        if(this.savedDice != null){
            playerRoll = game.changeNullToDice(playerRoll,this.savedDicePos,this.savedDice);
        }

        if(riggedDice.length != 0){
            playerRoll = riggedDice;
        }if(riggedFc != null){
            fc = riggedFc;
        }
        score = game.scorePoints(playerRoll,fc);
        checkDead();

    }

    public void playerReroll(int[] savedDiceIndex, Game.Dice[] riggedDice){

        saveDice(savedDiceIndex);
        playerRoll = game.rollDice(playerRoll,riggedDice);
        removeFromChest();


    }

    public void rerollSkull(Game.Dice riggedDice){

        playerRoll = game.sorceressReroll(playerRoll,riggedDice);

    }

    public void saveDice(int[] diceIndexToAdd){

        savedDicePos = diceIndexToAdd;
        savedDice = game.getSavedDice(playerRoll,diceIndexToAdd);
        playerRoll = game.changeDiceToNull(playerRoll,savedDicePos);

    }

    public void removeFromChest(){
        playerRoll = game.changeNullToDice(playerRoll,savedDicePos,savedDice);
        savedDicePos = null;
        savedDice = null;

    }

    public boolean skullIslandRoll(Game.Dice[] riggedDice){
        //true means had skull else no skull
        boolean flag = false;
        Game.Dice[] hand;

        if(riggedDice != null){
            hand = riggedDice;
        }else{
            hand = playerRoll;
        }

        int reducer = game.getScoreDeduction(game.calcNumSkull(hand),fc);

        for(int i = 0; i<players.length;i++){
            if(players[i].name != this.name){
                players[i].setScore(game.reducePlayerScore(reducer,players[i].score));
                flag = true;
            }
        }
        return flag;
    }

    public int promptUI(String rig){

        int action;
        int upperOption = 3 ;
        System.out.println("Player turn has started");
        Scanner scanner;

        if(rig != null){
            scanner = new Scanner(rig);
        }else{
            scanner = new Scanner(System.in);
        }

        System.out.println("Select an action:");
        System.out.println("1. Choose dice to roll again");
        System.out.println("2. Reroll all dice");
        System.out.println("3. Score with current hand");

        if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
            System.out.println("4. Reroll a skull");
            upperOption = 4;
        }else if(fc == Game.FortuneCard.TREASURECHEST){
            System.out.println("4. Save dice in treasure chest");
            upperOption = 4;
            if(savedDicePos != null){
                System.out.println("5. Take dice out from treasure chest");
                upperOption = 5;
            }

        }

        if(scanner.hasNextInt()){
            action = scanner.nextInt();
        }else{
            action = -555;
            System.out.println("Invalid Option");
        }

        System.out.println("userInput: " + action);

        while(action <=0 || action > upperOption){

            if(rig !=null){
                System.out.println("Invalid Option");
                if(action == -555)  {
                    System.out.println("infinite loop\n");

                }else if(action == 4 && upperOption == 3){
                    System.out.println("trying to sorcerer reroll without skull\n");

                }else if(action == 5 && savedDicePos == null){
                    System.out.println("trying take dice out from treasure chest when its empty\n");
                }

                return -555;
            }

            System.out.println("Select an action:");
            System.out.println("1. Choose dice to roll again");
            System.out.println("2. Reroll all dice");
            System.out.println("3. Score with current hand");
            if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
                System.out.println("4. Reroll a skull");
            }

            if(scanner.hasNextInt()){
                action = scanner.nextInt();
            }else{
                action = -555;
                System.out.println("Invalid Option");
            }

            System.out.println("userInput: " + action);

            if( action == 1 || action == 2 || action == 3 || (fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)) && action == 4) {
                return action;
            }


        }
        System.out.println("Player turn has ended\n");
        return action;
    }

    public int[] validateRerollInput(String rigging){
        int[] input = new int[0];
        Scanner scanner;
        if(rigging != null){
            scanner = new Scanner(rigging);
        }else{
            scanner = new Scanner(System.in);
        }


        boolean askAgain = true;

        while(askAgain){
            askAgain = false;

            if(rigging != null && input.length != 0){
                return null;
            }
            System.out.println("Select indexes of die to hold (not rolled) i.e: 0,1,2.. ");

            String[] DicePosInString = (scanner.next()).replaceAll("\\s", "").split(",");
            input = new int[DicePosInString.length];
            for(int i = 0; i<DicePosInString.length;i++){
                input[i] = Integer.parseInt(DicePosInString[i]);
            }

            for(int i = 0; i<input.length;i++){
                if(input[i] >= playerRoll.length || input[i] < 0){

                    askAgain = true;
                    System.out.println("Index Selected Out of Bound, try again between 0 and " + (playerRoll.length-1));
                    break;
                }else{
                    if(playerRoll[input[i]] == Game.Dice.SKULL){
                        askAgain = true;
                        System.out.println("Skull dice cannot be rerolled");
                        break;
                    }
                }
            }
            if(savedDicePos != null){
                if(savedDicePos.length + input.length > 6){
                    System.out.println("A minimum of 2 dice must be available to roll");
                    askAgain = true;
                }
            }else {
                if (input.length > 6) {
                    System.out.println("A minimum of 2 dice must be available to roll");
                    askAgain = true;
                }

            }

        }

        return input;
    }


}
