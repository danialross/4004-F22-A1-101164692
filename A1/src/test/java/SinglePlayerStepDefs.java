import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Assertions;

public class SinglePlayerStepDefs {

    Player p;

    @Given("player initialized")
    public void player_initialized() {
        p = new Player("");
    }

    @When("first roll is {int} SKULL and {int} SWORD")
    public void first_roll_is_skull_and_sword(Integer numDice1, Integer numDice2) {

        Game.Dice[] firstRoll = {null,null,null,null,null,null,null,null,};

        for( int i = 0; i < numDice1; i++){
            firstRoll[i] = Game.Dice.SKULL;
        }

        for( int i = numDice1; i < numDice1 + numDice2; i++){
            firstRoll[i] = Game.Dice.SWORD;
        }

        p.roundStarting(firstRoll, Game.FortuneCard.GOLD);

    }

    @Then("Die")
    public void die() {
        Assertions.assertEquals(-1,p.promptUI(null));
    }



}
