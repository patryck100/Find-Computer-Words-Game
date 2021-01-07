/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.find.computer.words.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class FCWGame {
    
    /* DATA MEMBERS */
    private int nRounds;
    private String p1Word;
    private String p2Word;
    private double p1Points, p2Points;
    private double p1Total, p2Total;
    //private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String [] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String [] validWords = {"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus", "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development",
        "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online",
        "path", "process", "protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue", "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"};
    private String [] rLetters;
    //private StringBuffer rLetter;
    private ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(validWords));
    private ArrayList<String> randomLetters = new ArrayList<String>(Arrays.asList(rLetters));
    
    /* --- CONSTRUCTOR ---*/
    
    
    public FCWGame() {
        nRounds = 0;
        p1Word = "";
        p2Word = "";
        p1Points = 0.0;
        p2Points = 0.0;
        p1Total = 0.0;
        p2Total = 0.0;
        rLetters = new String [12];
        //rLetter = new StringBuffer();
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(validWords));
        ArrayList<String> randomLetters = new ArrayList<String>(Arrays.asList(rLetters));
    }

    /*--- SETTERS ---*/

    public void setnRounds(int nRounds) {
        this.nRounds = nRounds;
    }

    public void setP1Word(String p1Word) {
        this.p1Word = p1Word;
    }

    public void setP2Word(String p2Word) {
        this.p2Word = p2Word;
    }
    
    /*--- PROCESS --- */
    public void computeP1(){
        if (wordList.contains(p1Word)){
            
            for (int nLetters = 0; nLetters < p1Word.length(); nLetters++){
                if (randomLetters.contains(p1Word.charAt(nLetters))){
                    JOptionPane.showMessageDialog(null, "It is working :)");
                } else {
                    JOptionPane.showMessageDialog(null, "Nop, not this time");
                }
            }
                if(p1Word.contains("a") && p1Word.contains("e")){
                    JOptionPane.showMessageDialog(null, "That is a valid word, you got 2.5 points");
                    p1Points = 2.5;
                } else{
                    p1Points = p1Word.length();
                    JOptionPane.showMessageDialog(null, "That is a valid word, you got " + p1Points + " points");
                }          
        }else {
            JOptionPane.showMessageDialog(null, "no points");
        }
        
    }
    
    public void computeP2(){
        if (wordList.contains(p2Word)){
            if (!p2Word.equals(p1Word)){
                JOptionPane.showMessageDialog(null, "Valid word :)");
            }else {
                JOptionPane.showMessageDialog(null, "Sorry, you can not use the same word as Player 1. No points for you :/");
            }
        }else {
            JOptionPane.showMessageDialog(null, "no points");
        }
        
    }    
    
       
    
    /*--- GETTERS --- */

    /* Generates 12 letters */
    public String[] getrLetters() {
        for (int i = 0; i < 12; i++){
            rLetters[i] = alphabet[(int)(Math.random()*26)];
        }
        return rLetters;
    }

    //first attempt, I couldn't check if the letters matched with the words made by the players
    /* Generates 12 letters */ 
    /*public String getRLetter(){
        rLetter = new StringBuffer();
        for (int i = 0; i < 12; i++){
                int randomL = (int)(Math.random()*26);
            if (i<11){
                rLetter.append(alphabet.charAt(randomL) + " ");
            }else {
                rLetter.append(alphabet.charAt(randomL) + ".");
            }
        }
        rLetter.append("Elmlaaiela");
        return rLetter.toString();
    } */

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
