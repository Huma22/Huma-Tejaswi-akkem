package com.hangman.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import com.hangman.Main;
import com.hangman.main.WordGuess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button playButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button howToPlay;
    
    private Main main;

	private ObjectInputStream os;
	private WordGuess wordGuess;
	private PrintWriter out;

    public void setMain(Main main, ObjectInputStream os, PrintWriter out){
    	this.main = main;
    	this.os=os;
    	this.out=out;
    	this.wordGuess= new WordGuess();
    }
    
    @FXML
    void exitGame(ActionEvent event) {

    }

    @FXML
    void playGame(ActionEvent event) {
    	try {
			main.categoryWindow(os,out,wordGuess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void showGuide(ActionEvent event) {

    }

}
