package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    void row45() {

        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand,riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.checkDead();

        assertEquals(0,p1.getScore());
    }

    @Test
    void row46(){
        //roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 2 skulls 1 sword  die
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand,riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.checkDead();

        int[] userInput = {0,1,2,3,4};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(),userInput));


        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(),p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null,null,null,null,null,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(),riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(),p1.getSavedDicePos(),p1.getSavedDice()));

        p1.checkDead();

        assertEquals(0,p1.getScore());
    }

    @Test
    void row47(){
        //roll 2 skulls, 4 parrots, 2 swords, reroll swords, get 1 skull 1 sword  die
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.SWORD,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand,riggedhand));

        int[] userInput = {0,1,2,3,4,5};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(),userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(),p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null,null,null,null,null,null,Game.Dice.SKULL,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(),riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(),p1.getSavedDicePos(),p1.getSavedDice()));

        p1.checkDead();

        assertEquals(0,p1.getScore());


    }

    @Test
    void row48(){
        //roll 1 skull, 4 parrots, 3 swords, reroll swords, get 1 skull 2 monkeys
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand,riggedhand));

        int[] userInput = {0,1,2,3,4};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(),userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(),p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null,null,null,null,null,Game.Dice.SKULL,Game.Dice.MONKEY,Game.Dice.MONKEY};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(),riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(),p1.getSavedDicePos(),p1.getSavedDice()));

        p1.checkDead();
        //reroll 2 monkeys, get 1 skull 1 monkey and die

        userInput = new int[]{0, 1, 2, 3, 4, 5};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(),userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(),p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null,null,null,null,null,null,Game.Dice.SKULL,Game.Dice.MONKEY};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(),riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(),p1.getSavedDicePos(),p1.getSavedDice()));

        assertEquals(0,p1.getScore());
    }
}