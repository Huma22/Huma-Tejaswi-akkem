package com.hangman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Game {
 private Socket client;
 private GameLogic logic;
private BufferedReader in;
private BufferedReader alphabetsIn;
private PrintWriter out;
private ObjectOutputStream oos;
private WordGuess wordGuess;
private ServerController serverController;
public Game(Socket client, ObjectOutputStream oos, BufferedReader in, ServerController serverController){
	 this.client=client;
	 logic= new GameLogic();
	 this.serverController=serverController;
	 this.oos=oos;
 wordGuess= new WordGuess();
 
	 this.in=in;
	 categorySelect();
 }

public void categorySelect(){
	 try {
		String category=in.readLine();
		logic.setCurrentCategory(category);
		String word=logic.generateWord(category);
		serverController.logToServer("Word Generated For Client: "+word+". From Category : "+category);
		wordGuess.setGuess(false);
		wordGuess.setGuesses(6);
		wordGuess.setIsWin(false);
		if(wordGuess.getWins()+wordGuess.getLosses()>2){
			wordGuess.setCategoriesWins(new HashMap<>());
			wordGuess.setWins(0);
			wordGuess.setLosses(0);
			serverController.logToServer("Restarting Game For Client: ");
			
		}
		wordGuess.setCount(word.length());
		oos.writeObject(wordGuess);
		oos.reset();
		String line;
		int wordsComplete=0;
		while(wordGuess.getGuesses()>0){
			
			String letter= in.readLine();
			System.out.println(letter);
			if(logic.getCurrentWord().contains(letter.toLowerCase())){
				List<Integer> positions = logic.findOccurence(letter);
				wordsComplete=positions.size()+wordsComplete;
				wordGuess.setCharacter(letter);
				wordGuess.setGuess(true);
				wordGuess.setPosition(positions);
				if(wordsComplete==logic.getCurrentWord().length()){
					wordGuess.setIsWin(true);

					serverController.logToServer("Client Guessed The Word Right!");
					wordGuess.getCategoriesWins().put(category, 1);
					wordGuess.setWins(wordGuess.getWins()+1);

					serverController.logToServer("Client Won Games : "+wordGuess.getWins());
					oos.writeObject(wordGuess);
					oos.reset();
					break;
					}
				oos.writeObject(wordGuess);
				oos.reset();
			}else{
				wordGuess.setGuess(false);
				wordGuess.setGuesses(wordGuess.getGuesses()-1);
				System.out.println("Guesses Left: "+wordGuess.getGuesses());
				if(wordGuess.getGuesses()==0){
					
					wordGuess.setLosses(wordGuess.getLosses()+1);
					serverController.logToServer("Client Lost Games : "+wordGuess.getLosses());
					
				}
				oos.writeObject(wordGuess);
				oos.reset();
			}
		}
		
		categorySelect();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
