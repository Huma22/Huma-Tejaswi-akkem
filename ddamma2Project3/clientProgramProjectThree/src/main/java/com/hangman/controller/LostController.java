package com.hangman.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import com.hangman.Main;
import com.hangman.main.WordGuess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LostController {

    private Main main;
	private ObjectInputStream os;
	private PrintWriter out;
	private WordGuess wordGuess;

	@FXML
    void playAgain(ActionEvent event) throws IOException {
		main.mainWindow(os, out);
    }

    @FXML
    void quitGame(ActionEvent event) {
main.quitGame();
    }

	public void setMain(Main main, ObjectInputStream os, PrintWriter out) {
		// TODO Auto-generated method stub
		this.main=main;
		this.os=os;
		this.out=out;
		this.wordGuess=new WordGuess();
	}

}
