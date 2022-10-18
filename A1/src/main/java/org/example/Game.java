package org.example;

import java.util.Random;

public class Game {

    static FortuneCard[] fortuneDeck = {
            FortuneCard.TREASURECHEST,
            FortuneCard.TREASURECHEST,
            FortuneCard.TREASURECHEST,
            FortuneCard.TREASURECHEST,
            FortuneCard.SORCERESS,
            FortuneCard.SORCERESS,
            FortuneCard.SORCERESS,
            FortuneCard.SORCERESS,
            FortuneCard.CAPTAIN,
            FortuneCard.CAPTAIN,
            FortuneCard.CAPTAIN,
            FortuneCard.CAPTAIN,
            FortuneCard.MONKEYBUSINESS,
            FortuneCard.MONKEYBUSINESS,
            FortuneCard.MONKEYBUSINESS,
            FortuneCard.MONKEYBUSINESS,
            FortuneCard.DIAMOND,
            FortuneCard.DIAMOND,
            FortuneCard.DIAMOND,
            FortuneCard.DIAMOND,
            FortuneCard.GOLD,
            FortuneCard.GOLD,
            FortuneCard.GOLD,
            FortuneCard.GOLD,
            FortuneCard.SKULLX2,
            FortuneCard.SKULLX2,
            FortuneCard.SKULLX1,
            FortuneCard.SKULLX1,
            FortuneCard.SKULLX1,
            FortuneCard.SEABATTLEX2SWORDS,
            FortuneCard.SEABATTLEX2SWORDS,
            FortuneCard.SEABATTLEX3SWORDS,
            FortuneCard.SEABATTLEX3SWORDS,
            FortuneCard.SEABATTLEX4SWORDS,
            FortuneCard.SEABATTLEX4SWORDS};

    enum FortuneCard {
        TREASURECHEST,
        CAPTAIN,
        SORCERESS,
        GOLD,
        DIAMOND,
        MONKEYBUSINESS,
        SKULLX1,
        SKULLX2,
        SEABATTLEX2SWORDS,
        SEABATTLEX3SWORDS,
        SEABATTLEX4SWORDS
    }

    enum Dice {
        SKULL,
        DIAMOND,
        GOLD,
        SWORD,
        PARROT,
        MONKEY
    }
   public int scorePoints(Dice[] playerHand, FortuneCard fc){

        int[] numOfRepeats = {0,0,0,0,0,0}; //{skull,diamond,gold,sword,parrot,monkey}
        int score = 0;

       if(fc == FortuneCard.GOLD){
           numOfRepeats[2]++;
       }else if(fc == FortuneCard.DIAMOND){
           numOfRepeats[1]++;
       }

        for(int i = 0; i<playerHand.length; i++){
            if(playerHand[i] == Dice.DIAMOND){
                numOfRepeats[1]++;
            }else if(playerHand[i] == Dice.GOLD){
                numOfRepeats[2]++;
            }else if(playerHand[i] == Dice.SWORD){
                numOfRepeats[3]++;
            }else if(playerHand[i] == Dice.PARROT){
                numOfRepeats[4]++;
            }else if(playerHand[i] == Dice.MONKEY){
                numOfRepeats[5]++;
            }
        }

        if(fc == FortuneCard.MONKEYBUSINESS){
            numOfRepeats[4] += numOfRepeats[5];
            numOfRepeats[5] = 0;
        }

        int numOfDiceWithSet = 0;
        for(int j = 0; j<numOfRepeats.length; j++){

            if(numOfRepeats[j] == 8){
                score += 4000;
                numOfDiceWithSet += 8;

            }else if(numOfRepeats[j] == 7){
                score += 2000;
                numOfDiceWithSet += 7;

            }else if(numOfRepeats[j] == 6) {
                score += 1000;
                numOfDiceWithSet += 6;

            }else if(numOfRepeats[j] == 5){
                score += 500;
                numOfDiceWithSet += 5;

            }else if(numOfRepeats[j] == 4 ) {
                score += 200;
                numOfDiceWithSet += 4;

            }else if(numOfRepeats[j] == 3 ){
                score += 100;
                numOfDiceWithSet += 3;

            }
        }

        //add diamonds
        score += (numOfRepeats[1]*100);
        //add gold coins
        score += (numOfRepeats[2]*100);

       if( (numOfRepeats[2]==8 && fc == FortuneCard.GOLD) || (numOfRepeats[1]==8 && fc == FortuneCard.DIAMOND)){
           numOfDiceWithSet--;
       }

       if(numOfDiceWithSet == 8){
           score += 500;
       }

       if(fc == FortuneCard.CAPTAIN){
           score *= 2;
       }

        return score;
   }

