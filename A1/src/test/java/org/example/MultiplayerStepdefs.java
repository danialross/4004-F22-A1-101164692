package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MultiplayerStepdefs {

    Player p1;
    Player p2;
    Player p3;

    @Given("players initialized")
    public void playersInitialized() {
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        p3 = new Player("Player 3");
    }

    @When("{string} first roll is {string},{string},{string},{string},{string},{string},{string},{string} with {string} fortune card")
    public void firstRollIsWithFortuneCard(String input, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String card) {

        String[] diceAsString = {d1,d2,d3,d4,d5,d6,d7,d8};
        Game.Dice[] playerRoll = new Game.Dice[]{null,null,null,null,null,null,null,null};
        Game.FortuneCard playerCard;
        Player player;

        for(int i = 0;i< diceAsString.length;i++){
            if (diceAsString[i].equals("Sword")) {
                playerRoll[i] = Game.Dice.SWORD;
            } else if (diceAsString[i].equals("Skull")) {
                playerRoll[i] = Game.Dice.SKULL;
            } else if (diceAsString[i].equals("Gold")) {
                playerRoll[i] = Game.Dice.GOLD;
            } else if (diceAsString[i].equals("Diamond")) {
                playerRoll[i] = Game.Dice.DIAMOND;
            } else if (diceAsString[i].equals("Parrot")) {
                playerRoll[i] = Game.Dice.PARROT;
            } else {
                playerRoll[i] = Game.Dice.MONKEY;
            }
        }

        if(card.equals("Treasure Chest")) {
            playerCard = Game.FortuneCard.TREASURECHEST;
        }else if(card.equals("Captain")) {
            playerCard = Game.FortuneCard.CAPTAIN;
        }else if(card.equals("Sorceress")) {
            playerCard = Game.FortuneCard.SORCERESS;
        }else if(card.equals("Monkey Business")) {
            playerCard = Game.FortuneCard.MONKEYBUSINESS;
        }else if(card.equals("Diamond")) {
            playerCard = Game.FortuneCard.DIAMOND;
        }else if(card.equals("Gold")) {
            playerCard = Game.FortuneCard.GOLD;
        }else if(card.equals("1 Skull")) {
            playerCard = Game.FortuneCard.SKULLX1;
        }else if(card.equals("2 Skulls")) {
            playerCard = Game.FortuneCard.SKULLX2;
        }else if(card.equals("SeaBattle with 4 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX4SWORDS;
        }else if(card.equals("SeaBattle with 3 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX3SWORDS;
        }else {
            playerCard = Game.FortuneCard.SEABATTLEX2SWORDS;
        }

        if (input.equals("Player 1")){
            player = p1;
        }else if (input.equals("Player 2")){
            player = p2;
        }else{
            player = p3;
        }

        player.roundStarting(playerRoll,playerCard);
        player.doOption(player.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);


    }


    @And("{string} had roll of {string},{string},{string},{string},{string},{string},{string},{string} and {string} fortune card and score {int}")
    public void hadRollOfAndFortuneCardAndScore(String input, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String card,int score)  {
        String[] diceAsString = {d1,d2,d3,d4,d5,d6,d7,d8};
        Game.Dice[] playerRoll = new Game.Dice[]{null,null,null,null,null,null,null,null};
        Game.FortuneCard playerCard;
        Player player;

        for(int i = 0;i< diceAsString.length;i++){
            if (diceAsString[i].equals("Sword")) {
                playerRoll[i] = Game.Dice.SWORD;
            } else if (diceAsString[i].equals("Skull")) {
                playerRoll[i] = Game.Dice.SKULL;
            } else if (diceAsString[i].equals("Gold")) {
                playerRoll[i] = Game.Dice.GOLD;
            } else if (diceAsString[i].equals("Diamond")) {
                playerRoll[i] = Game.Dice.DIAMOND;
            } else if (diceAsString[i].equals("Parrot")) {
                playerRoll[i] = Game.Dice.PARROT;
            } else {
                playerRoll[i] = Game.Dice.MONKEY;
            }
        }

        if(card.equals("Treasure Chest")) {
            playerCard = Game.FortuneCard.TREASURECHEST;
        }else if(card.equals("Captain")) {
            playerCard = Game.FortuneCard.CAPTAIN;
        }else if(card.equals("Sorceress")) {
            playerCard = Game.FortuneCard.SORCERESS;
        }else if(card.equals("Monkey Business")) {
            playerCard = Game.FortuneCard.MONKEYBUSINESS;
        }else if(card.equals("Diamond")) {
            playerCard = Game.FortuneCard.DIAMOND;
        }else if(card.equals("Gold")) {
            playerCard = Game.FortuneCard.GOLD;
        }else if(card.equals("1 Skull")) {
            playerCard = Game.FortuneCard.SKULLX1;
        }else if(card.equals("2 Skulls")) {
            playerCard = Game.FortuneCard.SKULLX2;
        }else if(card.equals("SeaBattle with 4 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX4SWORDS;
        }else if(card.equals("SeaBattle with 3 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX3SWORDS;
        }else {
            playerCard = Game.FortuneCard.SEABATTLEX2SWORDS;
        }

        if (input.equals("Player 1")){
            player = p1;
        }else if (input.equals("Player 2")){
            player = p2;
        }else{
            player = p3;
        }

        Assertions.assertArrayEquals(playerRoll,player.getPlayerRoll());
        Assertions.assertEquals(playerCard,player.getFc());
        Assertions.assertEquals(score,player.getScore());
    }

    @And("{string} is the winner")
    public void isTheWinner(String winner) {
        Assertions.assertEquals(winner,p1.game.getWinner(p1.getPlayers()).getName());
    }

    @And("Players score are updated")
    public void playersScoreAreUpdated() {
        p1.getPlayers()[0].setScore(p1.getScore());
        p1.getPlayers()[1].setScore(p2.getScore());
        p1.getPlayers()[2].setScore(p3.getScore());

        p2.getPlayers()[0].setScore(p2.getScore());
        p2.getPlayers()[1].setScore(p1.getScore());
        p2.getPlayers()[2].setScore(p3.getScore());

        p3.getPlayers()[0].setScore(p3.getScore());
        p3.getPlayers()[1].setScore(p1.getScore());
        p3.getPlayers()[2].setScore(p2.getScore());
    }

    @And("{string} skull island roll is {string},{string},{string},{string},{string},{string},{string},{string} with {string} fortune card")
    public void skullIslandRollIsWithFortuneCard(String input, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String card) {

        String[] diceAsString = {d1,d2,d3,d4,d5,d6,d7,d8};
        Game.Dice[] playerRoll = new Game.Dice[]{null,null,null,null,null,null,null,null};
        Game.FortuneCard playerCard;
        Player player;

        for(int i = 0;i< diceAsString.length;i++){
            if (diceAsString[i].equals("Sword")) {
                playerRoll[i] = Game.Dice.SWORD;
            } else if (diceAsString[i].equals("Skull")) {
                playerRoll[i] = Game.Dice.SKULL;
            } else if (diceAsString[i].equals("Gold")) {
                playerRoll[i] = Game.Dice.GOLD;
            } else if (diceAsString[i].equals("Diamond")) {
                playerRoll[i] = Game.Dice.DIAMOND;
            } else if (diceAsString[i].equals("Parrot")) {
                playerRoll[i] = Game.Dice.PARROT;
            } else {
                playerRoll[i] = Game.Dice.MONKEY;
            }
        }

        if(card.equals("Treasure Chest")) {
            playerCard = Game.FortuneCard.TREASURECHEST;
        }else if(card.equals("Captain")) {
            playerCard = Game.FortuneCard.CAPTAIN;
        }else if(card.equals("Sorceress")) {
            playerCard = Game.FortuneCard.SORCERESS;
        }else if(card.equals("Monkey Business")) {
            playerCard = Game.FortuneCard.MONKEYBUSINESS;
        }else if(card.equals("Diamond")) {
            playerCard = Game.FortuneCard.DIAMOND;
        }else if(card.equals("Gold")) {
            playerCard = Game.FortuneCard.GOLD;
        }else if(card.equals("1 Skull")) {
            playerCard = Game.FortuneCard.SKULLX1;
        }else if(card.equals("2 Skulls")) {
            playerCard = Game.FortuneCard.SKULLX2;
        }else if(card.equals("SeaBattle with 4 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX4SWORDS;
        }else if(card.equals("SeaBattle with 3 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX3SWORDS;
        }else {
            playerCard = Game.FortuneCard.SEABATTLEX2SWORDS;
        }

        if (input.equals("Player 1")){
            player = p1;
        }else if (input.equals("Player 2")){
            player = p2;
        }else{
            player = p3;
        }

        Game.Dice[] riggedSI = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.PARROT};

        player.roundStarting(playerRoll,playerCard);
        player.doOption(player.promptUI(""),new Game.Dice[]{},null, null,null,"3",null);

    }

    @And("{string} reduced {string} score with skull island roll")
    public void reducedScoreWithSkullIslandRoll(String input1, String input2) {
        Player reducer;
        Player reducee;
        if (input1.equals("Player 1")){
            reducer = p1;
        }else if (input1.equals("Player 2")){
            reducer = p2;
        }else{
            reducer = p3;
        }

        if (input2.equals("Player 1")){
            reducee = p1;
        }else if (input2.equals("Player 2")){
            reducee = p2;
        }else{
            reducee = p3;
        }

        int reduceBy = reducee.game.getScoreDeduction(6,reducer.getFc());

        reducee.game.reducePlayerScore(reduceBy,reducee.getScore());
        reducee.setScore(reducee.game.reducePlayerScore(reduceBy,reducee.getScore()));



    }

    @And("{string} had roll of {string},{string} and {string} fortune card and score {int}")
    public void hadRollOfAndFortuneCardAndScore(String input, String d1, String d2, String card, int score) {
        String[] diceAsString = {d1,d2};
        Game.Dice[] playerRoll = new Game.Dice[]{null,null};
        Game.FortuneCard playerCard;
        Player player;

        for(int i = 0;i< diceAsString.length;i++){
            if (diceAsString[i].equals("Sword")) {
                playerRoll[i] = Game.Dice.SWORD;
            } else if (diceAsString[i].equals("Skull")) {
                playerRoll[i] = Game.Dice.SKULL;
            } else if (diceAsString[i].equals("Gold")) {
                playerRoll[i] = Game.Dice.GOLD;
            } else if (diceAsString[i].equals("Diamond")) {
                playerRoll[i] = Game.Dice.DIAMOND;
            } else if (diceAsString[i].equals("Parrot")) {
                playerRoll[i] = Game.Dice.PARROT;
            } else {
                playerRoll[i] = Game.Dice.MONKEY;
            }
        }

        if(card.equals("Treasure Chest")) {
            playerCard = Game.FortuneCard.TREASURECHEST;
        }else if(card.equals("Captain")) {
            playerCard = Game.FortuneCard.CAPTAIN;
        }else if(card.equals("Sorceress")) {
            playerCard = Game.FortuneCard.SORCERESS;
        }else if(card.equals("Monkey Business")) {
            playerCard = Game.FortuneCard.MONKEYBUSINESS;
        }else if(card.equals("Diamond")) {
            playerCard = Game.FortuneCard.DIAMOND;
        }else if(card.equals("Gold")) {
            playerCard = Game.FortuneCard.GOLD;
        }else if(card.equals("1 Skull")) {
            playerCard = Game.FortuneCard.SKULLX1;
        }else if(card.equals("2 Skulls")) {
            playerCard = Game.FortuneCard.SKULLX2;
        }else if(card.equals("SeaBattle with 4 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX4SWORDS;
        }else if(card.equals("SeaBattle with 3 swords")) {
            playerCard = Game.FortuneCard.SEABATTLEX3SWORDS;
        }else {
            playerCard = Game.FortuneCard.SEABATTLEX2SWORDS;
        }

        if (input.equals("Player 1")){
            player = p1;
        }else if (input.equals("Player 2")){
            player = p2;
        }else{
            player = p3;
        }

        Assertions.assertArrayEquals(playerRoll,player.getPlayerRoll());
        Assertions.assertEquals(playerCard,player.getFc());
        Assertions.assertEquals(score,player.getScore());
    }
}
