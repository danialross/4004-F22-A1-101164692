package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void lockInPoints() {
        Player p1 = new Player("p1");
        p1.roundStarting();

        // test rigging hand
        Game.Dice[] hand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        p1.lockInPoints(hand,Game.FortuneCard.TREASURECHEST);
        assertEquals(5300, p1.getScore());

        // test rigging card
        hand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT};
        p1.lockInPoints(hand, Game.FortuneCard.DIAMOND);
        assertEquals(100, p1.getScore());

        //test pulling from saveDice
        p1.setSavedDice(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.setSavedDicePos(new int[]{0, 1, 2});
        p1.setPlayerRoll(new Game.Dice[]{null, null, null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND,Game.Dice.DIAMOND});
        p1.lockInPoints(p1.getPlayerRoll(), Game.FortuneCard.TREASURECHEST);
        assertEquals(5300, p1.getScore());

        //test to check if player died
        p1.setSavedDicePos(null);
        p1.setSavedDice(new Game.Dice[]{});
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.lockInPoints(p1.getPlayerRoll(), Game.FortuneCard.TREASURECHEST);
        assertEquals(0, p1.getScore());


    }

    @Test
    void playerReroll() {
        Player p1 = new Player("p1");
        p1.roundStarting();
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.PARROT, Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT});

        Game.Dice[] hand = {Game.Dice.DIAMOND, null,null,null,null,null,null,null,};
        p1.playerReroll(new int[]{1,2,3,4,5,6,7},hand);
        Game.Dice[] expectedArr = {Game.Dice.DIAMOND, Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT};
        assertArrayEquals(expectedArr,p1.getPlayerRoll());
    }

    @Test
    void roundStarting() {
        Player p1 = new Player("p1");
        p1.roundStarting();

        //initialize player roll
        assertTrue(p1.getPlayerRoll() != null);
        //initialize fortune card
        assertTrue(p1.getFc() != null);


    }

    @Test
    void rerollSkull() {
        Player p1 = new Player("p1");
        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});

        //reroll to rig dice
        p1.rerollSkull(Game.Dice.MONKEY);
        assertEquals(p1.getPlayerRoll()[3],Game.Dice.MONKEY);

    }

    @Test
    void addDiceToTC() {
        Player p1 = new Player("p1");
        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});

        p1.saveDice(new int[]{0,1,2});
        //save dice index
        assertArrayEquals(new int[]{0,1,2},p1.getSavedDicePos());
        //save dice
        assertArrayEquals(new Game.Dice[]{Game.Dice.DIAMOND,Game.Dice.PARROT,Game.Dice.PARROT},p1.getSavedDice());
    }

    @Test
    void removeFromChest() {
        Player p1 = new Player("p1");
        p1.setFc(Game.FortuneCard.SORCERESS);
        Game.Dice[] playerRoll = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        p1.setPlayerRoll(playerRoll);
        p1.setSavedDicePos(new int[]{0,1,2});
        p1.setSavedDice(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT});
        
        //save dice index
        p1.removeFromChest();
        assertTrue(p1.getSavedDicePos() == null);
        assertTrue(p1.getSavedDice() == null);
        assertArrayEquals(playerRoll,p1.getPlayerRoll());
    }
}