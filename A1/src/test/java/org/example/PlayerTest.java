package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void lockInPoints() {
        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);

        // test rigging hand
        Game.Dice[] hand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        p1.lockInPoints(hand,Game.FortuneCard.TREASURECHEST);
        assertEquals(5300, p1.getScore());

        // test rigging card
        p1.setScore(0);
        hand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT};
        p1.lockInPoints(hand, Game.FortuneCard.DIAMOND);
        assertEquals(100, p1.getScore());

        //test pulling from saveDice
        p1.setScore(0);
        p1.setSavedDice(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.setSavedDicePos(new int[]{0, 1, 2});
        p1.setPlayerRoll(new Game.Dice[]{null, null, null, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND,Game.Dice.DIAMOND});
        p1.lockInPoints(p1.getPlayerRoll(), Game.FortuneCard.TREASURECHEST);
        assertEquals(5300, p1.getScore());



    }

    @Test
    public void playerReroll() {
        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.PARROT, Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT});

        Game.Dice[] hand = {Game.Dice.DIAMOND, null,null,null,null,null,null,null,};
        p1.playerReroll(new int[]{1,2,3,4,5,6,7},hand);
        Game.Dice[] expectedArr = {Game.Dice.DIAMOND, Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT};
        assertArrayEquals(expectedArr,p1.getPlayerRoll());
    }

    @Test
    public void roundStarting() {
        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);

        //initialize player roll
        assertTrue(p1.getPlayerRoll() != null);
        //initialize fortune card
        assertTrue(p1.getFc() != null);
        //initialize players
        assertTrue(p1.getPlayers()[0] != null);
        assertTrue(p1.getPlayers()[1] != null);
        assertTrue(p1.getPlayers()[2] != null);

        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT,Game.Dice.PARROT};
        Game.FortuneCard riggCard = Game.FortuneCard.GOLD;
        p1.roundStarting(riggedhand,riggCard);
        assertEquals(riggCard,p1.getFc());
        assertArrayEquals(riggedhand,p1.getPlayerRoll());


    }
    @Test
    public void rerollSkull() {
        Player p1 = new Player("p1");
        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});

        //reroll to rig dice
        p1.rerollSkull(Game.Dice.MONKEY);
        assertEquals(p1.getPlayerRoll()[3],Game.Dice.MONKEY);

    }

    @Test
    public void saveDice() {
        Player p1 = new Player("p1");
        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});

        p1.saveDice(new int[]{0,1,2});
        //save dice index
        assertArrayEquals(new int[]{0,1,2},p1.getSavedDicePos());
        //save dice
        assertArrayEquals(new Game.Dice[]{Game.Dice.DIAMOND,Game.Dice.PARROT,Game.Dice.PARROT},p1.getSavedDice());

        //check if dice moved from hand to chest
        Game.Dice[] expectedArr = new Game.Dice[]{null, null, null, null, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        p1.getPlayerRoll();
        assertArrayEquals(expectedArr,p1.getPlayerRoll());

    }

    @Test
    public void removeFromChest() {
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

    @Test
    public void skullIslandRoll() {
        Player p1 = new Player("p1");
        Game.Dice[] roll = new Game.Dice[] {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT};

        p1.setPlayerRoll(roll);
        p1.setPlayers(new Player[]{new Player("p1"), new Player("p2"), new Player("p3")});
        p1.getPlayers()[0].setScore(100);
        p1.getPlayers()[1].setScore(100);
        p1.getPlayers()[2].setScore(100);

        Game.Dice[] hand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT};
        p1.skullRollReducer(hand);
        assertEquals(100,p1.getPlayers()[0].getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());



    }


    @Test
    public void promptUI() {
        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);

        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD});
        p1.setFc(Game.FortuneCard.GOLD);

        int result = p1.promptUI(String.valueOf(1));
        assertEquals(1,result);
        result = p1.promptUI(String.valueOf(2));
        assertEquals(2,result);
        result = p1.promptUI(String.valueOf(3));
        assertEquals(3,result);

        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.promptUI(String.valueOf(4));
        assertEquals(4,result);

        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.promptUI(String.valueOf(4));
        assertEquals(4,result);

        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, null, null, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        p1.setSavedDicePos(new int[]{1,2});
        p1.setSavedDice(new Game.Dice[]{Game.Dice.PARROT,Game.Dice.PARROT});
        result = p1.promptUI(String.valueOf(5));
        assertEquals(5,result);


        //infinitly ask user until input is correct
        result = p1.promptUI("r");
        assertEquals(-555,result);

        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.promptUI(null);
        assertEquals(-1,result);

        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.promptUI(null);
        assertEquals(-2,result);


    }

    @Test
    public void validateRerollInput() {
        Player p1 = new Player("p1");
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        int[] result = p1.validateRerollInput("0,1,2");
        assertArrayEquals(new int[]{0, 1, 2}, result);

        // wrong input
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.validateRerollInput("12.3");
        assertArrayEquals(null, result);

        // only space and comma
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.validateRerollInput(" ");
        assertArrayEquals(null, result);


        // out of range
        result = p1.validateRerollInput("9,12,22");
        assertArrayEquals(null, result);

        // if skull selected
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.validateRerollInput("0,3");
        assertArrayEquals(null, result);

        //rolling less then 2 dice without treasure chest
        p1.setPlayerRoll(new Game.Dice[]{Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.validateRerollInput("0,1,2,3,4,5,6");
        assertArrayEquals(null, result);

        result = p1.validateRerollInput("0,1,2,3,4,5");
        assertArrayEquals(new int[]{0, 1, 2,3,4,5}, result);

        // testing null(savedDice for tc)
        p1.setPlayerRoll(new Game.Dice[]{null, null, null, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT});
        result = p1.validateRerollInput("0,1,2");
        assertArrayEquals(null, result);


    }

    @Test
    public void status() {
        Player p1 = new Player("p1");
        assertEquals("Player turn started",p1.status(1));
        assertEquals("Player has died",p1.status(2));
        assertEquals("Player's score has been deducted by ",p1.status(3));
        assertEquals("Player has gone to Island Of the Dead",p1.status(4));
        assertEquals("Player turn ended",p1.status(5));
        assertEquals("Player has won!",p1.status(6));
        assertEquals("Player scored ",p1.status(7));
        assertEquals("Player is in a SeaBattle",p1.status(8));


    }

    @Test
    public void doOption() {
        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{}, null);
        p1.doOption(3,new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND}, Game.FortuneCard.MONKEYBUSINESS,null,null,null,null);
        assertEquals(5300,p1.getScore());

        p1.setScore(0);
        p1.doOption(3,new Game.Dice[] {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND}, Game.FortuneCard.SEABATTLEX2SWORDS,null,null,null,null);
        assertEquals(2400,p1.getScore());

        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.doOption(2,new Game.Dice[] {},null,null,null,null,null);
        assertFalse(Arrays.equals(new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND},p1.getPlayerRoll()));

        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.doOption(1,new Game.Dice[] {},null,new int[]{0,1,2},null,null,null);
        assertFalse(Arrays.equals(new Game.Dice[] {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND},p1.getPlayerRoll()));

        p1.setFc(Game.FortuneCard.SORCERESS);
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.doOption(4,new Game.Dice[] {},null,null,null,null,null);
        assertTrue(p1.getFc() == null);

        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        p1.setScore(500);
        p2.setScore(500);
        p3.setScore(500);
        p1.setPlayers(new Player[]{p1,p2,p3});
        Game.Dice[] rigHand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        p1.setPlayerRoll(rigHand);
        Game.Dice[] skullRig = new Game.Dice[] {Game.Dice.SKULL,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.doOption(-2,rigHand,null,null,null,"2",new Game.Dice[][]{skullRig});
        assertEquals(500,p1.getPlayers()[0].getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());

        p2 = new Player("p2");
        p3 = new Player("p3");
        p1.setScore(500);
        p2.setScore(500);
        p3.setScore(500);
        p1.setPlayers(new Player[]{p1,p2,p3});
        rigHand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        p1.setPlayerRoll(rigHand);
        skullRig = new Game.Dice[] {Game.Dice.SKULL,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.doOption(-2,rigHand,null, new int[]{0,1}, null,"1",new Game.Dice[][]{skullRig});
        assertEquals(500,p1.getPlayers()[0].getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());

        p2 = new Player("p2");
        p3 = new Player("p3");
        p1.setScore(400);
        p2.setScore(400);
        p3.setScore(400);
        p1.setPlayers(new Player[]{p1,p2,p3});
        rigHand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        p1.setPlayerRoll(rigHand);
        skullRig = new Game.Dice[] {Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.doOption(-2,rigHand,null, new int[]{2,3}, null,"3",new Game.Dice[][]{skullRig});
        assertEquals(400,p1.getPlayers()[0].getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());


        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.setSavedDicePos(new int[] {4,5});
        p1.setSavedDice(new Game.Dice[]{Game.Dice.GOLD,Game.Dice.PARROT});
        p1.setPlayerRoll(new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, null, null, Game.Dice.DIAMOND, Game.Dice.DIAMOND});
        p1.doOption(5,new Game.Dice[] {},null,null,null,null,null);
        assertEquals(null,p1.getSavedDicePos());
        assertArrayEquals(new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND}, p1.getPlayerRoll());

        p2 = new Player("p2");
        p3 = new Player("p3");
        p1.setScore(500);
        p2.setScore(500);
        p3.setScore(500);
        p1.setPlayers(new Player[]{p1,p2,p3});
        rigHand = new Game.Dice[] {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND};
        p1.setPlayerRoll(rigHand);
        p1.setFc(Game.FortuneCard.TREASURECHEST);
        p1.doOption(-2,rigHand,null, new int[]{0,1}, null,"3",null);
        assertEquals(500,p1.getPlayers()[0].getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());
    }

    @Test
    public void checkWinner() {
        Player p1 = new Player("p1");
        p1.setScore(2000);
        Player p2 = new Player("p2");
        p2.setScore(6000);
        Player p3 = new Player("p3");
        p3.setScore(3000);

        p1.setPlayers(new Player[]{p1,p2,p3});
        p2.setPlayers(new Player[]{p1,p2,p3});
        p3.setPlayers(new Player[]{p1,p2,p3});

        assertEquals(p2,p1.checkWinner());
        assertEquals(p2,p2.checkWinner());
        assertEquals(p2,p3.checkWinner());

        p1.setScore(2000);
        p2.setScore(2999);
        p3.setScore(1000);

        assertEquals(null,p1.checkWinner());
        assertEquals(null,p2.checkWinner());
        assertEquals(null,p3.checkWinner());

    }

    @Test
    public void handWithoutSkull(){
        Player p1 =  new Player("p1");

        p1.roundStarting(new Game.Dice[] {Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL},null);
        assertEquals(0,p1.handWithoutSkull().length);

        p1.roundStarting(new Game.Dice[] {Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND},null);
        assertEquals(4,p1.handWithoutSkull().length);

    }
}