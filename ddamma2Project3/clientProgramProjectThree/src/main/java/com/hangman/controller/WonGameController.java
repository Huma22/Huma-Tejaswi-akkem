package com.hangman.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import com.hangman.Main;
import com.hangman.main.WordGuess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class WonGameController {

    @FXML
    private Button playAgainBtn;

    @FXML
    private Button quitBtn;
@FXML
private Text annText;
	private Main main;

	private ObjectInputStream os;

	private PrintWriter out;

	private WordGuess wordGuess;

    @FXML
    void playAgain(ActionEvent event) {
    	WordGuess wordGuess= new WordGuess();
    	try {
			main.categoryWindow(os, out, wordGuess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void quitGame(ActionEvent event) {
    	main.quitGame();
    }

	public void setMain(Main main, ObjectInputStream os, PrintWriter out, WordGuess wordGuess) {
		// TODO Auto-generated method stub
		this.main=main;
		this.os=os;
		this.out=out;
		this.wordGuess=wordGuess;
		if(wordGuess.getLosses()+wordGuess.getWins()>2&&wordGuess.getLosses()>wordGuess.getWins()){
			annText.setText("You Lost Game");
		}else{
			annText.setText("You Won Game");
		}
	}

}
