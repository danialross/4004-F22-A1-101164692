package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void scorePointTest(){
        Game game = new Game();
        Game.Dice[] h1 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.SKULL};
        // three of a kind
        assertEquals(100, game.scorePoints(h1,Game.FortuneCard.TREASURECHEST));

        Game.Dice[] h2 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.SKULL};
        // four of a kind
        assertEquals(200, game.scorePoints(h2,Game.FortuneCard.TREASURECHEST));

    }
}