/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangman.dao;


import com.sg.hangman.controller.HangmanController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
     
public class HangmandaoImpl implements ActionListener {


	@Override
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		
		Color clrPressed = new Color(0, 0, 0);
		btnPressed.setBackground(clrPressed);
		btnPressed.setForeground(clrPressed);
		btnPressed.repaint();
		
		String strBtnLbl = btnPressed.getText();
		
		HangmanController.makeGuess(strBtnLbl.charAt(0));
		
	}
}
