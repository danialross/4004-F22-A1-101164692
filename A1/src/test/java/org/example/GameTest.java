package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void scorePointsTest(){
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
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY};
        assertEquals(4800, game.scorePoints(hand,Game.FortuneCard.GOLD));

        //diamond fortune card
        //fortune card as face value
        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(100, game.scorePoints(hand,Game.FortuneCard.DIAMOND));
        //fortune card as a set and face value
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(400, game.scorePoints(hand,Game.FortuneCard.DIAMOND));
        //test if it triggers full chest bonus
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.MONKEY};
        assertEquals(4800, game.scorePoints(hand,Game.FortuneCard.DIAMOND));

        //Captain fortune card
        hand = new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(0, game.scorePoints(hand,Game.FortuneCard.CAPTAIN));
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY};
        assertEquals(1200, game.scorePoints(hand,Game.FortuneCard.CAPTAIN));
        hand = new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        assertEquals(10600, game.scorePoints(hand,Game.FortuneCard.CAPTAIN));


        //monkeybusiness fortuneCard
        hand = new Game.Dice[]{Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        assertEquals(200, game.scorePoints(hand,Game.FortuneCard.MONKEYBUSINESS));
        hand = new Game.Dice[]{Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        assertEquals(4500, game.scorePoints(hand,Game.FortuneCard.MONKEYBUSINESS));

    }

    @Test
    void rollDiceTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(hand,game.rollDice(new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD},hand));
        hand = new Game.Dice[]{null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.Dice[] emptyArr = {};
        assertEquals(null,(game.rollDice(hand,emptyArr)[0]));
    }

    @Test
    void sorceressReroleTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND},game.sorceressRerole(hand,Game.Dice.PARROT));
        hand = new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(Game.Dice.DIAMOND,game.sorceressRerole(hand,null)[1]);
    }

    @Test
    void pickCardTest() {
        Game game = new Game();
        assertEquals(Game.FortuneCard.CAPTAIN,Game.pickCard(Game.FortuneCard.CAPTAIN));

    }

    @Test
    void isContainSkullTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(true,game.isContainSkull(hand));
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(false,game.isContainSkull(hand));

    }


    @Test
    void getSavedDiceForTCTest() {
        Game game = new Game();

        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        int[] positions = {0};
        Game.Dice[] actualArr = game.getSavedDiceForTC(hand,positions);
        Game.Dice[] expectedArr = {actualArr[0]};
        assertArrayEquals(expectedArr,actualArr);

        positions = new int[] {0,1,2,3,4,5};
        actualArr = game.getSavedDiceForTC(hand,positions);
        expectedArr = new Game.Dice[]{actualArr[0], actualArr[1], actualArr[2], actualArr[3], actualArr[4], actualArr[5]};
        assertArrayEquals(expectedArr,actualArr);

    }

    @Test
    void changeSkullToNullTest() {
        Game game = new Game();
        int[] empty = {};

        Game.Dice[] hand = {Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.Dice[] actualArr = game.changeToNull(hand,empty);
        Game.Dice[] expectedArr = {null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);

        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        actualArr = game.changeToNull(hand,empty);
        expectedArr = new Game.Dice[]{null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArr,actualArr);

        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        int[] positions = {0};
        actualArr = game.changeToNull(hand,positions);
        expectedArr = new Game.Dice[]{null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);

        positions = new int[] {0,1,2,3,4,5};
        actualArr = game.changeToNull(hand,positions);
        expectedArr = new Game.Dice[]{null, null, null, null, null, null, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);
    }
    
}