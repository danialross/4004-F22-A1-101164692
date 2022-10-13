package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void scorePointTest(){
        Game game = new Game();
        Game.Dice[] hand = {Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        // three of a kind
        assertEquals(200, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        // four of a kind
        assertEquals(300, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        // five of a kind
        assertEquals(600, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.SKULL};
        // six of a kind
        assertEquals(1000, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        // seven of a kind
        assertEquals(2000, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        // eight of a kind and fullChest bonus
        assertEquals(4500, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        // 1 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(100, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 2 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(200, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 3 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(400, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 4 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(600, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 5 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(1000, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 6 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(1600, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 7 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.MONKEY};
        assertEquals(2700, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 8 diamond
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(5300, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        // 1 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(100, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 2 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(200, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 3 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(400, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 4 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(600, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 5 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(1000, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 6 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.MONKEY};
        assertEquals(1600, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 7 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY};
        assertEquals(2700, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));
        // 8 gold
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        assertEquals(5300, game.scorePoints(hand,Game.FortuneCard.TREASURECHEST));

        //gold fortune card
        //fortune card as face value
        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(100, game.scorePoints(hand,Game.FortuneCard.GOLD));
        //fortune card as a set and face value
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(400, game.scorePoints(hand,Game.FortuneCard.GOLD));





    }
}