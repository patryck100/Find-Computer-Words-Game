package com.game.find.computer.words.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author patryck brenner
 */
public class FCWGame {
    
    /*--- DATA MEMBERS ---*/
    
    //variables
    private int nRounds;
    private String p1Word;
    private String p2Word;    
    private double [] p1Points;
    private double [] p2Points;
    private double p1Total, p2Total;
    private String [] rLetters;
    private ArrayList<String> rdmLetters;
    private String winner;
    private StringBuffer confirmP1;
    private StringBuffer confirmP2;
    
    //constant
    private final String [] alphabet;
    private final String [] validWords;    
    private final ArrayList<String> wordList;
    
    /* --- CONSTRUCTOR ---*/
    public FCWGame() {
        this.validWords = new String[]{"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus", "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development", "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online", "path", "process", "protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue", "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"};
        this.alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.nRounds = nRounds;
        this.p1Word = p1Word;
        this.p2Word = p2Word;
        this.p1Points = p1Points;
        this.p2Points = p2Points;
        p1Total = 0.0;
        p2Total = 0.0;
        rLetters = new String [12];
        confirmP1 = new StringBuffer();
        confirmP2 = new StringBuffer();
        wordList = new ArrayList<String>(Arrays.asList(validWords));
        rdmLetters = new ArrayList<String>(Arrays.asList(rLetters));
        winner = winner;
    }

    
    /*--- SETTERS ---*/

    public void setP1Points(double[] p1Points) {        
        this.p1Points = p1Points;
    }

    public void setP2Points(double[] p2Points) {         
        this.p2Points = p2Points;
    }
    
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
    public void computeRLetters(){
        //for (int i = 0; i < 12; i++){
          //  rLetters[i] = alphabet[(int)(Math.random()*26)];
        //}
        rLetters [0] = "A";
        rLetters [1] = "A";
        rLetters [2] = "M";
        rLetters [3] = "E";
        rLetters [4] = "L";
        rLetters [5] = "I";
        rLetters [6] = "P";
        rLetters [7] = "T";
        rLetters [8] = "J";
        rLetters [9] = "C";
        rLetters [10] = "M";
        rLetters [11] = "N";
        
    }
    
    public void computeP1Points(){
        //confirmP1 = new StringBuffer();
        //for (int r = 1; r <= p1Word.length(); r++){
          //  for (int s = 0; s < rLetters.length; s++){
            //    if (p1Word.charAt(r) == rdmLetters.toString().charAt(s)){
              //      confirmP1.append(p1Word.charAt(r));
                //    break;
                //}
           // }
        //}
        if (rdmLetters.contains(p1Word.toUpperCase())){
                if (wordList.contains(p1Word.toLowerCase())){
                    if(p1Word.contains("a") && p1Word.contains("e")){
                        p1Points[nRounds-1] = 2.5;
                        JOptionPane.showMessageDialog(null, "The word '" +p1Word + "' is a valid word, you got " + p1Points[nRounds-1] + " points for the round: " + (nRounds));
                    }else {
                        p1Points[nRounds-1] = p1Word.length();
                        JOptionPane.showMessageDialog(null, "The word '" +p1Word + "' is a valid word, you got " + p1Points[nRounds-1] + " points for the round: " + (nRounds));
                    }
                }   else {
                    p1Points[nRounds-1] = 0.0;
                    JOptionPane.showMessageDialog(null, "Sorry, the word '" + p1Word + "' is not a valid word. You got " + p1Points[nRounds-1] + " points for the round: " + (nRounds)); 
                }        
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, the word '" + p1Word + "' is not a valid word. You got " + p1Points[nRounds-1] + " points for the round: " + (nRounds)); 
        } 
            for (int r = 0; r < p1Points.length; r = r + 1){  
                p1Total = p1Total + p1Points[nRounds-1];
                break;
            }        
    }
    public void computeP2Points(){
            if (wordList.contains(p2Word.toLowerCase())){
                if (!p2Word.equals(p1Word)){
                    if(p2Word.contains("a") && p2Word.contains("e")){
                        p2Points[nRounds-1] = 2.5;
                        JOptionPane.showMessageDialog(null, "The word '" +p2Word + "' is a valid word, you got " + p2Points[nRounds-1] + " points for the round: " + (nRounds));
                    } else {
                        p2Points[nRounds-1] = p2Word.length();
                        JOptionPane.showMessageDialog(null, "The word '" +p2Word + "' is a valid word, you got " + p2Points[nRounds-1] + " points for the round: " + (nRounds));
                   }
                }else {
                    p2Points[nRounds-1] = 0.0;
                    JOptionPane.showMessageDialog(null, "Sorry, player 1 is already using the word '" + p2Word +  "', you got " + p2Points[nRounds-1] + " points for the round: " + (nRounds));
                }
            } else {
                p2Points[nRounds-1] = 0.0;
                JOptionPane.showMessageDialog(null, "Sorry, the word '" + p2Word + "' is not a valid word. You got " + p2Points[nRounds-1] + " points for the round: " + (nRounds));
            }  
        for (int r = 0; r < p2Points.length; r = r + 1){  
            p2Total = p2Total + p2Points[nRounds-1];
            break;
        }
    }

    public void computeWinner(){ 
        if (nRounds <= p2Points.length){
            if(p1Total > p2Total){
                winner = "The winner is player 1 with: " + p1Total + " points";
            }else if (p1Total == p2Total) {
                winner = "That is a draw with " + p1Total + " points each"; 
            } else {
                winner = "The winner is player 2 with: " + p2Total + " points";
            }
        }else {
            JOptionPane.showMessageDialog(null, "Player 1 has" + p1Total + " points" +
                                                "\nPlayer 2 has" + p2Total + "points");
        }
        
    }    
    
       
    
    /*--- GETTERS --- */

    /* Generates 12 letters */
    public String[] getrLetters() {
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

    public double[] getP1Points() {     
        return p1Points;
    }

    public double[] getP2Points() {         
        return p2Points;
    }

    public double getP1Total() {
        return p1Total;
    }

    public double getP2Total() {      
        return p2Total;
    }

    @Override
    public String toString() {
        return  "Player 1 has" + p1Total + " points" +
                "\nPlayer 2 has" + p2Total + "points" +
                "\n" + winner;
    }
    
    
    
    
    
}
