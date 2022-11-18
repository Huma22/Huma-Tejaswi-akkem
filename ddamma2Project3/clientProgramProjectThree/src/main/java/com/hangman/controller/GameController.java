package com.hangman.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.ImageOutputStreamImpl;

import org.apache.commons.io.IOUtils;

import com.hangman.Main;
import com.hangman.RecieveObject;
import com.hangman.main.WordGuess;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameController {

    @FXML
    private AnchorPane keysGrid;

    @FXML
    private ImageView manHead;

    @FXML
    private ImageView manLeftArm;

    @FXML
    private ImageView manRightArm;

    @FXML
    private ImageView manBack;

    @FXML
    private ImageView manRightLeg;

    @FXML
    private ImageView manLeftLeg;

    @FXML
    private HBox lifePane;
    
    @FXML
    private HBox wordBox;

	private Main main;
	private Socket socket;
	private List<Button> gridButtons;
    private List<Button> lifeButtons;
	
    private String[] alphabets={"A","B","C","D","E","F",
			"G","H","I","J","K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z"};

	private int position;

	private WordGuess guess;
	private List<Button> letters;
	private BufferedReader in;
	private WordGuess wordGuess;
private ObjectInputStream os;

private PrintWriter out;
    
	
	public void setMain(Main main, Socket socket, WordGuess guess, ObjectInputStream os, PrintWriter out){
    	this.main=main;
    	this.socket=socket;
    	this.guess=guess;
    	this.os=os;
    	this.out=out;
    	this.wordGuess= new WordGuess();
    	this.wordGuess.setGuesses(6);
    	setGuessGrid();
    	System.out.println("Word Count: "+guess.getCount());
    	setLife();
    	setWord();
    }
    
    private void setWord() {
		// TODO Auto-generated method stub
    	letters= new ArrayList<>();
    	for(int i=0;i<guess.getCount();i++){
    		Button button= new Button("_");
    		button.setPrefWidth(65);
    		button.setStyle("-fx-background-color:white; -fx-padding: 5px; -fx-border-insets: 5px; -fx-background-insets: 5px;-fx-font-size:35;");
    		letters.add(button);
    		wordBox.getChildren().add(button);
    	}
	}

	public void setLife(){
    	lifeButtons= new ArrayList<>();
    	for(int i=0;i<6;i++){
    		Button button= new Button();
    		button.setPrefWidth(40);
    		button.setPrefHeight(40);
    		button.setStyle("-fx-background-color:red; -fx-padding: 5px; -fx-border-insets: 5px; -fx-background-insets: 5px;");
    		lifeButtons.add(button);
    		lifePane.getChildren().add(button);
    	}
    }
    
    
    public void setGuessGrid(){
    	gridButtons=new ArrayList<>();
		GridPane pane= new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);

		pane.setPadding(new Insets(10));
		int x=0;
		for(int i=0; i<4;i++){
			for(int u=0; u<7;u++){
			if(x<26){
				Button button= new Button(alphabets[x]);
				
				final int position=x;
				button.setPrefWidth(40);
	    		button.setPrefHeight(40);
	    		button.setOnAction(event->{

					 if(wordGuess.getGuesses()>0){
	    			try {

//	    				
						 out.println(alphabets[position]);

							//os= new ObjectInputStream(socket.getInputStream());
						 this.wordGuess = (WordGuess)os.readObject();
						
						 if(wordGuess.getGuess()){
							 System.out.println("Positions of : "+wordGuess.getCharacter());
							 wordGuess.getPosition().forEach(pos->{
								 letters.get(pos).setText(wordGuess.getCharacter());
								 gridButtons.get(position).setDisable(true);
								 if(wordGuess.getIsWin()){
									 try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									 try {
										 if(wordGuess.getLosses()+wordGuess.getWins()>2){
											 main.endGameWindow(os, out, wordGuess);
										 }else{

											 System.out.println("this is called 1 . "+wordGuess.getLosses()+", "+wordGuess.getWins());
										main.categoryWindow(os, out,wordGuess);
										 }
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								 }
							 });
						 }else{
							 System.out.println("Invalid letter, Guesses Left:"+wordGuess.getGuesses());
							 lifeButtons.get(wordGuess.getGuesses()).setVisible(false);
							 gridButtons.get(position).setDisable(true);
							 switch(wordGuess.getGuesses()){
							 case 5:
								 manHead.setVisible(true);
								 break;
							 case 4:

								 manRightArm.setVisible(true);
								 break;
							 case 3:
								 manLeftArm.setVisible(true);
								 break;
							 case 2:

								 manBack.setVisible(true);
								 break;
							 case 1:

								 manRightLeg.setVisible(true);
								 break;
							default:

								 manLeftLeg.setVisible(true);
								 break;
							 }
						 
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					//} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 }else{
						 try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 try {
								 if(wordGuess.getLosses()+wordGuess.getWins()>2){
									 try {
										main.endGameWindow(os, out, wordGuess);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								 }else{
									 System.out.println("this is called 2");
								main.categoryWindow(os, out,wordGuess);
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					 }
	    			
	    		});
				gridButtons.add(button);
				pane.add(button, u, i);
				}
			
			x=x+1;
			}
    }
		keysGrid.getChildren().add(pane);
    }
    
   
}
