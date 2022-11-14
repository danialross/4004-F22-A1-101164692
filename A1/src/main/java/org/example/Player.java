package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    public Game game = new Game();

    static Client clientConnection;
    int playerId = 0;

    private String name;
    private Game.Dice[] playerRoll;
    private Game.FortuneCard fc;
    private int score;

    private Player[] players = new Player[3];

    private Game.Dice[] savedDice;
    private int[] savedDicePos;

    public String getName() {
        return name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Game.Dice[] getPlayerRoll() {
        return playerRoll;
    }

    public void setPlayerRoll(Game.Dice[] playerRoll) {
        this.playerRoll = playerRoll;
    }

    public Game.FortuneCard getFc() {
        return fc;
    }

    public void setFc(Game.FortuneCard fc) {
        this.fc = fc;
    }

    public Game.Dice[] getSavedDice() {
        return savedDice;
    }

    public void setSavedDice(Game.Dice[] savedDice) {
        this.savedDice = savedDice;
    }

    public int[] getSavedDicePos() {
        return savedDicePos;
    }

    public void setSavedDicePos(int[] savedDicePos) {
        this.savedDicePos = savedDicePos;
    }

    // constructor initializes all variables needed to start the game
    public Player(String name){
        this.name = name;
        score = 0;
    }
    public void roundStarting(Game.Dice[] riggedhand, Game.FortuneCard riggedCard){

        Game.Dice[] init = {Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND,Game.Dice.DIAMOND};
        Game.Dice[] empty = {};

        if(riggedhand.length != 0) {
            playerRoll = game.rollDice(empty, riggedhand);

        }else{
            playerRoll = game.rollDice(init, empty);
        }


        if (riggedCard != null) {
            fc = Game.pickCard(riggedCard);
        }else{
            fc = Game.pickCard(null);
        }





        for( int i = 0; i<players.length; i++){

            players[i] = new Player("Player " + (i+1));

        }
    }


    public void checkDead(){
        if(fc == Game.FortuneCard.SEABATTLEX2SWORDS || fc == Game.FortuneCard.SEABATTLEX3SWORDS || fc == Game.FortuneCard.SEABATTLEX4SWORDS){
            if(game.didWinSeaBattle(playerRoll,fc) == false){
                int amount = 0;
                amount = game.reducePlayerScore(game.scoreSeabattle(playerRoll, fc),score);
                score = amount;
                System.out.println(status(7) + amount + " points \n");
            }


        }
        if(game.didDie(this.playerRoll,this.fc) == -1 ){
            System.out.println(status(2));
        }
    }

    public void lockInPoints(Game.Dice[] riggedDice, Game.FortuneCard riggedFc){
        if(this.savedDice != null){
            playerRoll = game.changeNullToDice(playerRoll,this.savedDicePos,this.savedDice);
        }

        if(riggedDice != null){
            playerRoll = riggedDice;
        }if(riggedFc != null){
            fc = riggedFc;
        }
        score += game.scorePoints(playerRoll,fc);
        checkDead();

    }

    public void playerReroll(int[] savedDiceIndex, Game.Dice[] riggedDice){

        saveDice(savedDiceIndex);
        playerRoll = game.rollDice(playerRoll,riggedDice);
        removeFromChest();


    }

    public void rerollSkull(Game.Dice riggedDice){

        playerRoll = game.sorceressReroll(playerRoll,riggedDice);
        fc = null;

    }

    public void saveDice(int[] diceIndexToAdd){

        savedDicePos = diceIndexToAdd;
        savedDice = game.getSavedDice(playerRoll,diceIndexToAdd);
        playerRoll = game.changeDiceToNull(playerRoll,savedDicePos);

    }

    public void removeFromChest(){
        playerRoll = game.changeNullToDice(playerRoll,savedDicePos,savedDice);
        savedDicePos = null;
        savedDice = null;

    }

    // minus other players score from skull roll result
    public void skullRollReducer(Game.Dice[] riggedDice){
        //true means had skull else no skull

        Game.Dice[] hand;

        if(riggedDice != null){
            hand = riggedDice;
        }else{
            hand = playerRoll;
        }

        int reducer = game.getScoreDeduction(game.calcNumSkull(hand),fc);

        for(int i = 0; i<players.length;i++){
            if(players[i].name != this.name){
                players[i].setScore(game.reducePlayerScore(reducer,players[i].score));

            }
        }

    }

    public int promptUI(String rig){
        System.out.println("|-----------------------------------------------------------|");
        System.out.println("|----Player Roll:----["+playerRoll[0]+"]----["+playerRoll[1]+"]----["+playerRoll[2]+"]----["+playerRoll[3]+"]----["+playerRoll[4]+"]----["+playerRoll[5]+"]----["+playerRoll[6]+"]----["+playerRoll[7]+"]----|");
        System.out.println("|----Fortune Card:----"+ fc + "----|");
        if(fc == Game.FortuneCard.SEABATTLEX2SWORDS || fc == Game.FortuneCard.SEABATTLEX3SWORDS || fc == Game.FortuneCard.SEABATTLEX4SWORDS){
            System.out.println(status(8));
        }

        if(game.didDie(playerRoll,fc) == -1){
            checkDead();
            if(fc == Game.FortuneCard.SEABATTLEX2SWORDS){
                System.out.println(status(3) + "300 points");
            }else if(fc == Game.FortuneCard.SEABATTLEX3SWORDS){
                System.out.println(status(3) + "500 points");
            }else if(fc == Game.FortuneCard.SEABATTLEX4SWORDS){
                System.out.println(status(3) + "1000 points");
            }
            return -1;
        }else if (game.didDie(playerRoll,fc) == 0){
            return -2;

        }

        if(fc == Game.FortuneCard.TREASURECHEST){
            if(savedDice != null){
                String savedString = "|----Treasure Chest:----";
                for ( int i = 0; i < savedDice.length; i++){
                    savedString += "[" + savedDice[i] + "]----";
                }
                savedString += "|";
                System.out.println(savedString);

            }

        }else if(fc == Game.FortuneCard.SEABATTLEX2SWORDS || fc == Game.FortuneCard.SEABATTLEX3SWORDS || fc == Game.FortuneCard.SEABATTLEX4SWORDS){
            status(7);
            if(fc == Game.FortuneCard.SEABATTLEX2SWORDS){
                System.out.println("|----Target : 2 Swords----|");
            }else if(fc == Game.FortuneCard.SEABATTLEX3SWORDS){
                System.out.println("|----Target : 3 Swords----|");
            }else{
                System.out.println("|----Target : 4 Swords----|");
            }


        }

        int action;
        int upperOption = 3 ;
        Scanner scanner;

        if(rig != null){
            scanner = new Scanner(rig);
        }else{
            scanner = new Scanner(System.in);
        }

        System.out.println("Select an action:");
        if(fc == Game.FortuneCard.SORCERESS && game.calcNumSkull(playerRoll)>=3){
            //dont show ui, force skull reroll
        }else{
            System.out.println("1. Choose dice to roll again");
            System.out.println("2. Reroll all dice");
            System.out.println("3. Score with current hand");
        }


        if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
            System.out.println("4. Reroll a skull");
            upperOption = 4;
        }else if(fc == Game.FortuneCard.TREASURECHEST){
            System.out.println("4. Save dice in treasure chest");
            upperOption = 4;
            if(savedDicePos != null){
                System.out.println("5. Take dice out from treasure chest");
                upperOption = 5;
            }

        }

        if(scanner.hasNextInt()){
            action = scanner.nextInt();
        }else{
            action = -555;
            System.out.println("Invalid Option");
        }


        while(action <=0 || action > upperOption){

            if(rig !=null){
                System.out.println("Invalid Option");
                if(action == -555)  {
                    System.out.println("infinite loop\n");

                }else if(action == 4 && upperOption == 3){
                    System.out.println("trying to sorcerer reroll without skull\n");

                }else if(action == 5 && savedDicePos == null){
                    System.out.println("trying take dice out from treasure chest when its empty\n");
                }

                return -555;
            }

            if(fc != Game.FortuneCard.SORCERESS && game.calcNumSkull(playerRoll)<3){
                System.out.println("1. Choose dice to roll again");
                System.out.println("2. Reroll all dice");
                System.out.println("3. Score with current hand");
            }
            if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
                System.out.println("4. Reroll a skull");
            }

            if(scanner.hasNextInt()){
                action = scanner.nextInt();
            }else{
                action = -555;
                System.out.println("Invalid Option");
            }

            if( action == 1 || action == 2 || action == 3 || (fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)) && action == 4) {
                return action;
            }


        }
        return action;
    }

    public int[] validateRerollInput(String rigging){
        int[] input = new int[0];
        Scanner scanner;
        if(rigging != null){
            scanner = new Scanner(rigging);
        }else{
            scanner = new Scanner(System.in);
        }


        boolean askAgain = true;

        while(askAgain){
            askAgain = false;

            if(rigging != null && input.length != 0){
                return null;
            }
            System.out.println("Select indexes of die to hold (not rolled) i.e: 0,1,2.. ");
            boolean isNumbers = true;
            String[] DicePosInString;

            try{
                DicePosInString = (scanner.next()).replaceAll("\\s", "").split(",");
                if(DicePosInString.length == 0 ){
                    isNumbers = false;
                    DicePosInString = new String[]{"null"};
                }
            }catch (Exception e){
                isNumbers = false;
                DicePosInString = new String[]{"null"};
            }

            input = new int[DicePosInString.length];
            for(int i = 0; i<DicePosInString.length;i++){
                try{
                    input[i] = Integer.parseInt(DicePosInString[i]);
                }catch (Exception e){
                    isNumbers = false;
                }

            }
            if(isNumbers) {

                for (int i = 0; i < input.length; i++) {
                    if (input[i] >= playerRoll.length || input[i] < 0) {

                        askAgain = true;
                        System.out.println("Index Selected Out of Bound, try again between 0 and " + (playerRoll.length - 1));
                        break;
                    } else {
                        if (playerRoll[input[i]] == Game.Dice.SKULL || playerRoll[input[i]] == null) {
                            askAgain = true;
                            System.out.println("Skull dice cannot be rerolled");
                            break;
                        }
                    }
                }
                if (savedDicePos != null) {
                    if (savedDicePos.length + input.length > 6) {
                        System.out.println("A minimum of 2 dice must be available to roll");
                        askAgain = true;
                    }
                } else {
                    int totalValidDice = 0;

                    for(int i = 0; i< playerRoll.length; i++){
                        if(playerRoll[i] != Game.Dice.SKULL){
                            totalValidDice++;
                        }
                    }
                    if(totalValidDice-input.length <2 ){
                        System.out.println("A minimum of 2 dice must be available to roll");
                        askAgain = true;
                    }

                }
            }else{
                System.out.println("Invalid input");
                askAgain = true;
            }
        }

        return input;
    }

    public String status(int code) {

        String condition = "Player";

        String start = " turn started";
        String died = " has died";
        String deduct = "'s score has been deducted by ";
        String skull = " has gone to Island Of the Dead";
        String end = " turn ended";
        String won = " has won!";
        String seaBattle = " is in a SeaBattle";
        String increase = " scored ";

        if(code == 1){
            condition += start;
        }else if(code == 2){
            condition += died;
        }else if(code == 3){
            condition += deduct;
        }else if(code == 4){
            condition += skull;
        }else if(code == 5){
            condition += end;
        }else if(code == 6) {
            condition += won;
        }else if(code == 7) {
            condition += increase;
        }else {
            condition += seaBattle;
        }

        return condition;
    }

    public void doOption(int option, Game.Dice[] rigHand, Game.FortuneCard rigCard,int[] savedIndex,Game.Dice rigSorceressDice,String skullIslandOption, Game.Dice[][] siRigHand){

        if(rigHand.length != 0){
            playerRoll = rigHand;
        }
        if(rigCard != null){
            fc = rigCard;
        }

        if(option == -2){
            status(4);
            boolean firstLoop = true;
            int maxOption;
            int totalSkullRolled = 0;
            int currentRiggedRollIndex = -1;

            if(fc == Game.FortuneCard.SKULLX1){
                totalSkullRolled++;
            }else if (fc == Game.FortuneCard.SKULLX2){
                totalSkullRolled+=2;
            }

            skullRollReducer(null);
            while(game.calcNumSkull(playerRoll)>0){

                totalSkullRolled += game.calcNumSkull(playerRoll);
                String hand = "|----Player Roll:----";

                for(int i = 0; i<playerRoll.length; i++){
                    if( i == playerRoll.length-1 ){
                        hand += "["+playerRoll[i]+"]----|";
                    }else{
                        hand += "["+playerRoll[i]+"]----";
                    }

                }
                playerRoll = handWithoutSkull();

                System.out.println("|------------------------------------------------|");
                System.out.println(hand);
                System.out.println("|----Fortune Card:----"+ fc + "----|");


                if(firstLoop){
                    System.out.println(status(4));
                    hand = "|----Player Roll:----";
                    for(int i = 0; i<playerRoll.length; i++){
                        if( i == playerRoll.length-1 ){
                            hand += "["+playerRoll[i]+"]----|";
                        }else{
                            hand += "["+playerRoll[i]+"]----";
                        }

                    }
                    System.out.println(hand);
                    System.out.println("|----Fortune Card:----"+ fc + "----|");
                }

                if(playerRoll.length<2){
                    return;
                }

                System.out.println("1. Choose dice to roll again");
                System.out.println("2. Reroll all dice");
                System.out.println("3. Score with current hand");
                maxOption = 3;


                Scanner scanner;
                if(skullIslandOption != null){
                    scanner = new Scanner(skullIslandOption);
                }else{
                    scanner = new Scanner(System.in);
                }

                int action;
                if(scanner.hasNextInt()){
                    action = scanner.nextInt();
                }else {
                    action = -1;
                }

                while (action < 0 || action > maxOption ) {

                    // loop hole to test rigging
                    if(action == 3 && siRigHand != null){
                        break;
                    }

                    System.out.println("Invalid Option");
                    System.out.println("Please Select 1, 2 or 3");

                    scanner.next();
                    if(scanner.hasNextInt()){
                        action = scanner.nextInt();
                    }else {
                        action = -1;
                    }

                }
                currentRiggedRollIndex++;
                if(siRigHand != null && currentRiggedRollIndex < siRigHand.length){
                    playerRoll = siRigHand[currentRiggedRollIndex];
                }
                if(action == 1){

                    if(savedIndex != null){

                        firstLoop = false;
                        playerReroll(savedIndex,playerRoll);
                        skullRollReducer(playerRoll);


                    }else{
                        playerReroll(validateRerollInput(null),new Game.Dice[]{});
                        skullRollReducer(null);
                    }

                }else if(action == 2){
                    if(siRigHand != null) {

                        firstLoop = false;
                        playerReroll(new int[]{}, playerRoll);
                        skullRollReducer(playerRoll);


                    }else{
                        playerReroll(new int[]{}, new Game.Dice[]{});
                        skullRollReducer(null);
                    }

                }else if (action == 3) {

                    if (siRigHand != null) {

                        skullRollReducer(playerRoll);
                        totalSkullRolled += game.calcNumSkull(playerRoll);
                    } else {
                        skullRollReducer(null);
                    }
                }
            }
            String hand = "|----Player Roll:----";

            for(int i = 0; i<playerRoll.length; i++){
                if( i == playerRoll.length-1 ){
                    hand += "["+playerRoll[i]+"]----|";
                }else{
                    hand += "["+playerRoll[i]+"]----";
                }

            }
            int multiplier = 100;
            if(fc == Game.FortuneCard.CAPTAIN){
                multiplier = 200;
            }
            System.out.println(hand);
            System.out.println("Other players score reduced by " + (totalSkullRolled)*multiplier + " points");
            System.out.println("Player has left the Island Of the Dead");

        } else if(option == 1){
            if(rigHand.length != 0){
                playerReroll(savedIndex,rigHand);
            }else{
                playerReroll(savedIndex,new Game.Dice[]{});
            }


        } else if (option == 2){
            playerReroll(new int[]{},new Game.Dice[]{});

        }else if(option == 3){
            if(fc == Game.FortuneCard.SEABATTLEX2SWORDS || fc == Game.FortuneCard.SEABATTLEX3SWORDS || fc == Game.FortuneCard.SEABATTLEX4SWORDS ){
                int amount = 0;
                amount = game.scoreSeabattle(playerRoll, fc);


                if(game.didWinSeaBattle(playerRoll,fc) == true) {
                    score += amount;
                    System.out.println(status(7) + amount + " points \n");
                }
                else{
                    score = game.reducePlayerScore(amount,score);
                    System.out.println(status(3) + amount + " points \n");
                }

            }else{
                lockInPoints(playerRoll,fc);
                checkDead();
            }
        }else if(option == 4){
            if(fc == Game.FortuneCard.SORCERESS && game.isContainSkull(playerRoll)){
                if(rigSorceressDice != null){
                    rerollSkull(rigSorceressDice);
                }else{
                    rerollSkull(null);
                }


            }else{
                if(savedIndex != null){
                    saveDice(savedIndex);
                }else{
                    saveDice(validateRerollInput(null));
                }
            }
        }else{
            playerRoll = game.changeNullToDice(playerRoll,savedDicePos,savedDice);
            savedDicePos = null;
            savedDice = null;
        }
    }

    public Player checkWinner(){

        if(game.didReachWinThreshold(players) == true){
            return game.getWinner(players);
        }else{
            return null;
        }
    }

    //when entering skull island player should not bring previously rolled skulls
    public Game.Dice[] handWithoutSkull(){

        int numSkull = game.calcNumSkull(playerRoll);

        Game.Dice[] newHand = new Game.Dice[8-(8-playerRoll.length+numSkull)];

        for( int i = 0; i< newHand.length; i++){
            newHand[i] = Game.Dice.DIAMOND;
        }

        return newHand;
    }
    public Player getPlayer() {
        return this;
    }

    /*
     * ----------Network Stuff------------
     */

    /*
     * send the to do to test server
     */

    public void connectToClient() {
        clientConnection = new Client();
    }

    /*
     * update turns
     */
    public void printPlayerScores(Player[] pl) {
        // print the score sheets

        if (playerId == 1) {
            game.printScore(pl[0]);
            game.printScore(pl[1]);
            game.printScore(pl[2]);
        } else if (playerId == 2) {
            game.printScore(pl[1]);
            game.printScore(pl[0]);
            game.printScore(pl[2]);
        } else {
            game.printScore(pl[2]);
            game.printScore(pl[0]);
            game.printScore(pl[1]);
        }
    }

    public void startGame() {
        // receive players once for names
        players = clientConnection.receivePlayer();
        while (!game.didReachWinThreshold(players)) {

            int[] pl = clientConnection.receiveScores();
            System.out.println(status(1));
            for (int i = 0; i < 3; i++) {
                players[i].setScore(pl[i]);
            }
            printPlayerScores(players);
            roundStarting(new Game.Dice[]{},null);

            int option = promptUI(null);
            int[] validatedInput = null;

            if(option == 1){
                validatedInput = validateRerollInput(null);
            }

            if(option == 4){
                doOption(option, new Game.Dice[]{},null,null,null,null,null);
            }

            doOption(option, new Game.Dice[]{},null,validatedInput,null,null,null);
            System.out.println(status(5));
            clientConnection.sendScores(score);
        }

    }

    public Player returnWinner() {
        try {
            int[] pl = clientConnection.receiveScores();
            for (int i = 0; i < 3; i++) {
                players[i].setScore(pl[i]);
            }
            printPlayerScores(players);
            Player win = (Player) clientConnection.dIn.readObject();
            if (playerId == win.playerId) {
                System.out.println("You win!");
            } else {
                System.out.println("The winner is " + win.name);
            }

            System.out.println("Game over!");
            return win;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class Client {
        Socket socket;
        private ObjectInputStream dIn;
        private ObjectOutputStream dOut;

        public Client() {
            try {
                socket = new Socket("localhost", 3400);
                dOut = new ObjectOutputStream(socket.getOutputStream());
                dIn = new ObjectInputStream(socket.getInputStream());

                playerId = dIn.readInt();

                System.out.println("Connected as " + playerId);
                sendPlayer();

            } catch (IOException ex) {
                System.out.println("Client failed to open");
            }
        }


        public void sendPlayer() {
            try {
                dOut.writeObject(getPlayer());
                dOut.flush();
            } catch (IOException ex) {
                System.out.println("Player not sent");
                ex.printStackTrace();
            }
        }


        /*
         * receive scoresheet
         */
        public void sendScores(int scores) {
            try {

                dOut.writeInt(scores);

                dOut.flush();

            } catch (IOException e) {
                System.out.println("Score not received");
                e.printStackTrace();
            }
        }

        /*
         * receive scores of other players
         */
        public Player[] receivePlayer() {
            Player[] pl = new Player[3];
            try {
                Player p = (Player) dIn.readObject();
                pl[0] = p;
                p = (Player) dIn.readObject();
                pl[1] = p;
                p = (Player) dIn.readObject();
                pl[2] = p;
                return pl;

            } catch (IOException e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("class not found");
                e.printStackTrace();
            }
            return pl;
        }

        /*
         * receive scores of other players
         */
        public int[] receiveScores() {
            try {
                int[] sc = new int[3];
                for (int j = 0; j < 3; j++) {

                    sc[j] = dIn.readInt();

                    System.out.println();
                }

                return sc;
            } catch (Exception e) {
                System.out.println("Score not received");
                e.printStackTrace();
            }
            return null;
        }
    }

    /*
     * ---------Constructor and Main class-----------
     */

    /*
     * constructor takes the name of the player and sets the score to 0
     */

    public static void main(String args[]) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("What is your name ? ");
        String name = myObj.next();
        Player p = new Player(name);
        p.connectToClient();
        p.startGame();
        p.returnWinner();
        myObj.close();
    }
}
