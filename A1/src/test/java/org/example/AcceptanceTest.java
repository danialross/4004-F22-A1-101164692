package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    void row45() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);
        p1.roundStarting(riggedhand,riggedCard);
        assertEquals(-1, p1.promptUI(null));
    }

    @Test
    void row46() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 2 skulls 1 sword  die

        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);
        p1.doOption(p1.promptUI("1"),riggedReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        assertEquals(-1, p1.promptUI(null));

    }

    @Test
    void row47() {

        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 2 skulls, 4 parrots, 2 swords, reroll swords, get 1 skull 1 sword  die

        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),riggedReroll,null, p1.validateRerollInput("2,3,4,5"),null);

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
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        assertEquals(-1, p1.promptUI(null));


    }

    @Test
    void row50() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 1 skull, 2 parrots, 3 swords, 2 coins, reroll parrots get 2 coins
        Player p1 = new Player("p1");
        Game game = p1.game;
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("3,4,5,6,7"),null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("1,2,6,7"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(4800, p1.getScore());

    }

    @Test
    void row52() {
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggedCard =  Game.FortuneCard.CAPTAIN;
        //score first roll with 2 (monkeys/parrot/diamonds/coins) and FC is captain (SC 800)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(800, p1.getScore());
    }

    @Test
    void row53() {
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 2 (monkeys/skulls/swords/parrots), reroll parrots and get 1 sword & 1 monkey (SC 300 since FC is coin)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,4,5"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, new int[]{},null);


        assertEquals(300, p1.getScore());

    }

    @Test
    void row54(){
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 3 (monkey, swords) + 2 skulls and score   (SC 300)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);


        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(300, p1.getScore());
    }

    @Test
    void row55(){
        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 3 diamonds, 2 skulls, 1 monkey, 1 sword, 1 parrot, score (diamonds = 100 + 300 points)   (SC 500)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.promptUI("3");
        p1.doOption(3,new Game.Dice[]{},null, null,null);

        assertEquals(500, p1.getScore());

    }

    @Test
    void row56(){
        Game.Dice[] riggedhand = {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;
        //roll 4 coins, 2 skulls, 2 swords and score (coins: 200 + 400 points) with FC is a diamond (SC 700)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(700, p1.getScore());

    }


    @Test
    void row57(){
        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 3 swords, 4 parrots, 1 skull and score (SC 100+200+100= 400)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(400, p1.getScore());

    }
    @Test
    void row58() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 1 skull, 2 coins/parrots & 3 swords,
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,5,6,7"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(800, p1.getScore());

    }

    @Test
    void row59(){
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;
        //roll 1 skull, 2 coins/parrots & 3 swords,
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,5,6,7"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(1200, p1.getScore());

    }

    @Test
    void row60(){
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        // roll 1 skull, 2 (monkeys/parrots) 3 swords, reroll 2 monkeys, get 1 skull 1 sword, then reroll parrots get 1 sword 1 monkey (SC 600)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("3,4,5,6,7"),null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("3,6,7"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(600,p1.getScore());
    }
    @Test
    void row62(){
        //score set of 6 monkeys and 2 skulls on first roll (SC 1100)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(1100,p1.getScore());

    }

    @Test
    void row63(){
        //score set of 7 parrots and 1 skull on first roll (SC 2100)

        Game.Dice[] riggedhand = {Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(2100,p1.getScore());

    }

    @Test
    void row64() {
        //score set of 8 coins on first roll (SC 5400)  seq of 8 + 9 coins(FC is coin) +  full chest  (no extra points for 9 coins)

        Game.Dice[] riggedhand = {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(5400,p1.getScore());

    }

    @Test
    void row65() {
        //score set of 8 coins on first roll and FC is diamond (SC 5400)

        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(5400,p1.getScore());
    }

    @Test
    void row66() {
        //score set of 8 swords on first roll and FC is captain (SC 4500x2 = 9000) since full chest

        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(9000,p1.getScore());
    }

    @Test
    void row67() {
        //roll 6 monkeys and 2 swords, reroll swords, get 2 monkeys, score (SC 4600 because of FC is coin and full chest)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2,3,4,5"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(4600,p1.getScore());

    }

    @Test
    void row68() {
        //roll 2 (monkeys/skulls/swords/parrots), reroll parrots, get 2 diamonds, score with FC is diamond (SC 400)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,4,5"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(400,p1.getScore());


    }

    @Test
    void row69() {
        //roll 2 (monkeys, skulls, swords), 1 diamond, 1 parrot, reroll 2 monkeys, get 2 diamonds, score 500
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("4,5,6,7"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(500,p1.getScore());

    }

    @Test
    void row70() {
        //roll 1 skull, 2 coins, 1 (monkey/parrot), 3 swords, reroll 3 swords, get 1 (coin/monkey/parrot)  (SC 600)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(600,p1.getScore());

    }

    @Test
    void row71() {
        //roll 1 skull, 2 coins, 1 (monkey/parrot), 3 swords, reroll swords, get 1 (coin/monkey/parrot) with FC is diamond (SC 500)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(500,p1.getScore());
    }

    @Test
    void row72() {
        //get 4 monkeys, 2 coins and 2 skulls with FC coin. Score 600

        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null);
        assertEquals(600,p1.getScore());
    }

    @Test
    void row77(){
        //roll 2 diamonds, 1 (sword/monkey/coin), 3 parrots, reroll 3 parrots, get 1 skull, 2 monkeys, reroll skull, get monkey (SC 500)
        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice skullReroll = Game.Dice.MONKEY;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2,3,4"),null);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(500,p1.getScore());
    }

    @Test
    void row78(){
        //roll 3 skulls, 3 parrots, 2 swords, reroll skull, get parrot, reroll 2 swords, get parrots, score (SC 1000)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice skullReroll = Game.Dice.PARROT;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,3,4,5"),null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(1000,p1.getScore());
    }

    @Test
    void row79(){
        //roll 1 skull, 4 parrots, 3 monkeys, reroll 3 monkeys, get 1 skull, 2 parrots, reroll skull, get parrot, score (SC 2000)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice skullReroll = Game.Dice.PARROT;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null);

        assertEquals(2000,p1.getScore());
    }
}