package com.game.find.computer.words.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Patryck Brenner
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
    private char [] rLetters;
    private char [] p1RLetters;
    private char [] p2RLetters;
    private String winner;
    private String newConfirmP1;
    private String newConfirmP2;    
    private StringBuffer confirmP1;
    private StringBuffer confirmP2;
    
    //constant
    private final char [] alphabet;
    private final String [] validWords;    
    private final ArrayList<String> wordList;
    
    /* --- CONSTRUCTOR ---*/
    public FCWGame() {
        this.validWords = new String[]{"algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug", "binary", "browser", "bus", "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress", "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development", "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics", "hyperlink", "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword", "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor", "multimedia", "network", "node", "offline", "online", "path", "process", "protocol", "password", "phishing", "platform", "program", "portal", "privacy", "programmer", "queue", "resolution", "root", "restore", "router", "reboot", "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot", "server", "script", "software", "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus", "web", "website", "window", "wireless"};
        this.alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        this.nRounds = nRounds;
        this.p1Word = p1Word;
        this.p2Word = p2Word;
        this.p1Points = p1Points;
        this.p2Points = p2Points;
        p1Total = 0.0;
        p2Total = 0.0;
        rLetters = new char [12];
        p1RLetters = p1RLetters;
        p2RLetters = p2RLetters;
        confirmP1 = new StringBuffer();
        newConfirmP1 = "";
        confirmP2 = new StringBuffer();
        newConfirmP2 = "";        
        wordList = new ArrayList<String>(Arrays.asList(validWords));
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
    
    /*--- COMPUTE --- */
    
    // Generates 12 random letters
    public void computeRLetters(){
        // Pick 1 by 1 random letter from the Array "Alphabet" 12 times and insert into "rLetters" Array
        for (int i = 0; i < 12; i++){
            rLetters[i] = alphabet[(int)(Math.random()* alphabet.length)];
        }// end of loop
        
        //Method used to test if the input from the user would match with the letters given by the computer
        /*rLetters [0] = 'E';
        rLetters [1] = 'I';
        rLetters [2] = 'N';
        rLetters [3] = 'M';
        rLetters [4] = 'A';
        rLetters [5] = 'I';
        rLetters [6] = 'P';
        rLetters [7] = 'L';
        rLetters [8] = 'T';
        rLetters [9] = 'C';
        rLetters [10] = 'O';
        rLetters [11] = 'N';*/  
    } // end of computeRLetters
    
    //Calculates points for the player 1
    public void computeP1Points(){
        
        // Makes sure every time compute method is used, it generates a new StringBuffer
        confirmP1 = new StringBuffer();
        
        //It makes a copy of the 12 random letters 
        char [] p1RLetters = Arrays.copyOf(rLetters, rLetters.length);
        
        //Check player 1 input letter by letter
        for (int r = 0; r < p1Word.length(); r++){
            for (int s = 0; s < p1RLetters.length; s++){
                if (p1Word.toUpperCase().charAt(r) == p1RLetters[s]){
                    //The letters that matches with the 12 random letters are copied to a StringBuffer
                    confirmP1.append(p1Word.charAt(r));
                    //To avoid one letter to be used more than once, the letter already used is replaced by '-' (line 121)
                    p1RLetters[s] = '-';
                    break;
               }
            }
        } // end of loop
        
        // Method used to test if the letters already used are being replaced by '-' (check line 121)
        System.out.println(Arrays.toString(rLetters));
        System.out.println(Arrays.toString(p1RLetters));
        
        //Output which letters given by the player 1 matches with the 12 random letters
        newConfirmP1 = confirmP1.toString();
        System.out.println(newConfirmP1);
        
        // If the word given by the player 1 matches with the 12 letters it goes to the next if Statement, else, 0 points are summed to player 1 
        if (p1Word.equalsIgnoreCase(newConfirmP1)){
                //Validates the word with the list of valid words
                if (wordList.contains(p1Word.toLowerCase())){
                    //if the word contains 'a' and 'e' it sum 2.5 points to player 1, else, it gives point according to the number of character in the word.
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
        }//end of if statements
        
        //calculates total points for player 1
        for (int r = 0; r < p1Points.length; r = r + 1){  
            p1Total = p1Total + p1Points[nRounds-1];
            break;
        }//end of loop        
    }
    
    //Calculates points for the player 2
    public void computeP2Points(){
        // Makes sure every time compute method is used, it generates a new StringBuffer
        confirmP2 = new StringBuffer();
        
        //It makes a copy of the 12 random letters 
        char [] p2RLetters = Arrays.copyOf(rLetters, rLetters.length);
        
        //Check player 2 input letter by letter
        for (int r = 0; r < p2Word.length(); r++){
            for (int s = 0; s < p2RLetters.length; s++){
                if (p2Word.toUpperCase().charAt(r) == p2RLetters[s]){
                    //The letters that matches with the 12 random letters are copied to a StringBuffer
                    confirmP2.append(p2Word.charAt(r));
                    //To avoid one letter to be used more than once, the letter already used is replaced by '-' (line 177)
                    p2RLetters[s] = '-';
                    break;
               }
            }
        }//end of loop
        
        // Method used to test if the letters already used are being replaced by '-' (check line 177)
        System.out.println(Arrays.toString(rLetters));        
        System.out.println(Arrays.toString(p2RLetters));
        
        //Output which letters given by the player 2 matches with the 12 random letters
        newConfirmP2 = confirmP2.toString();
        System.out.println(newConfirmP2);
        
        // If the word given by the player 2 matches with the 12 letters it goes to the next if Statement, else, 0 points are summed to player 2
        if (p2Word.equalsIgnoreCase(newConfirmP2)){  
                //Validates the word with the list of valid words
                if (wordList.contains(p2Word.toLowerCase())){
                    //if the word is different from the word given by player 1, it continuos with the if statements, else, 0 points are summed to player 2
                    if (!p2Word.equals(p1Word)){
                        //if the word contains 'a' and 'e' it sum 2.5 points to player 2, else, it gives point according to the number of character in the word.
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
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, the word '" + p2Word + "' is not a valid word. You got " + p2Points[nRounds-1] + " points for the round: " + (nRounds));             
        }// end of if statments
        
        //calculates total points for player 2
        for (int r = 0; r < p2Points.length; r = r + 1){  
            p2Total = p2Total + p2Points[nRounds-1];
            break;
        } // end of loop        
    }
    
    // Compute the winner (who has more points)
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

    public char[] getRLetters() {
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

    @Override
    public String toString() {
        return  "Player 1 has" + p1Total + " points" +
                "\nPlayer 2 has" + p2Total + "points" +
                "\n" + winner;
    }
    
    
    
    
    
}
