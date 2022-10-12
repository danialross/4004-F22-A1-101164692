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

        Game.Dice[] h3 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.SKULL};
        // five of a kind
        assertEquals(500, game.scorePoints(h3,Game.FortuneCard.TREASURECHEST));

        Game.Dice[] h4 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        // six of a kind
        assertEquals(1000, game.scorePoints(h4,Game.FortuneCard.TREASURECHEST));

        Game.Dice[] h5 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL};
        // seven of a kind
        assertEquals(2000, game.scorePoints(h5,Game.FortuneCard.TREASURECHEST));

        Game.Dice[] h6 = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        // eight of a kind
        assertEquals(4000, game.scorePoints(h6,Game.FortuneCard.TREASURECHEST));

    }
}