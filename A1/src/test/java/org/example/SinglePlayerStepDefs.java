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

    @And("re-roll {string} and get {string}, {string}, {string}")
    public void reRollSwordsToAndGet(String d1, String d2, String d3,String d4) {
        String[] replaceSwordWith = {d2, d3, d4};
        int counter = 0;
        Game.Dice replacingDice;

        if(d1.equals("Swords")){
            replacingDice = Game.Dice.SWORD;

        }else if(d1.equals("Golds")){
            replacingDice = Game.Dice.GOLD;

        }else if(d1.equals("Diamonds")){
            replacingDice = Game.Dice.DIAMOND;

        }else if(d1.equals("Parrots")){
            replacingDice = Game.Dice.PARROT;

        }else{
            replacingDice = Game.Dice.MONKEY;

        }

            for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice) {
                if (replaceSwordWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;

                } else if (replaceSwordWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;

                } else if (replaceSwordWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;

                } else if (replaceSwordWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;

                } else if (replaceSwordWith[counter].equals("Parrot")) {
                    p.getPlayerRoll()[i] = Game.Dice.PARROT;

                } else {
                    p.getPlayerRoll()[i] = Game.Dice.MONKEY;
                }
                counter++;
            }
        }

        p.doOption(p.promptUI("1"), p.getPlayerRoll(), null, p.validateRerollInput("7"), null, null, null);

    }

    @And("re-roll {string} and get {string}, {string}")
    public void reRollSwordsToAndGet(String d1, String d2, String d3) {
        String[] replaceSwordWith = {d2, d3};
        int counter = 0;

        Game.Dice replacingDice;

        if(d1.equals("Swords")){
            replacingDice = Game.Dice.SWORD;

        }else if(d1.equals("Golds")){
            replacingDice = Game.Dice.GOLD;

        }else if(d1.equals("Diamonds")){
            replacingDice = Game.Dice.DIAMOND;

        }else if(d1.equals("Parrots")){
            replacingDice = Game.Dice.PARROT;

        }else{
            replacingDice = Game.Dice.MONKEY;

        }

        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == replacingDice) {
                if (replaceSwordWith[counter].equals("Sword")) {
                    p.getPlayerRoll()[i] = Game.Dice.SWORD;

                } else if (replaceSwordWith[counter].equals("Skull")) {
                    p.getPlayerRoll()[i] = Game.Dice.SKULL;

                } else if (replaceSwordWith[counter].equals("Gold")) {
                    p.getPlayerRoll()[i] = Game.Dice.GOLD;

                } else if (replaceSwordWith[counter].equals("Diamond")) {
                    p.getPlayerRoll()[i] = Game.Dice.DIAMOND;

                } else if (replaceSwordWith[counter].equals("Parrot")) {
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
        }else if(card.equals("2 Skull")) {
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
}


