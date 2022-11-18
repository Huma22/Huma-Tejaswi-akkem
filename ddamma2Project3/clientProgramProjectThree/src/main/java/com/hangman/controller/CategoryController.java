package com.hangman.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.hangman.Main;
import com.hangman.main.WordGuess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CategoryController {

    private Main main;
    private Socket socket;
	private ObjectInputStream os;
	private PrintWriter out;
	private WordGuess wordGuess;

    @FXML
    private Button superHeroesButton;

    @FXML
    private Button usaButton;

    @FXML
    private Button foodButton;

    @FXML
    private Text winsText;
    @FXML
    private Text losesText;
	@FXML
    void food(ActionEvent event) throws IOException, ClassNotFoundException {
		 
	            
	            out.println("food");
	             wordGuess=(WordGuess) os.readObject();
	            if(wordGuess!=null){
	            	main.gameWindow(wordGuess,os,out);
	            }
    }

    @FXML
    void superHeroes(ActionEvent event) throws IOException, ClassNotFoundException {
            out.println("superHeroes");
            wordGuess=(WordGuess) os.readObject();
            if(wordGuess!=null){
            	main.gameWindow(wordGuess,os,out);
            }
            
    }

    @FXML
    void usaStates(ActionEvent event) throws IOException, ClassNotFoundException {
              
              out.println("usaStates");
               wordGuess=(WordGuess) os.readObject();
              if(wordGuess!=null){
              	main.gameWindow(wordGuess,os,out);
              }
    }

	public void setMain(Main main, Socket socket, ObjectInputStream os, PrintWriter out, WordGuess wordGuess) {
		this.main=main;
		this.socket=socket;
		this.os=os;
		this.out=out;
		 this.wordGuess=wordGuess;
		 this.losesText.setText("Losses : "+wordGuess.getLosses());
		 
		 if(wordGuess.getCategoriesWins().size()>0){
		 setCategories();
		 }
		 
		// TODO Auto-generated constructor stub
  	 
	}

	private void setCategories() {
		int win=0;
		// TODO Auto-generated method stub
		if(wordGuess.getCategoriesWins().containsKey("food")){
			foodButton.setDisable(true);
			win++;
		}
		if(wordGuess.getCategoriesWins().containsKey("superHeroes")){
			superHeroesButton.setDisable(true);
			win++;
		}
		if(wordGuess.getCategoriesWins().containsKey("usaStates")){
			usaButton.setDisable(true);
		win++;
		}
		winsText.setText("Wins : "+win);
	
			
	}

}