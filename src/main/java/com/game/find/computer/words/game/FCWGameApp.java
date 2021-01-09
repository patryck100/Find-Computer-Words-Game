package com.game.find.computer.words.game;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Patryck Brenner
 */
public class FCWGameApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* --------- DATA MEMBERS --------- */
        int nRounds = 0;
        String p1Word, p2Word;
        double[] p1Points, p2Points;
        double p1Total, p2Total;
        char [] rLetters;
        int round = 0;
        
        /* --- DECLARE AND CREATE OBJECTS --- */
        FCWGame fcwg = new FCWGame();

        
        /* --- INTRODUCTION TO THE USER --- */
        JOptionPane.showMessageDialog(null, "Hi, this is a 2 players 'find computer words game'.\nIn a nutshell, you will have to use letters given by the computer to make your own. "
                + "\nThere are some rules like: you can only use each of the 12 letters given once.\nYou also CAN NOT repeat a word made by the other player.\nYOUR WORD MUST BE VALID IN ORDER"
                + " TO GET POINTS.");
        JOptionPane.showMessageDialog(null, "For this game, IF your word DOES NOT CONTAIN both the letters 'a' and 'e',\nyou will receive the same amount"
                + " of point as the number of \ncharacters in your word (e.g. filE = 4 points), otherwise \n2.5 points (e.g. kEyboArd = 2.5 points).\nAre you ready?");
        
        /* ------------ INPUT ------------ */
        
        //Collects the number of rounds choosen by the user
        nRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of rounds you would like to play: "));
        p1Points = new double [nRounds];
        p2Points = new double [nRounds];
        
        //This loop allows the user to play the amount of rounds they set before
        for (int r = 0; r < nRounds; r = r + 1){
            //compute the 12 letters
            fcwg.computeRLetters();
            //set values of the 12 letters to variable rLetters
            rLetters = fcwg.getrLetters();
            
            //set size to the Arrays "Points" according to the number of rounds
            fcwg.setP1Points(p1Points);
            fcwg.setP2Points(p2Points);
            
            //keeps track of each round the user is
            round++;
            fcwg.setnRounds(round);
            
            
            JOptionPane.showMessageDialog(null, "Round " + (r+1) + ", please make a valid word using those letters only once each: " + Arrays.toString(rLetters));
            p1Word = JOptionPane.showInputDialog(null, "Player 1, please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(rLetters));
            //collect the word given by the user and calculate its points
            fcwg.setP1Word(p1Word);
            fcwg.computeP1Points();
            
            p2Word = JOptionPane.showInputDialog(null, "Player 2, please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(rLetters) +
                                                                "\nYour are not allowed to use the word: " + p1Word);
            //collect the word given by the user and calculate its points
            fcwg.setP2Word(p2Word);
            fcwg.computeP2Points();
            
            //compute who the winner is
            fcwg.computeWinner();
            
            /* ------------ OUTPUT ------------ */
            
            //if it reaches the last round, outputs the result to the user
            if (round == nRounds){   
                JOptionPane.showMessageDialog(null, fcwg.toString());
            }
            
            
            
            
        }// end of loop
  
    }
    
}
