package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Game;
import org.example.Player;
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

    @And("re-roll swords to and get {string}, {string}, {string}")
    public void reRollSwordsToAndGet(String d1, String d2, String d3) {
        String[] replaceSwordWith = {d1, d2, d3};

        int counter = 0;

        for (int i = 0; i < p.getPlayerRoll().length; i++) {
            if (p.getPlayerRoll()[i] == Game.Dice.SWORD) {
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

        p.doOption(p.promptUI("1"), p.getPlayerRoll(), null, p.validateRerollInput("1,2,3,4"), null, null, null);

    }
}