    public Dice[] rollDice(Dice[] playerHand,Dice[] riggedHand){

        if(riggedHand.length == 0){

            for(int i = 0; i< playerHand.length; i++){
                if(playerHand[i] != null){

                    playerHand[i] = getRandomDie();

                }
            }
            return playerHand;

        }else{

            return riggedHand;
        }
    }

    public Dice[] sorceressReroll(Dice[] playerHand,Dice riggedDice){

        for(int i = 0; i< playerHand.length; i++){

            if(playerHand[i] == Dice.SKULL){

                if(riggedDice != null){
                    playerHand[i] = riggedDice;

                }else{
                    playerHand[i] = getRandomDie();
                }
                return playerHand;
            }

        }

        return playerHand;
    }

    public Dice getRandomDie(){

        int randomInt = new Random().nextInt(Dice.values().length);
        return Dice.values()[randomInt];

    }

    public static FortuneCard pickCard(FortuneCard riggedCard){

        if(riggedCard == null){
            int randomInt = new Random().nextInt(fortuneDeck.length);
            return fortuneDeck[randomInt];
        }else{
            return riggedCard;
        }

    }

    public boolean isContainSkull(Dice[] playerHand){

        for(int i = 0; i<playerHand.length; i++){
            if(playerHand[i] == Dice.SKULL){
                return true;
            }
        }

        return false;
    }

    //treasure chest
    //function that returns a dice array of dice saved
    public Dice[] getSavedDiceForTC(Dice[] playerHand,int[] savedDicePos){
        Dice[] saveDice = new Dice[savedDicePos.length];

        for(int i = 0; i<savedDicePos.length; i++){
            saveDice[i] = playerHand[savedDicePos[i]];
        }

        return saveDice;
    }

    //change skull to null or change saved dice to null
    public Dice[] changeDiceToNull(Dice[] playerHand,int[] savedDicePos){

        if(savedDicePos.length == 0 ){
            for(int i = 0; i< playerHand.length;i++){
                if(playerHand[i] == Dice.SKULL){
                    playerHand[i] = null;
                }
            }

        }else{
            for(int i = 0; i<savedDicePos.length; i++){
                playerHand[savedDicePos[i]] = null;

            }
        }

        return playerHand;
    }

    //for changing savedDice that are null back to dice
    public Dice[] changeNullToDice(Dice[] playerHand,int[] savedDicePos,Dice[] savedDice){

        for(int i = 0; i<savedDicePos.length; i++){
            playerHand[savedDicePos[i]] = savedDice[i];
        }

        return playerHand;
    }
    public int didDie(Dice[] playerHand,FortuneCard fc){
        //-1: dead, 0: island of dead, 1: alive

        int numSkull = calcNumSkull(playerHand);
        if(fc == FortuneCard.SKULLX1){
            numSkull++;
        }else if( fc == FortuneCard.SKULLX2){
            numSkull += 2;
        }

        if(fc == FortuneCard.SEABATTLEX3SWORDS || fc == FortuneCard.SEABATTLEX2SWORDS || fc == FortuneCard.SEABATTLEX4SWORDS){
            if(numSkull >= 3){
                return -1;
            }else{
                return 1;
            }
        }else {
            if(numSkull == 3){
                return -1;
            }else if ( numSkull > 3){
                return 0;
            }else{
                return 1;
            }

        }
    }

    public int calcNumSkull(Dice[] playerHand){
        int numSkull = 0;

        for( int i =0; i<playerHand.length; i++){
            if( playerHand[i] == Dice.SKULL){
                numSkull++;
            }
        }
        return numSkull;
    }

