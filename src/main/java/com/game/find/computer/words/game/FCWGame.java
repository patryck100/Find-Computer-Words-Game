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
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String [] validWords = {"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus", "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development",
        "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online",
        "path", "process", "protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue", "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"};
    private StringBuffer rLetter;
    private ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(validWords));
    
    
    /* --- CONSTRUCTOR ---*/
    
    
    public FCWGame() {
        nRounds = 0;
        p1Word = "";
        p2Word = "";
        p1Points = 0.0;
        p2Points = 0.0;
        p1Total = 0.0;
        p2Total = 0.0;
        rLetter = new StringBuffer();
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(validWords)); 
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
        if (wordList.contains(p1Word.toLowerCase())){
          for (int nLetters = 0; nLetters < p1Word.length(); nLetters++){

          }  
            if(p1Word.contains("a") && p1Word.contains("e")){
                  JOptionPane.showMessageDialog(null, "That is a valid word, you got 2.5 points");
                  p1Points = 2.5;
            } else{
                  p1Points = p1Word.length();
            }
                               
        }else {
            JOptionPane.showMessageDialog(null, "no points");
        }
        
    }
    
    public void computeP2(){
        if (wordList.contains(p2Word.toLowerCase())){
         JOptionPane.showMessageDialog(null, "Valid word :)");                      
        }else {
            JOptionPane.showMessageDialog(null, "no points");
        }
        
    }    
    
       
    
    /*--- GETTERS --- */
    
    /* Generates 12 letters */ 
    public String getRLetter(){
        rLetter = new StringBuffer();
        for (int i = 0; i < 12; i++){
                int randomL = (int)(Math.random()*26);
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
