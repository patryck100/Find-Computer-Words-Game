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
        
        /* DATA MEMBERS */
        int nRounds = 0;
        String p1Word, p2Word;
        double[] p1Points, p2Points;
        double p1Total, p2Total;
        char [] rLetters;
        //String rLetter;
        int round = 0;
        
        /* DECLARE AND CREATE OBJECTS */
        FCWGame fcwg = new FCWGame();

        
        /* INTRODUCTION TO THE USER */
        JOptionPane.showMessageDialog(null, "Hi, this is a 2 players 'find computer words game'.\n In a nutshell, you will have to use letters given by the computer to make your own. "
                + "\nThere are some rules like: you can only use each of the 12 letters given once.\n You also can not repeat a word made by the other player.\n YOUR WORD MUST BE VALID IN ORDER"
                + " \nTO GET POINTS.");
        JOptionPane.showMessageDialog(null, "For this game, IF your word DOES NOT CONTAIN both the letters 'a' and 'e', you will receive the same amount"
                + "\n of point as the number of characters in your word (e.g. filE = 4 points),\n otherwise 2.5 points (e.g. kEyboArd = 2.5 points).\n Are you ready?");
        
        /* INPUT */
        nRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of rounds you would like to play: "));
        p1Points = new double [nRounds];
        p2Points = new double [nRounds];
        
        //This loop allows the user to play the amount of rounds they set before
        for (int r = 0; r < nRounds; r = r + 1){
            fcwg.computeRLetters();
            rLetters = fcwg.getrLetters();
            //rLetter = fcwg.getrLetter();
            fcwg.setP1Points(p1Points);
            fcwg.setP2Points(p2Points);
            round++;
            fcwg.setnRounds(round);
            
            
            JOptionPane.showMessageDialog(null, "Round " + (r+1) + ", please make a valid word using those letters only once each: " + Arrays.toString(rLetters) /*rLetter*/);
            p1Word = JOptionPane.showInputDialog(null, "Please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(rLetters) /*rLetter*/);
            fcwg.setP1Word(p1Word);
            fcwg.computeP1Points();
            
            p2Word = JOptionPane.showInputDialog(null, "Please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(rLetters) /*rLetter*/ +
                                                                "\nYour are not allowed to use the word: " + p1Word);
            fcwg.setP2Word(p2Word);
            fcwg.computeP2Points();
            fcwg.computeWinner();
            
            /* OUTPUT */
            if (round == nRounds){   
                JOptionPane.showMessageDialog(null, fcwg.toString());
            }
            
            
            
            
        }// end of loop
        

        
        
        
        
        
    }
    
}
