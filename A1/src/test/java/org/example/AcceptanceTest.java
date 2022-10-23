package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    void row45() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");
        p1.roundStarting();

        p1.setPlayerRoll(riggedhand);
        p1.setFc(riggedCard);

        assertEquals(-1, p1.promptUI(null));
    }

    @Test
    void row46() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 2 skulls 1 sword  die
        Player p1 = new Player("p1");
        p1.roundStarting();

        p1.setPlayerRoll(riggedhand);
        p1.setFc(riggedCard);

        p1.promptUI("1");
        p1.doOption(1,riggedReroll,null, p1.validateRerollInput("1,2,3,4"));

        assertEquals(-1, p1.promptUI(null));

    }

    @Test
    void row47() {

        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 2 skulls, 4 parrots, 2 swords, reroll swords, get 1 skull 1 sword  die

        Player p1 = new Player("p1");
        p1.roundStarting();

        p1.setPlayerRoll(riggedhand);
        p1.setFc(riggedCard);

        p1.promptUI("1");
        p1.doOption(1,riggedReroll,null, p1.validateRerollInput("2,3,4,5"));

        assertEquals(-1, p1.promptUI(null));


    }

    @Test
    void row48() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 1 skull, 4 parrots, 3 swords, reroll swords, get 1 skull 2 monkeys
        //      reroll 2 monkeys, get 1 skull 1 monkey and die


        Player p1 = new Player("p1");
        p1.roundStarting();

        p1.setPlayerRoll(riggedhand);
        p1.setFc(riggedCard);

        p1.promptUI("1");
        p1.doOption(1,firstReroll,null, p1.validateRerollInput("1,2,3,4"));

        p1.promptUI("1");
        p1.doOption(1,secondReroll,null, p1.validateRerollInput("1,2,3,4"));

        assertEquals(-1, p1.promptUI(null));


    }

    @Test
    void row50() {
        //roll 1 skull, 2 parrots, 3 swords, 2 coins, reroll parrots get 2 coins
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        int[] userInput = {0, 3, 4, 5, 6, 7};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(), userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(), p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null, Game.Dice.GOLD, Game.Dice.GOLD, null, null, null, null, null};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(), p1.getSavedDicePos(), p1.getSavedDice()));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));
        //{Game.Dice.SKULL,Game.Dice.GOLD,Game.Dice.GOLD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.GOLD,Game.Dice.GOLD}
        //reroll 3 swords, get 3 coins (SC 4000 for seq of 8 (with FC coin) + 8x100=800 = 4800)

        userInput = new int[]{0, 1, 2, 6, 7};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(), userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(), p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null, null, null, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, null, null, null};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(), p1.getSavedDicePos(), p1.getSavedDice()));


        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(4800, p1.getScore());

    }

    @Test
    void row52() {
        //score first roll with 2 (monkeys/parrot/diamonds/coins) and FC is captain (SC 800)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.GOLD, Game.Dice.GOLD};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.CAPTAIN));

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(800, p1.getScore());

    }

    @Test
    void row53() {
        //roll 2 (monkeys/skulls/swords/parrots), reroll parrots and get 1 sword & 1 monkey (SC 300 since FC is coin)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));

        p1.checkDead();

        //reroll parrots and get 1 sword & 1 monkey (SC 300 since FC is coin)

        int[] userInput = new int[]{0, 1, 2, 3, 4, 5};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(), userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(), p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null, null, null, null, null, null, null, Game.Dice.SWORD, Game.Dice.MONKEY};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(), p1.getSavedDicePos(), p1.getSavedDice()));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(300, p1.getScore());

    }

    @Test
    void row54(){
        //roll 3 (monkey, swords) + 2 skulls and score   (SC 300)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(300, p1.getScore());

    }

    @Test
    void row55(){
        //roll 3 diamonds, 2 skulls, 1 monkey, 1 sword, 1 parrot, score (diamonds = 100 + 300 points)   (SC 500)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.PARROT};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(500, p1.getScore());

    }

    @Test
    void row56(){
        //roll 4 coins, 2 skulls, 2 swords and score (coins: 200 + 400 points) with FC is a diamond (SC 700)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.DIAMOND));

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(700, p1.getScore());

    }


    @Test
    void row57(){
        //roll 3 swords, 4 parrots, 1 skull and score (SC 100+200+100= 400)
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(400, p1.getScore());

    }
    @Test
    void row58() {
        //roll 1 skull, 2 coins/parrots & 3 swords,
        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand, riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        p1.checkDead();


        //reroll parrots, get 1 coin and 1 sword, score (SC = 200+400+200 = 800)

        int[] userInput = new int[]{0, 1, 2, 5, 6, 7};
        p1.setSavedDicePos(userInput);
        p1.setSavedDice(game.getSavedDice(p1.getPlayerRoll(), userInput));

        p1.setPlayerRoll(game.changeDiceToNull(p1.getPlayerRoll(), p1.getSavedDicePos()));
        riggedhand = new Game.Dice[]{null, null, null, Game.Dice.GOLD, Game.Dice.SWORD, null, null, null};

        p1.setPlayerRoll(game.rollDice(p1.getPlayerRoll(), riggedhand));
        p1.setPlayerRoll(game.changeNullToDice(p1.getPlayerRoll(), p1.getSavedDicePos(), p1.getSavedDice()));

        p1.checkDead();
        p1.setScore(game.scorePoints(p1.getPlayerRoll(), p1.getFc()));

        assertEquals(800, p1.getScore());

    }
}