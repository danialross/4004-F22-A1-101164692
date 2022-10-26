package org.example;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AcceptanceTest {

    @Test
    public void row45() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");
        p1.roundStarting(new Game.Dice[]{},null);
        p1.roundStarting(riggedhand,riggedCard);
        assertEquals(-1, p1.promptUI(null));
    }

    @Test
    public void row46() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 2 skulls 1 sword  die

        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);
        p1.doOption(p1.promptUI("1"),riggedReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        assertEquals(-1, p1.promptUI(null));

    }

    @Test
    public void row47() {

        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 2 skulls, 4 parrots, 2 swords, reroll swords, get 1 skull 1 sword  die

        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),riggedReroll,null, p1.validateRerollInput("2,3,4,5"),null,null,null);

        assertEquals(-1, p1.promptUI(null));


    }

    @Test
    public void row48() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY};
        Game.FortuneCard riggedCard = Game.FortuneCard.GOLD;
        //roll 1 skull, 4 parrots, 3 swords, reroll swords, get 1 skull 2 monkeys
        //      reroll 2 monkeys, get 1 skull 1 monkey and die


        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        assertEquals(-1, p1.promptUI(null));


    }

    @Test
    public void row50() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 1 skull, 2 parrots, 3 swords, 2 coins, reroll parrots get 2 coins
        Player p1 = new Player("p1");
        Game game = p1.game;
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("3,4,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("1,2,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(4800, p1.getScore());

    }

    @Test
    public void row52() {
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggedCard =  Game.FortuneCard.CAPTAIN;
        //score first roll with 2 (monkeys/parrot/diamonds/coins) and FC is captain (SC 800)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(800, p1.getScore());
    }

    @Test
    public void row53() {
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 2 (monkeys/skulls/swords/parrots), reroll parrots and get 1 sword & 1 monkey (SC 300 since FC is coin)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,4,5"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, new int[]{},null,null,null);


        assertEquals(300, p1.getScore());

    }

    @Test
    public void row54(){
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggedCard =  Game.FortuneCard.GOLD;
        //roll 3 (monkey, swords) + 2 skulls and score   (SC 300)
        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggedCard);


        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(300, p1.getScore());
    }

    @Test
    public void row55(){
        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 3 diamonds, 2 skulls, 1 monkey, 1 sword, 1 parrot, score (diamonds = 100 + 300 points)   (SC 500)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.promptUI("3");
        p1.doOption(3,new Game.Dice[]{},null, null,null,null,null);

        assertEquals(500, p1.getScore());

    }

    @Test
    public void row56(){
        Game.Dice[] riggedhand = {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;
        //roll 4 coins, 2 skulls, 2 swords and score (coins: 200 + 400 points) with FC is a diamond (SC 700)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(700, p1.getScore());

    }


    @Test
    public void row57(){
        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 3 swords, 4 parrots, 1 skull and score (SC 100+200+100= 400)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(400, p1.getScore());

    }
    @Test
    public void row58() {
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        //roll 1 skull, 2 coins/parrots & 3 swords,
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(800, p1.getScore());

    }

    @Test
    public void row59(){
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;
        //roll 1 skull, 2 coins/parrots & 3 swords,
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(1200, p1.getScore());

    }

    @Test
    public void row60(){
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;
        // roll 1 skull, 2 (monkeys/parrots) 3 swords, reroll 2 monkeys, get 1 skull 1 sword, then reroll parrots get 1 sword 1 monkey (SC 600)
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("3,4,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("3,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(600,p1.getScore());
    }
    @Test
    public void row62(){
        //score set of 6 monkeys and 2 skulls on first roll (SC 1100)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1100,p1.getScore());

    }

    @Test
    public void row63(){
        //score set of 7 parrots and 1 skull on first roll (SC 2100)

        Game.Dice[] riggedhand = {Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(2100,p1.getScore());

    }

    @Test
    public void row64() {
        //score set of 8 coins on first roll (SC 5400)  seq of 8 + 9 coins(FC is coin) +  full chest  (no extra points for 9 coins)

        Game.Dice[] riggedhand = {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(5400,p1.getScore());

    }

    @Test
    public void row65() {
        //score set of 8 coins on first roll and FC is diamond (SC 5400)

        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(5400,p1.getScore());
    }

    @Test
    public void row66() {
        //score set of 8 swords on first roll and FC is captain (SC 4500x2 = 9000) since full chest

        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(9000,p1.getScore());
    }

    @Test
    public void row67() {
        //roll 6 monkeys and 2 swords, reroll swords, get 2 monkeys, score (SC 4600 because of FC is coin and full chest)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2,3,4,5"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(4600,p1.getScore());

    }

    @Test
    public void row68() {
        //roll 2 (monkeys/skulls/swords/parrots), reroll parrots, get 2 diamonds, score with FC is diamond (SC 400)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,4,5"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(400,p1.getScore());


    }

    @Test
    public void row69() {
        //roll 2 (monkeys, skulls, swords), 1 diamond, 1 parrot, reroll 2 monkeys, get 2 diamonds, score 500
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("4,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(500,p1.getScore());

    }

    @Test
    public void row70() {
        //roll 1 skull, 2 coins, 1 (monkey/parrot), 3 swords, reroll 3 swords, get 1 (coin/monkey/parrot)  (SC 600)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(600,p1.getScore());

    }

    @Test
    public void row71() {
        //roll 1 skull, 2 coins, 1 (monkey/parrot), 3 swords, reroll swords, get 1 (coin/monkey/parrot) with FC is diamond (SC 500)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.MONKEY, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.DIAMOND;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(500,p1.getScore());
    }

    @Test
    public void row72() {
        //get 4 monkeys, 2 coins and 2 skulls with FC coin. Score 600

        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(600,p1.getScore());
    }

    @Test
    public void row77(){
        //roll 2 diamonds, 1 (sword/monkey/coin), 3 parrots, reroll 3 parrots, get 1 skull, 2 monkeys, reroll skull, get monkey (SC 500)
        Game.Dice[] riggedhand = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.GOLD, Game.Dice.SKULL, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice skullReroll = Game.Dice.MONKEY;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(500,p1.getScore());
    }

    @Test
    public void row78(){
        //roll 3 skulls, 3 parrots, 2 swords, reroll skull, get parrot, reroll 2 swords, get parrots, score (SC 1000)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] firstReroll = {Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice skullReroll = Game.Dice.PARROT;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll,null,null);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,3,4,5"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(1000,p1.getScore());
    }

    @Test
    public void row79(){
        //roll 1 skull, 4 parrots, 3 monkeys, reroll 3 monkeys, get 1 skull, 2 parrots, reroll skull, get parrot, score (SC 2000)
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice skullReroll = Game.Dice.PARROT;
        Game.FortuneCard riggCard =  Game.FortuneCard.SORCERESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null,null,skullReroll,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(2000,p1.getScore());
    }

    @Test
    public void row82(){
        //roll 3 monkeys 3 parrots  1 skull 1 coin  SC = 1100  (i.e., sequence of of 6 + coin)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.MONKEYBUSINESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1100,p1.getScore());
    }

    @Test
    public void row83(){
        //roll 2 (monkeys/swords/parrots/coins), reroll 2 swords, get 1 monkey, 1 parrot, score 1700
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.MONKEYBUSINESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,4,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(1700,p1.getScore());
    }

    @Test
    public void row84(){
        //roll 3 skulls, 3 monkeys, 2 parrots => die scoring 0
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.MONKEYBUSINESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(0,p1.getScore());

    }

    @Test
    public void row87(){
        //roll 3 parrots, 2 swords, 2 diamonds, 1 coin     put 2 diamonds and 1 coin in chest
        //  then reroll 2 swords and get 2 parrots put 5 parrots in chest and take out 2 diamonds & coin
        //  then reroll the 3 dice and get 1 skull, 1 coin and a parrot
        //   score 6 parrots + 1 coin for 1100 points

        Game.Dice[] riggedhand = {Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, null, null, null};
        Game.Dice[] secondReroll = {null,null,null,null,null, Game.Dice.SKULL, Game.Dice.GOLD, Game.Dice.PARROT};

        Game.FortuneCard riggCard =  Game.FortuneCard.TREASURECHEST;

        Player p1 = new Player("p1");
//
//        p1.roundStarting(riggedhand,riggCard);
//
//        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null, p1.validateRerollInput("5,6,7"),null,null,null);
//        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2"),null,null,null);
//        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null, p1.validateRerollInput("0,1,2,3,4"),null,null,null);
//        p1.doOption(p1.promptUI("5"),new Game.Dice[]{},null, p1.validateRerollInput("5,6,7"),null,null,null);
//        p1.doOption(p1.promptUI("2"),secondReroll,null, p1.validateRerollInput(""),null,null,null);
//        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);
        assertEquals(1100,p1.getScore());

    }

    @Test
    public void row93(){
        //roll 2 skulls, 3 parrots, 3 coins   put 3 coins in chest
        //  then rerolls 3 parrots and get 2 diamonds 1 coin    put coin in chest (now 4)
        //   then reroll 2 diamonds and get 1 skull 1 coin     score for chest only = 400 + 200 = 600 AND report death

        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.GOLD, null, null, null};
        Game.Dice[] secondReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD, null, null, null, null};

        Game.FortuneCard riggCard =  Game.FortuneCard.TREASURECHEST;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);
//
//        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null, p1.validateRerollInput("5,6,7"),null,null,null);
//        p1.doOption(p1.promptUI("2"),firstReroll,null, p1.validateRerollInput(""),null,null,null);
//        p1.doOption(p1.promptUI("4"),new Game.Dice[]{},null, p1.validateRerollInput("4"),null,null,null);
//        p1.doOption(p1.promptUI("2"),new Game.Dice[]{},null, p1.validateRerollInput(""),null,null,null);
//        p1.doOption(p1.promptUI(""),secondReroll,null, p1.validateRerollInput(""),null,null,null);
        assertEquals(600,p1.getScore());
    }


    @Test
    public void row97(){
        //3 monkeys, 3 swords, 1 diamond, 1 parrot FC: coin   => SC 400  (ie no bonus)
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(400,p1.getScore());
    }

    @Test
    public void row98(){
        //3 monkeys, 3 swords, 2 coins FC: captain   => SC (100+100+200+500)*2 =  1800
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1800,p1.getScore());

    }


    @Test
    public void row99(){
        //3 monkeys, 4 swords, 1 diamond, FC: coin   => SC 1000  (ie 100++200+100+100+bonus)

        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.GOLD;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1000,p1.getScore());
    }

    @Test
    public void row100(){
        //FC: 2 sword sea battle, first  roll:  4 monkeys, 1 sword, 2 parrots and a coin
        //     then reroll 2 parrots and get 2nd coin and 2nd sword
        //     score is: 200 (coins) + 200 (monkeys) + 300 (swords of battle) + 500 (full chest) = 1200
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.GOLD};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX2SWORDS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null,p1.validateRerollInput("0,1,2,3,4,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),firstReroll,null,null,null,null,null);

        assertEquals(1200,p1.getScore());

    }

    @Test
    public void row103(){
        //FC: monkey business and roll 2 monkeys, 1 parrot, 2 coins, 3 diamonds   SC 1200
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.PARROT, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.DIAMOND, Game.Dice.DIAMOND, Game.Dice.DIAMOND};
        Game.FortuneCard riggCard =  Game.FortuneCard.MONKEYBUSINESS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1200,p1.getScore());
    }

    @Test
    public void row106() {
        //roll one skull and 7 swords with FC with two skulls => die
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SKULLX2;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(0,p1.getScore());

    }

    @Test
    public void row107(){
        //roll 2 skulls and 6 swords with FC with 1 skull  => die
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SKULLX1;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI(""),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(0,p1.getScore());

    }
    @Test
    public void row108(){
        //roll 2 skulls  3(parrots/monkeys) with FC with two skulls: reroll 3 parrots get 2 skulls, 1 sword
        //  reroll sword and 3 monkeys, get 3 skulls and 1 sword, stop => -900 for other players (no negative score) & you score 0
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] firstReroll = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY};
        Game.Dice[] secondReroll = {Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SKULLX2;

        Player p1 = new Player("p1");
        p1.roundStarting(riggedhand,riggCard);
        p1.getPlayers()[1].setScore(900);
        p1.getPlayers()[2].setScore(900);

        p1.doOption(p1.promptUI(""),riggedhand,null,null,null,"2",new Game.Dice[][]{firstReroll,secondReroll});
        assertEquals(0,p1.getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());


    }

    @Test
    public void row110(){

        //roll 5 skulls, 3 monkeys with FC Captain, reroll 3 monkeys, get 2 skulls, 1 coin, stop => -1400 for other players
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll= {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.CAPTAIN;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);
        p1.getPlayers()[1].setScore(1400);
        p1.getPlayers()[2].setScore(1400);

        p1.doOption(p1.promptUI(""),riggedhand,null,null,null,"3",new Game.Dice[][]{riggedReroll});
        assertEquals(0,p1.getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());
    }

    @Test
    public void row111(){
        //roll 3 skulls and 5 swords with FC with two skulls: reroll 5 swords, get 5 coins, must stop  => -500 for other players
        Game.Dice[] riggedhand = {Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] riggedReroll= {Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD, Game.Dice.GOLD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SKULLX2;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);
        p1.getPlayers()[1].setScore(500);
        p1.getPlayers()[2].setScore(500);

        p1.doOption(p1.promptUI(""),riggedhand,null,null,null,"3",new Game.Dice[][]{riggedReroll});
        assertEquals(0,p1.getScore());
        assertEquals(0,p1.getPlayers()[1].getScore());
        assertEquals(0,p1.getPlayers()[2].getScore());
    }

    @Test
    public void row114(){
        //FC 2 swords, roll 4 monkeys, 3 skulls & 1 sword and die   => die and lose 300 points
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX2SWORDS;

        Player p1 = new Player("p1");
        p1.setScore(1);

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(0,p1.getScore());

    }

    @Test
    public void row115(){
        //FC 3 swords, have 2 swords, 2 skulls and 4 parrots, reroll 4 parrots, get 4 skulls=> die and lose 500 points
        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX3SWORDS;

        Player p1 = new Player("p1");
        p1.setScore(1);

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null,p1.validateRerollInput("0,1,"),null,null,null);

        p1.doOption(p1.promptUI("3"),firstReroll,null,null,null,null,null);

        assertEquals(0,p1.getScore());

    }
    @Test
    public void row116(){

        //FC 4 swords, die on first roll with 2 monkeys, 3 (skulls/swords)  => die and lose 1000 points
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX4SWORDS;

        Player p1 = new Player("p1");
        p1.setScore(1);

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(0,p1.getScore());
    }

    @Test
    public void row117(){
        //FC 2 swords, roll 3 monkeys 2 swords, 1 coin, 2 parrots  SC = 100 + 100 + 300 = 500
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.GOLD, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX2SWORDS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(500,p1.getScore());
    }
    @Test
    public void row118(){
        //FC 2 swords, roll 4 monkeys 1 sword, 1 skull & 2 parrots
        //then reroll 2 parrots and get 1 sword and 1 skull   SC = 200 +  300 = 500
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SKULL};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX2SWORDS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null,p1.validateRerollInput("0,1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("3"),firstReroll,null,null,null,null,null);

        assertEquals(500,p1.getScore());

    }

    @Test
    public void row120(){
        //FC 3 swords, roll 3 monkeys 4 swords 1 skull SC = 100 + 200 + 500 = 800
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX3SWORDS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(800,p1.getScore());

    }

    @Test
    public void row121(){
        //FC 3 swords, roll 4 monkeys 2 swords 2 skulls
        //         then reroll 4 monkeys and get  2 skulls and 2 swords   => die and lose 500 points

        Game.Dice[] riggedhand = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.Dice[] firstReroll = {Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX3SWORDS;

        Player p1 = new Player("p1");
        p1.setScore(1);

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null,p1.validateRerollInput("0,1,2,3,4"),null,null,null);

        p1.doOption(p1.promptUI("3"),firstReroll,null,null,null,null,null);

        assertEquals(0,p1.getScore());
    }

    @Test
    public void row123(){
        //FC 4 swords, roll 3 monkeys 4 swords 1 skull  SC = 100 +200 + 1000 = 1300
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SWORD, Game.Dice.SKULL};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX4SWORDS;

        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null,null,null,null,null);
        assertEquals(1300,p1.getScore());

    }

    @Test
    public void row124(){
        //FC 4 swords, roll 3 monkeys, 1 sword, 1 skull, 1 diamond, 2 parrots
        //  then reroll 2 parrots and get 2 swords thus you have 3 monkeys, 3 swords, 1 diamond, 1 skull
        // then reroll 3 monkeys and get  1 sword and 2 parrots  SC = 200 + 100 + 1000 = 1300
        Game.Dice[] riggedhand = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.PARROT, Game.Dice.PARROT};
        Game.Dice[] firstReroll = {Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.MONKEY, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.Dice[] secondReroll = {Game.Dice.SWORD, Game.Dice.PARROT, Game.Dice.PARROT, Game.Dice.SWORD, Game.Dice.SKULL, Game.Dice.DIAMOND, Game.Dice.SWORD, Game.Dice.SWORD};
        Game.FortuneCard riggCard =  Game.FortuneCard.SEABATTLEX4SWORDS;
        Player p1 = new Player("p1");

        p1.roundStarting(riggedhand,riggCard);

        p1.doOption(p1.promptUI("1"),firstReroll,null, p1.validateRerollInput("0,1,2,3,5"),null,null,null);

        p1.doOption(p1.promptUI("1"),secondReroll,null, p1.validateRerollInput("3,5,6,7"),null,null,null);

        p1.doOption(p1.promptUI("3"),new Game.Dice[]{},null, null,null,null,null);

        assertEquals(1300,p1.getScore());

    }

}