/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangman.controller;

import com.sg.dto.HangmanMVC;
import com.sg.hangman.dao.HangmanModel;
import com.sg.hangman.ui.HangmanView;


import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
    public class HangmanController {
         
        private final String INITIAL_STATUS = "Letter to make a guess!";	//status displayed in the view before any guess has been made
	private final static String WINNING_HEADER = "Winner!";
	private final static String WINNING_MESSAGE = "Congratulations! You Won!\nPlay again?";
	private final static String LOSING_HEADER = "USER lost too!";
	private final static String LOSING_MESSAGE = "So sorry, you lost.\nPlay again?";
	private static HangmanModel controlModel;
	private static HangmanView controlView;
	
	public HangmanController(HangmanModel model, HangmanView view){
		controlModel = model;
		controlView = view;
		updateCurrentWord(model, view);
		updateNumGuesses(model, view);
		updateResultDisplay(INITIAL_STATUS, view);
		updateHangmanImage(model, view);
		view.getFrame().setVisible(true);
	}
	
	private static void updateCurrentWord(HangmanModel model, HangmanView view){
		
		String strWord = HangmanMVC.getCurrentWord();
		char[] cWordChars = strWord.toCharArray();
		char[] cDisplayChars = new char[cWordChars.length * 2 - 1];	
		
		int nLetterCounter = 0;
		for(int nC = 0; nC < cDisplayChars.length; nC++){
			
			if(nC % 2 != 0) cDisplayChars[nC] = ' ';
			else{
				cDisplayChars[nC] = cWordChars[nLetterCounter];
				nLetterCounter++;
			}
		}
		view.setCurrentWord(new String(cDisplayChars));
		}
	/**
	 * call the setter method
	 * @param strMessage - the string to display to the user
	 * @param view - the view
	 */
	private static void updateResultDisplay(String strMessage, HangmanView view){view.setStatusUpdate(strMessage);}
        /**
	 * get the number of guesses from the model and update the view
	 * @param model - hangman game model
	 * @param view - hangman game view
	 */
	private static void updateNumGuesses(HangmanModel model, HangmanView view){
		String strNumAsString = "";
		strNumAsString += model.getNumGuessesLeft();
		strNumAsString += " / guesses left";
		view.setNumGuesses(strNumAsString);
		
	}//end updateNumGuesses
	/**
	 * 
	 * switch on the number of guesses left to determine the image icon
	 * 
	 * @param model - hangman model
	 * @param view - hangman view
	 */
	private static void updateHangmanImage(HangmanModel model, HangmanView view){
		
		if(model.getNumGuessesLeft() > 7){
			
			view.setImageIcon("/hangman image");
		}
		else{
                       
			switch(model.getNumGuessesLeft()){
		
			case 7  :   view.setImageIcon(" hangman head");
				break;
			case 6  :   view.setImageIcon("  hangman body");
				break;
			case 5  :   view.setImageIcon("  hangman right arm");
				break;
			case 4  :   view.setImageIcon("  hangman left arm");
				break;
			case 3  :   view.setImageIcon("  hangman body2");
				break;
			case 2  :   view.setImageIcon(" hangman right leg ");
				break;
			case 1  :   view.setImageIcon(" hangman left leg");
				break;
			case 0  :   view.setImageIcon(" hangman image ");
				break;
				default :   break;
		     }
		}
		}//end updateHangmanImg
	
	/**
	 * given a letter, make a guess
	 * pass the guess to the model
	 * update the view based on results from the model
	 * @param cLetter
	 */
	public static void makeGuess(char cLetter){
		
		//if the game is not a win or loss
		if(!controlModel.isWin() && !controlModel.isLoss()){
			String strResult = controlModel.makeGuess(cLetter);			
			
			updateResultDisplay(strResult, controlView);
			updateCurrentWord(controlModel, controlView);
			updateNumGuesses(controlModel, controlView);
			updateHangmanImage(controlModel, controlView);
	}	
		if(controlModel.isWin()){
			int nUserInput = JOptionPane.showConfirmDialog(null, WINNING_MESSAGE, WINNING_HEADER, JOptionPane.YES_NO_OPTION);
			if(nUserInput == JOptionPane.YES_OPTION){
				controlView.getFrame().dispose();
				HangmanMVC.main(null);
			}
			else{
				System.exit(0);
			}
	}
		if(controlModel.isLoss()){
			int nUserInput = JOptionPane.showConfirmDialog(null, LOSING_MESSAGE+"\n"+"Abstract Word: "+controlModel.getSecretWord(), LOSING_HEADER, JOptionPane.YES_NO_OPTION);
			if(nUserInput == JOptionPane.YES_OPTION){
				controlView.getFrame().dispose();
				HangmanMVC.main(null);
			}
			else{
				System.exit(0);
			}
		}
		controlView.getFrame().repaint();
		}

        }