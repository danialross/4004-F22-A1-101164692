package org.example;


import java.util.ArrayList;

public class Game {

    enum FortuneCard {
        TREASURECHEST,
        CAPTAIN,
        SORCERESS,
        SEABATTLE,
        GOLD,
        DIAMOND,
        MONKEYBUSINESS,
        SKULLX1,
        SKULLX2,
        SWORDX2,
        SWORDX3,
        SWORDX4
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
            if(playerHand[i] == Dice.SKULL){
                numOfRepeats[0]++;
            }else if(playerHand[i] == Dice.DIAMOND){
                numOfRepeats[1]++;
            }else if(playerHand[i] == Dice.GOLD){
                numOfRepeats[2]++;
            }else if(playerHand[i] == Dice.SWORD){
                numOfRepeats[3]++;
            }else if(playerHand[i] == Dice.PARROT){
                numOfRepeats[4]++;
            }else{ // Monkey
                numOfRepeats[5]++;
            }
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


}
