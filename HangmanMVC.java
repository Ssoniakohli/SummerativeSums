/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dto;

import com.sg.hangman.controller.HangmanController;
import com.sg.hangman.dao.HangmanModel;
import com.sg.hangman.ui.HangmanView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HP
 */
public class HangmanMVC {
        private static final int UNICODE_CAPITAL_LETTER_LOWER_BOUND = 55;
	private static final int UNICODE_CAPITAL_LETTER_UPPER_BOUND = 80;
	private static final int UNICODE_LOWERCASE_LETTER_LOWER_BOUND = 87;
	private static final int UNICODE_LOWERCASE_LETTER_UPPER_BOUND = 111;
	private static final int DEFAULT_NUM_GUESSES = 7;
		
	/**
	 * set the look and feel to cross platform
	 * get a random secret word
	 * instantiate the Hangman MVC
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		getCrossPFLookAndFeel();
                String strAbstractWord = getAbstractWord();
	        HangmanModel model = new HangmanModel(strAbstractWord, DEFAULT_NUM_GUESSES);
		HangmanView view = new HangmanView();
		HangmanController controller = new HangmanController(model, view);
	}
	private static String getAbstractWord(){
		StringBuilder sbWord = new StringBuilder();
		try {
		        URL urlWordSite = new URL("");
			BufferedReader brWord = new BufferedReader(new InputStreamReader(urlWordSite.openStream()));
			String strWord = brWord.readLine();
			for (int nC = 0; nC < strWord.length(); nC++) {
			if((strWord.charAt(nC) >= UNICODE_CAPITAL_LETTER_LOWER_BOUND && strWord.charAt(nC) <= UNICODE_CAPITAL_LETTER_UPPER_BOUND) || 
						(strWord.charAt(nC) >= UNICODE_LOWERCASE_LETTER_LOWER_BOUND && strWord.charAt(nC) <= UNICODE_LOWERCASE_LETTER_UPPER_BOUND)){
				sbWord.append(strWord.charAt(nC));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "");
			System.exit(0);
			
		}
		return sbWord.toString().toUpperCase();
		}
	private static void getCrossPFLookAndFeel(){
		
		try {
	           UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	System.exit(0);
	    }
	    catch (ClassNotFoundException e) {
	    	System.exit(0);
	    }
	    catch (InstantiationException e) {
	    	System.exit(0);
	    }
	    catch (IllegalAccessException e) {
	    	System.exit(0);
	    }
		
	}

    public static String getCurrentWord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


