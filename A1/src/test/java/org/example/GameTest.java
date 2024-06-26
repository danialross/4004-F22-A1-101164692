package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

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
    public void rollDiceTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(hand,game.rollDice(new Game.Dice[]{Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD},hand));
        hand = new Game.Dice[]{null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.Dice[] emptyArr = {};
        assertEquals(null,(game.rollDice(hand,emptyArr)[0]));
    }

    @Test
    public void sorceressReroleTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND},game.sorceressReroll(hand,Game.Dice.PARROT));
        hand = new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(Game.Dice.DIAMOND,game.sorceressReroll(hand,null)[1]);
    }

    @Test
    public void pickCardTest() {
        Game game = new Game();
        assertEquals(Game.FortuneCard.CAPTAIN,Game.pickCard(Game.FortuneCard.CAPTAIN));

    }

    @Test
    public void isContainSkullTest() {
        Game game = new Game();
        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(true,game.isContainSkull(hand));
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(false,game.isContainSkull(hand));

    }


    @Test
    public void getSavedDiceForTCTest() {
        Game game = new Game();

        Game.Dice[] hand ={Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        int[] positions = {0};
        Game.Dice[] actualArr = game.getSavedDice(hand,positions);
        Game.Dice[] expectedArr = {actualArr[0]};
        assertArrayEquals(expectedArr,actualArr);

        positions = new int[] {0,1,2,3,4,5};
        actualArr = game.getSavedDice(hand,positions);
        expectedArr = new Game.Dice[]{actualArr[0], actualArr[1], actualArr[2], actualArr[3], actualArr[4], actualArr[5]};
        assertArrayEquals(expectedArr,actualArr);

    }

    @Test
    public void changeDiceToNullTest() {
        Game game = new Game();
        int[] empty = {};

        Game.Dice[] hand = {Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.Dice[] actualArr = game.changeDiceToNull(hand,empty);
        Game.Dice[] expectedArr = {null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);

        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        actualArr = game.changeDiceToNull(hand,empty);
        expectedArr = new Game.Dice[]{null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArr,actualArr);

        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        int[] positions = {0};
        actualArr = game.changeDiceToNull(hand,positions);
        expectedArr = new Game.Dice[]{null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);

        positions = new int[] {0,1,2,3,4,5};
        actualArr = game.changeDiceToNull(hand,positions);
        expectedArr = new Game.Dice[]{null, null, null, null, null, null, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertArrayEquals(expectedArr,actualArr);
    }

    @Test
    public void changeNullToDiceTest() {
        Game game = new Game();

        Game.Dice[] playerHand = {null,null,null,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD};
        int[] pos = {0,1,2};
        Game.Dice[] savedDice = {Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.PARROT};
        Game.Dice[] expectedArr = {Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.PARROT,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD};
        assertArrayEquals(expectedArr,game.changeNullToDice(playerHand,pos,savedDice));

        playerHand = new Game.Dice[]{null, null, null, null, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        pos = new int[]{0, 1, 2};
        savedDice = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.PARROT};
        expectedArr = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.SKULL,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.GOLD};
        assertArrayEquals(expectedArr,game.changeNullToDice(playerHand,pos,savedDice));
    }

    @Test
    public void isDeadTest() {
        Game game = new Game();

        //-1: dead, 0: island of dead, 1: alive
        //not in seabattle
        Game.FortuneCard card = Game.FortuneCard.GOLD;
        Game.Dice[] hand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(0,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(1,game.didDie(hand,card));


        //in seabattle
        card = Game.FortuneCard.SEABATTLEX2SWORDS;
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-1,game.didDie(hand,card));

        //skullx1
        card = Game.FortuneCard.SKULLX1;
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(0,game.didDie(hand,card));

        //skullx2
        card = Game.FortuneCard.SKULLX2;
        hand = new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-1,game.didDie(hand,card));
        hand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(0,game.didDie(hand,card));


    }

    @Test
    public void getWinner() {
        Game game = new Game();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        p1.setScore(7000);
        p2.setScore(3000);
        p3.setScore(4000);

        assertEquals(p1,game.getWinner(new Player[]{p1, p2, p3}));
        assertEquals(p1,game.getWinner(new Player[]{p2, p1, p3}));
        assertEquals(p1,game.getWinner(new Player[]{p3, p2, p1}));

        p1.setScore(7000);
        p2.setScore(7000);
        p3.setScore(4000);
        assertEquals(p2,game.getWinner(new Player[]{p3, p1, p2}));
        assertEquals(p2,game.getWinner(new Player[]{p1, p2, p3}));
        assertEquals(p2,game.getWinner(new Player[]{p1, p3, p2}));
    }

    @Test
    public void didReachWinThreshold() {
        Game game = new Game();

        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        p1.setScore(2999);
        p2.setScore(1000);
        p3.setScore(1500);
        assertEquals(false,game.didReachWinThreshold(new Player[]{p3, p1, p2}));

        p1.setScore(6000);
        p2.setScore(3000);
        p3.setScore(4000);
        assertEquals(true,game.didReachWinThreshold(new Player[]{p3, p1, p2}));



    }

    @Test
    public void getScoreDeductionTest() {
        Game game = new Game();
        // no deduction
        assertEquals(0,game.getScoreDeduction(0, Game.FortuneCard.DIAMOND));
        assertEquals(0,game.getScoreDeduction(0, Game.FortuneCard.CAPTAIN));

        // normal range
        assertEquals(-500,game.getScoreDeduction(5, Game.FortuneCard.DIAMOND));
        assertEquals(-1000,game.getScoreDeduction(5, Game.FortuneCard.CAPTAIN));

        assertEquals(-700,game.getScoreDeduction(5, Game.FortuneCard.SKULLX2));
        assertEquals(-600,game.getScoreDeduction(5, Game.FortuneCard.SKULLX1));


    }

    @Test
    public void reducePlayersScoreTest() {
        Game game = new Game();

        int playerScore = 1200;
        int expectedScore = 200;
        assertEquals(expectedScore,game.reducePlayerScore(-1000, playerScore));

        playerScore =  500;
        expectedScore =  0;
        assertEquals(expectedScore,game.reducePlayerScore(-1000, playerScore));

    }

    @Test
    public void didWinSeaBattleTest() {
        Game game = new Game();

        //2sword
        // didnt win
        Game.Dice[] playerHand = {Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        // died
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        //won
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));


        //3sword
        // didnt win
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        // died
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        //won
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));

        //4sword
        // didnt win
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        // died
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertFalse(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        //won
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertTrue(game.didWinSeaBattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
    }

    @Test
    public void scoreSeabattleTest() {
        Game game = new Game();
        //300
        //win
        Game.Dice[] playerHand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL};
        assertEquals(600,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));

        //lose(not enough sword)
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        assertEquals(-300,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        //lose(die)
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD};
        assertEquals(-300,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.GOLD};
        assertEquals(-300,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX2SWORDS));

        //500
        //win
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.DIAMOND};
        assertEquals(1400,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        //lose(not enough sword)
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        assertEquals(-500,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        //lose(die)
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD};
        assertEquals(-500,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.GOLD};
        assertEquals(-500,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX3SWORDS));

        //1000
        //win
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.DIAMOND};
        assertEquals(1900,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        //lose(not enough sword)
        playerHand = new Game.Dice[]{Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND};
        assertEquals(-1000,game.scoreSeabattle(playerHand,Game.FortuneCard.SEABATTLEX4SWORDS));
        //lose(die)
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD};
        assertEquals(-1000,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));
        playerHand = new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.GOLD};
        assertEquals(-1000,game.scoreSeabattle(playerHand, Game.FortuneCard.SEABATTLEX4SWORDS));

    }
}