package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    void row45() {

        Player p1 = new Player("p1");
        Game game = p1.game;

        Game.Dice[] playerHand = {};
        Game.Dice[] riggedhand = {Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SKULL,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD,Game.Dice.SWORD};

        p1.setPlayerRoll(game.rollDice(playerHand,riggedhand));
        p1.setFc(game.pickCard(Game.FortuneCard.GOLD));

        if(game.didDie(p1.getPlayerRoll(),p1.getFc()) == -1 ){
            p1.setScore(0);
        }

        assertEquals(0,p1.getScore());
    }
}