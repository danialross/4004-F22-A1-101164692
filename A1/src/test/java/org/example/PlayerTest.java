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
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.lockInPoints(p1.getPlayerRoll(), Game.FortuneCard.TREASURECHEST);
        assertEquals(0, p1.getScore());


    }
}