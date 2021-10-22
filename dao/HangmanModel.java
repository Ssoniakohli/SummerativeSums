/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangman.dao;

import java.util.ArrayList;

/**
 *
 * @author HP
 */

public class HangmanModel {

        public String strAbstractWord; 					//the word to be guessed
	public int nRemainingGuesses;					//number of guesses left
	public int nLettersRemaining;					//number of letters the player needs to guess to solve the word
	public char[] cCurrentWordChars;
	public ArrayList<Character> cLettersGuessed;	
	
	public final int NUM_LEGAL_CHARS = 27;	
	public final int PADDING = 5;	
	public final String ALREADY_GUESSED_ALERT = "You have already tried that letter!";
	public final String SUCCESSFUL_GUESS_ALERT = "YES!";
	public final String FAILED_GUESS_ALERT = "nope";
	
	 public HangmanModel(String strAbstractWord, int nGuesses){
		
		this.strAbstractWord = strAbstractWord.toUpperCase();
		this.nRemainingGuesses = nGuesses;
		this.nLettersRemaining = strAbstractWord.length();
		this.cLettersGuessed = new ArrayList<Character>(NUM_LEGAL_CHARS + PADDING);
		this.cCurrentWordChars = new char[strAbstractWord.length()];
		
		//set the current word to "_ _ _....."
		for (int nC= 0; nC < cCurrentWordChars.length; nC++) cCurrentWordChars[nC] = '_';
		
	}
	/**
	 * represents a player guessing a letter
	 * updates the state of the game based on the player's guess:
	 * 		number of guesses remaining
	 * 		number of letters remaining
	 * 		current word
	 * 		letters guessed
	 * 
	 * GAME LOGIC:
	 * 		if the letter guessed is not in the word AND has not already been guessed, decrement the number of guesses
	 * 		if the letter guessed is in the word AND has not already been guessed, update the game state and do NOT decrement the number of guesses
	 * 		no penalty for guessing the same letter multiple times
	 * @param cLetter - the character guessed by the user
	 * @return true if (the game is not over AND guessed letter was in the word) false otherwise
	 */
	public String makeGuess(char cLetter){
		
		String strMessage;
		
		//have we guessed this letter before?
		if(isLetterInWord(cLetter, this.cLettersGuessed)){
			//we have guessed the letter before
			strMessage = ALREADY_GUESSED_ALERT;
		}
		else{	//we have NOT guessed the letter before
			
			//the letter is in the secret word
			if(isLetterInWord(cLetter, this.strAbstractWord)){
				updateCurrentWord(cLetter);
				updateLettersGuessed(cLetter);
				strMessage = SUCCESSFUL_GUESS_ALERT;
			}
			else{	//the letter is NOT in the Abstract word
				
				this.nRemainingGuesses--;
				updateLettersGuessed(cLetter);
				strMessage = FAILED_GUESS_ALERT;
			}
		}
		
		return strMessage;
		
	}//end makeGuess
	
	public boolean isWin(){return this.nRemainingGuesses > 0 && this.nLettersRemaining <= 0;}
	
	
	public boolean isLoss(){return this.nRemainingGuesses <= 0 && this.nLettersRemaining > 0;}

	/**
	 * if the letter guessed has not already been stored, store it
	 * @param cLetter - letter guessed
	 */
	private void updateLettersGuessed(char cLetter) {
		if(!isLetterInWord(cLetter, this.cLettersGuessed)) this.cLettersGuessed.add(cLetter);
	}//end updateLettersGuessed



	/**
	 * update the current word to reflect the guess
	 * method also responsible for updating the number of letters remaining
	 * @param cLetter
	 */
	private void updateCurrentWord(char cLetter) {
		for (int nC = 0; nC < this.cCurrentWordChars.length; nC++){
			if(this.strAbstractWord.charAt(nC) == cLetter){
				this.cCurrentWordChars[nC] = cLetter;
				this.nLettersRemaining--;
			}
		}
        }


	/**
	 * linear search algorithm to identify if a char key is in a char array, inefficient algorithm is fine
	 * as we expect the character array (word) to be short
	 * @param cLetter - the key
	 * @param cWord - the list
	 * @return true if found, false otherwise
	 */
	private boolean isLetterInWord(char cLetter, ArrayList<Character> cWord) {
		 
		for (int nC = 0; nC < cWord.size(); nC++) if(cWord.get(nC) == cLetter) return true;
		
		return false;
		
	}//end isLetterInWord
	
	
	/**
	 * 
	 * @param cLetter - the key
	 * @param strWord - the word
	 * @return true if found, false otherwise
	 */
	private boolean isLetterInWord(char cLetter, String strWord) {return strWord.indexOf(cLetter) >= 0;}
        /**
	 * @return the secret word
	 */
	public String getSecretWord(){return this.strAbstractWord;}
	
	
	/**
	 * @return the number of guesses remaining
	 */
	public int getNumGuessesLeft(){return this.nRemainingGuesses;}	
	
	
	/**
	 * @return the current word, as a String
	 */
	public String getCurrentWord(){
		
		StringBuilder sbCurrentWordPublic = new StringBuilder();
		
		for(int nC = 0; nC < this.cCurrentWordChars.length; nC++) sbCurrentWordPublic.append(this.cCurrentWordChars[nC]);
		
		return sbCurrentWordPublic.toString();
		
	}//end getCurrentWord
	
	
	/**
	 * @return the number of letters that the player still needs to guess
	 */
	public int getNumLettersRemaining(){return this.nLettersRemaining;}
	

}


