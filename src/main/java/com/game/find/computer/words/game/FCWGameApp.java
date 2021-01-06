package com.game.find.computer.words.game;

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
        int nRounds;
        String p1Word, p2Word;
        double p1Points, p2Points, p1Total, p2Total;
        String Winner;
        
        /* DECLARE AND CREATE OBJECTS */
        FCWGame fcwg = new FCWGame();
        
        
        /* INPUT */
        nRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of rounds you would like to play: "));
        //This loop allows the user to enter the amount of rounds they want to play
        for (int r = 0; r < nRounds; r = r + 1){
            
        }
        
        /* OUTPUT */
        System.out.println(fcwg.getRLetter());
    }
    
}