    public int getWinnerIndex(int[] playerScores){

        int currHighestIndex = 0;
        for(int i = 1; i< playerScores.length; i++){
            if(playerScores[i]>= playerScores[currHighestIndex]){
                currHighestIndex = i;
            }
        }

        return currHighestIndex;

    }

    public boolean didReachWinThreshold(int winScore, int[] playerScores){
        for( int i = 0;i<playerScores.length;i++ ){
            if(playerScores[i]>=winScore){
                return true;
            }
        }
        return false;
    }

    // for skull island point deduction
    public int getScoreDeduction(int numSkull,FortuneCard fc){

        if(fc == FortuneCard.CAPTAIN){
            return -(numSkull*100)*2;
        }else{
            return -(numSkull*100);
        }

    }

    //reducer should be negative number and would never be positive
    public int[] reducePlayersScore(int reducer, int[] playerScores){

        for(int i = 0; i<playerScores.length; i++){

            if(playerScores[i]+reducer < 0) {
                playerScores[i] = 0;
            }else{
                playerScores[i] += reducer;
            }

        }

        return playerScores;

    }

    public boolean didWinSeaBattle(Dice[] playerHand,FortuneCard fc){

        if(didDie(playerHand,fc) == -1){
            return false;
        }

        int numSword = 0;

        for(int i = 0; i < playerHand.length; i++){
            if( playerHand[i] == Dice.SWORD ){
                numSword++;
            }
        }


        if( (fc == FortuneCard.SEABATTLEX2SWORDS && numSword >= 2) || (fc == FortuneCard.SEABATTLEX3SWORDS && numSword >=3) || (fc == FortuneCard.SEABATTLEX4SWORDS && numSword >= 4)){
            return true;
        }else{
            return false;
        }

    }

    public int scoreSeabattle(Dice[] playerHand,FortuneCard fc){

        if(fc == FortuneCard.SEABATTLEX2SWORDS){
            if(didWinSeaBattle(playerHand,fc) == true){
                return 300 + scorePoints(playerHand,fc);
            }else{
                return -300;
            }
        }else if (fc == FortuneCard.SEABATTLEX3SWORDS){
            if(didWinSeaBattle(playerHand,fc) == true){
                return 500 + scorePoints(playerHand,fc);
            }else{
                return -500;
            }
        }else{
            if(didWinSeaBattle(playerHand,fc) == true){
                return 1000 + scorePoints(playerHand,fc);
            }else{
                return -1000;
            }
        }
    }

    public void printPlayerRole(Dice[] playerHand){
        String roll = "|----["+playerHand[0]+"]----["+playerHand[1]+"]----["+playerHand[2]+"]----["+playerHand[3]+"]----["+playerHand[4]+"]----["+playerHand[5]+"]----["+playerHand[6]+"]----["+playerHand[7]+"]----|";
        String border = "_".repeat(roll.length()) + "\n";
        System.out.println(border);
        System.out.println(roll);
        System.out.println(border);
    }

    public void printPlayerScore(int[] playerScore){
        String border = "_".repeat(31)+"\n";
        System.out.println(border);
        for( int i = 0;i<playerScore.length;i++){
            System.out.printf("---- Player %d Score: %5d ----\n",i+1,playerScore[i]);
        }
        System.out.println(border);
    }

    public void printStatus(String status){
        String start = " turn started";
        String died = " has died";
        String deduct = "'s score has been deducted by " + status;
        String skull = " has gone to Island Of the Dead";
        String end = " turn ended";
        String won = " has won!";
        String seaBattle = " is in a SeaBattle";

        String condition;
        if(status.equals("start")){
            condition = start;
        }else if(status.equals("died")){
            condition = died;
        }else if(status.equals("won")){
            condition = won;
        }else if(status.equals("skull")){
            condition = skull;
        }else if(status.equals("end")){
            condition = end;
        }else if(status.equals("seaBattle")) {
            condition = seaBattle;
        }else {
            condition = deduct;
        }

        String situation = "---- Player" + condition + " ----\n";
        String border = "_".repeat(situation.length()-1) + "\n";

        System.out.print(border);
        System.out.print(situation);
        System.out.print(border);
    }
}
