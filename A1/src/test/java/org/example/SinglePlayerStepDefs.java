package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SinglePlayerStepDefs {
    Player p;

    @Given("player was initialized")
    public void player_initialized() {
        p = new Player("");
    }

    @Then("Die")
    public void die() {
        Assertions.assertEquals(-1, p.promptUI(null));
    }


    @When("first roll is {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void first_roll_is(String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8) {
        Game.Dice[] firstRoll = {null, null, null, null, null, null, null, null,};

        String[] allDice = {d1, d2, d3, d4, d5, d6, d7, d8};

        for (int i = 0; i < allDice.length; i++) {
            if (allDice[i].equals("Sword")) {
                firstRoll[i] = Game.Dice.SWORD;
            } else if (allDice[i].equals("Skull")) {
                firstRoll[i] = Game.Dice.SKULL;
            } else if (allDice[i].equals("Gold")) {
                firstRoll[i] = Game.Dice.GOLD;
            } else if (allDice[i].equals("Diamond")) {
                firstRoll[i] = Game.Dice.DIAMOND;
            } else if (allDice[i].equals("Parrot")) {
                firstRoll[i] = Game.Dice.PARROT;
            } else {
                firstRoll[i] = Game.Dice.MONKEY;
            }
        }
        p.roundStarting(firstRoll, Game.FortuneCard.GOLD);

    }
    //    reroll 2 dice
    @And("re-roll {string} and get {string}, {string}")
    public void reRollDiceAndGet(String replaceString, String d2, String d3) {
        String[] replaceDiceWith = {d2, d3};
        int counter = 0;

        Game.Dice replacingDice;

        if(replaceString.equals("Swords")){
            replacingDice = Game.Dice.SWORD;

        }else if(replaceString.equals("Golds")){
            replacingDice = Game.Dice.GOLD;

        }else if(replaceString.equals("Diamonds")){
            replacingDice = Game.Dice.DIAMOND;

        }else if(replaceString.equals("Parrots")){
            replacingDice = Game.Dice.PARROT;

        }else{
            replacingDice = Game.Dice.MONKEY;

        }

        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice) {
                if (replaceDiceWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;

                } else if (replaceDiceWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;

                } else if (replaceDiceWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;

                } else if (replaceDiceWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;

                } else if (replaceDiceWith[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;

                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI("1"),p.getPlayerRoll(),null, p.validateRerollInput("7"),null,null,null);

    }
    //    reroll 3 dice
    @And("re-roll {string} and get {string}, {string}, {string}")
    public void reRollDiceAndGet(String replaceString, String d2, String d3,String d4) {
        String[] replaceDiceWith = {d2, d3, d4};
        int counter = 0;

        Game.Dice replacingDice;
        if(replaceString.equals("Swords")){
            replacingDice = Game.Dice.SWORD;
        }else if(replaceString.equals("Golds")){
            replacingDice = Game.Dice.GOLD;
        }else if(replaceString.equals("Diamonds")){
            replacingDice = Game.Dice.DIAMOND;
        }else if(replaceString.equals("Parrots")){
            replacingDice = Game.Dice.PARROT;
        }else{
            replacingDice = Game.Dice.MONKEY;

        }

        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice) {
                if (replaceDiceWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;
                } else if (replaceDiceWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;
                } else if (replaceDiceWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;
                } else if (replaceDiceWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;
                } else if (replaceDiceWith[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;
                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI("1"), p.getPlayerRoll(), null, p.validateRerollInput("7"), null, null, null);

    }
    //    reroll 4 dice
    @And("re-roll {string} and get {string}, {string}, {string}, {string}")
    public void reRollAndGet(String replaceString, String d1, String d2, String d3, String d4) {
        String[] replaceDiceWith = {d1, d2, d3, d4};
        Game.Dice replacingDice;


        if(replaceString.equals("Swords")){
            replacingDice = Game.Dice.SWORD;
        }else if(replaceString.equals("Golds")){
            replacingDice = Game.Dice.GOLD;
        }else if(replaceString.equals("Diamonds")){
            replacingDice = Game.Dice.DIAMOND;
        }else if(replaceString.equals("Parrots")){
            replacingDice = Game.Dice.PARROT;
        }else{
            replacingDice = Game.Dice.MONKEY;

        }

        int counter = 0;
        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice) {
                if (replaceDiceWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;
                } else if (replaceDiceWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;
                } else if (replaceDiceWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;
                } else if (replaceDiceWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;
                } else if (replaceDiceWith[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;
                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI("1"),p.getPlayerRoll(),null, p.validateRerollInput("7"),null,null,null);

    }

    @Then("Score {int}")
    public void score(int score) {
        p.doOption(p.promptUI("3"),p.getPlayerRoll(),null,null,null,null,null);
        Assertions.assertEquals(score,p.getScore());
    }

    @And("fortune card is {string}")
    public void fortuneCardIs(String card) {
        Game.FortuneCard currentCard;

        if(card.equals("Treasure Chest")) {
            currentCard = Game.FortuneCard.TREASURECHEST;
        }else if(card.equals("Captain")) {
            currentCard = Game.FortuneCard.CAPTAIN;
        }else if(card.equals("Monkey Business")) {
            currentCard = Game.FortuneCard.MONKEYBUSINESS;
        }else if(card.equals("Diamond")) {
            currentCard = Game.FortuneCard.DIAMOND;
        }else if(card.equals("Gold")) {
            currentCard = Game.FortuneCard.GOLD;
        }else if(card.equals("1 Skull")) {
            currentCard = Game.FortuneCard.SKULLX1;
        }else if(card.equals("2 Skulls")) {
            currentCard = Game.FortuneCard.SKULLX2;
        }else if(card.equals("SeaBattle with 4 swords")) {
            currentCard = Game.FortuneCard.SEABATTLEX4SWORDS;
        }else if(card.equals("SeaBattle with 3 swords")) {
            currentCard = Game.FortuneCard.SEABATTLEX3SWORDS;
        }else {
            currentCard = Game.FortuneCard.SEABATTLEX2SWORDS;
        }

        p.roundStarting(p.getPlayerRoll(),currentCard);
    }

    @And("use sorceress to reroll and get {string}")
    public void reRollSkullWithSorceressAndGet(String wantedString) {

        Game.Dice wantedDice;

        if(wantedString.equals("Sword")){
            wantedDice = Game.Dice.SWORD;
        }else if(wantedString.equals("Gold")){
            wantedDice = Game.Dice.GOLD;
        }else if(wantedString.equals("Diamond")){
            wantedDice = Game.Dice.DIAMOND;
        }else if(wantedString.equals("Parrot")){
            wantedDice = Game.Dice.PARROT;
        }else if(wantedString.equals("Monkey")){
            wantedDice = Game.Dice.MONKEY;
        }else{
            wantedDice = Game.Dice.SKULL;
        }


        p.rerollSkull(wantedDice);
    }

    @And("re-roll {string} and {string} and get {string}, {string}, {string}, {string}")
    public void reRollAndAndGet(String replace1, String replace2, String d2, String d3, String d4, String d5) {
        String[] replaceDiceWith = {d2, d3, d4, d5};

        int counter = 0;
        Game.Dice replacingDice1;
        Game.Dice replacingDice2;

        if(replace1.equals("Swords")){
            replacingDice1 = Game.Dice.SWORD;
        }else if(replace1.equals("Golds")){
            replacingDice1 = Game.Dice.GOLD;
        }else if(replace1.equals("Diamonds")){
            replacingDice1 = Game.Dice.DIAMOND;
        }else if(replace1.equals("Parrots")){
            replacingDice1 = Game.Dice.PARROT;
        }else{
            replacingDice1 = Game.Dice.MONKEY;
        }

        if(replace2.equals("Swords")){
            replacingDice2 = Game.Dice.SWORD;
        }else if(replace2.equals("Golds")){
            replacingDice2 = Game.Dice.GOLD;
        }else if(replace2.equals("Diamonds")){
            replacingDice2 = Game.Dice.DIAMOND;
        }else if(replace2.equals("Parrots")){
            replacingDice2 = Game.Dice.PARROT;
        }else{
            replacingDice2 = Game.Dice.MONKEY;
        }

        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice1 || p.getPlayerRoll()[i] == replacingDice2) {
                if (replaceDiceWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;

                } else if (replaceDiceWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;

                } else if (replaceDiceWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;

                } else if (replaceDiceWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;

                } else if (replaceDiceWith[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;

                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI("1"), p.getPlayerRoll(), null, p.validateRerollInput("7"), null, null, null);

    }

    @And("other players score was {int}")
    public void otherPlayerScoreIs(int score) {
        p.getPlayers()[1].setScore(score);
        p.getPlayers()[2].setScore(score);
    }

    @Then("other players score is {int}")
    public void otherPlayersScoreIs(int score) {
        Assertions.assertEquals(score,p.getPlayers()[1].getScore());
        Assertions.assertEquals(score,p.getPlayers()[2].getScore());
    }

    @Then("re-roll in skull island {string} to get {string}, {string}, {string} then re-roll {string} and {string} and get {string}, {string}, {string}, {string}")
    public void reRollInSkullIslandToGetAndReRollAndAndGet(String replaceString1, String d1, String d2, String d3, String replaceString2, String replaceString3, String d4, String d5, String d6, String d7) {
        Game.Dice replaceDice1;
        String[] replaceReroll1 = {d1, d2, d3};

        Game.Dice replaceDice2;
        Game.Dice replaceDice3;
        String[] replaceReroll2 = {d4, d5, d6, d7};

        Game.Dice[] firstReroll = {null,null,null,null,null,null,null,null};
        Game.Dice[] secondReroll = {null,null,null,null,null,null,null,null};

        for(int i = 0; i<p.getPlayerRoll().length;i++){
            firstReroll[i] = p.getPlayerRoll()[i];
            secondReroll[i] = p.getPlayerRoll()[i];

        }

        if(replaceString1.equals("Swords")){
            replaceDice1 = Game.Dice.SWORD;
        }else if(replaceString1.equals("Golds")){
            replaceDice1 = Game.Dice.GOLD;
        }else if(replaceString1.equals("Diamonds")){
            replaceDice1 = Game.Dice.DIAMOND;
        }else if(replaceString1.equals("Parrots")){
            replaceDice1 = Game.Dice.PARROT;
        }else{
            replaceDice1 = Game.Dice.MONKEY;
        }

        if(replaceString2.equals("Swords")){
            replaceDice2 = Game.Dice.SWORD;
        }else if(replaceString2.equals("Golds")){
            replaceDice2 = Game.Dice.GOLD;
        }else if(replaceString2.equals("Diamonds")){
            replaceDice2 = Game.Dice.DIAMOND;
        }else if(replaceString2.equals("Parrots")){
            replaceDice2 = Game.Dice.PARROT;
        }else{
            replaceDice2 = Game.Dice.MONKEY;
        }

        if(replaceString3.equals("Swords")){
            replaceDice3 = Game.Dice.SWORD;
        }else if(replaceString3.equals("Golds")){
            replaceDice3 = Game.Dice.GOLD;
        }else if(replaceString3.equals("Diamonds")){
            replaceDice3 = Game.Dice.DIAMOND;
        }else if(replaceString3.equals("Parrots")){
            replaceDice3 = Game.Dice.PARROT;
        }else{
            replaceDice3 = Game.Dice.MONKEY;
        }

        int counter = 0;
        for(int i = 0; i<firstReroll.length;i++){
            if(firstReroll[i] == replaceDice1){
                if(replaceReroll1[counter].equals("Swords")){
                    firstReroll[i] = Game.Dice.SWORD;
                }else if(replaceReroll1[counter].equals("Golds")){
                    firstReroll[i] = Game.Dice.GOLD;
                }else if(replaceReroll1[counter].equals("Diamonds")){
                    firstReroll[i] = Game.Dice.DIAMOND;
                }else if(replaceReroll1[counter].equals("Parrots")){
                    firstReroll[i] = Game.Dice.PARROT;
                }else{
                    firstReroll[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        counter = 0;
        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replaceDice2 || p.getPlayerRoll()[i] == replaceDice3) {
                if (replaceReroll2[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;

                } else if (replaceReroll2[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;

                } else if (replaceReroll2[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;

                } else if (replaceReroll2[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;

                } else if (replaceReroll2[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;

                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI(""),p.getPlayerRoll(),null,null,null,"2",new Game.Dice[][]{firstReroll,secondReroll});
    }

    @Then("player score is {int}")
    public void playerScoreIs(int score) {
        Assertions.assertEquals(0,p.getScore());
    }

    @And("re-roll in skull island {string} to get {string}, {string}, {string}")
    public void reRollInSkullIslandToGet(String replaceString, String d1, String d2, String d3) {
        Game.Dice replaceDice1;
        String[] replaceReroll = {d1, d2, d3};

        Game.Dice[] reroll = {null,null,null,null,null,null,null,null};

        for(int i = 0; i<p.getPlayerRoll().length;i++){
            reroll[i] = p.getPlayerRoll()[i];
        }

        if(replaceString.equals("Swords")){
            replaceDice1 = Game.Dice.SWORD;
        }else if(replaceString.equals("Golds")){
            replaceDice1 = Game.Dice.GOLD;
        }else if(replaceString.equals("Diamonds")){
            replaceDice1 = Game.Dice.DIAMOND;
        }else if(replaceString.equals("Parrots")){
            replaceDice1 = Game.Dice.PARROT;
        }else{
            replaceDice1 = Game.Dice.MONKEY;
        }

        int counter = 0;
        for(int i = 0; i<reroll.length;i++){
            if(reroll[i] == replaceDice1){
                if(replaceReroll[counter].equals("Swords")){
                    reroll[i] = Game.Dice.SWORD;
                }else if(replaceReroll[counter].equals("Golds")){
                    reroll[i] = Game.Dice.GOLD;
                }else if(replaceReroll[counter].equals("Diamonds")){
                    reroll[i] = Game.Dice.DIAMOND;
                }else if(replaceReroll[counter].equals("Parrots")){
                    reroll[i] = Game.Dice.PARROT;
                }else{
                    reroll[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI(""),p.getPlayerRoll(),null,null,null,"2",new Game.Dice[][]{reroll});
    }

    @And("re-roll in skull island {string} to get {string}, {string}, {string}, {string}, {string}")
    public void reRollInSkullIslandToGet(String replaceString, String d1, String d2, String d3, String d4, String d5) {
        Game.Dice replaceDice1;
        String[] replaceReroll = {d1, d2, d3, d4, d5};

        Game.Dice[] reroll = {null,null,null,null,null,null,null,null};

        for(int i = 0; i<p.getPlayerRoll().length;i++){
            reroll[i] = p.getPlayerRoll()[i];
        }

        if(replaceString.equals("Swords")){
            replaceDice1 = Game.Dice.SWORD;
        }else if(replaceString.equals("Golds")){
            replaceDice1 = Game.Dice.GOLD;
        }else if(replaceString.equals("Diamonds")){
            replaceDice1 = Game.Dice.DIAMOND;
        }else if(replaceString.equals("Parrots")){
            replaceDice1 = Game.Dice.PARROT;
        }else{
            replaceDice1 = Game.Dice.MONKEY;
        }

        int counter = 0;
        for(int i = 0; i<reroll.length;i++){
            if(reroll[i] == replaceDice1){
                if(replaceReroll[counter].equals("Swords")){
                    reroll[i] = Game.Dice.SWORD;
                }else if(replaceReroll[counter].equals("Golds")){
                    reroll[i] = Game.Dice.GOLD;
                }else if(replaceReroll[counter].equals("Diamonds")){
                    reroll[i] = Game.Dice.DIAMOND;
                }else if(replaceReroll[counter].equals("Parrots")){
                    reroll[i] = Game.Dice.PARROT;
                }else{
                    reroll[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI(""),p.getPlayerRoll(),null,null,null,"2",new Game.Dice[][]{reroll});
    }
}


