package com.game.find.computer.words.game;

import java.util.Arrays;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author patry
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
        String Winner;
        String[] letters = new String[12];
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
        
        //This loop allows the user to enter the amount of rounds they want to play
        for (int r = 0; r < nRounds; r = r + 1){
            letters = fcwg.getrLetters();
            fcwg.setP1Points(p1Points);                 
            round++;
            fcwg.setnRounds(round);
            
            JOptionPane.showMessageDialog(null, "Make a valid word by using only those letters once each: " + Arrays.toString(letters));
            p1Word = JOptionPane.showInputDialog(null, "Please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(letters));
            fcwg.setP1Word(p1Word);
            p1Points = fcwg.getP1Points();
            p2Word = JOptionPane.showInputDialog(null, "Please enter your word for round " + (r+1) +
                                                                "\nLetters: " + Arrays.toString(letters) +
                                                                "\nYour are not allowed to use the word: " + p1Word);
            fcwg.setP2Word(p2Word);
            p2Points = fcwg.getP2Points();
            
            
            
            
            
        }
        
        /* PROCESS */
        
        
        
        /* OUTPUT */
        
    }
    
}
