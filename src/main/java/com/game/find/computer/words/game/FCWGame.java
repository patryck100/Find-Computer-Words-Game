/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.find.computer.words.game;

/**
 *
 * @author patry
 */
public class FCWGame {
    
    /* DATA MEMBERS */
    
    private String p1Word;
    private String p2Word;
    private double p1Points = 0.0, p2Points = 0.0;
    private double p1Total = 0.0, p2Total = 0.0;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private StringBuffer rLetter;

    //CONSTRUCTOR
    
    
    public FCWGame() {
        p1Word = "";
        p2Word = "";
        p1Points = 0.0;
        p2Points = 0.0;
        rLetter = new StringBuffer();
    }

    /*--- SETTERS ---*/
    
    
    public void setP1Word(String p1Word) {
        this.p1Word = p1Word;
    }

    public void setP2Word(String p2Word) {
        this.p2Word = p2Word;
    }
    
    public void compute(){
        
    }
    
       
    
    /*--- GETTERS --- */
    
    /* Generates 12 letters */ 
    public String getRLetter(){
        for (int i = 0; i < 12; i++){
                int randomL = (int)(Math.random()*26) +  1;
            if (i<11){
                rLetter.append(alphabet.charAt(randomL) + ", ");
            }else {
                rLetter.append(alphabet.charAt(randomL) + ".");
            }
        }
        return rLetter.toString();
    }

    public double getP1Points() {
        return p1Points;
    }

    public double getP2Points() {
        return p2Points;
    }

    public double getP1Total() {
        return p1Total;
    }

    public double getP2Total() {
        return p2Total;
    }
    
    
    
    
    
}
