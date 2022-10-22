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




}
