package com.hangman.main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class WordGuess implements Serializable{
	private int count;
	private int guesses;
	private List<Integer> position;
	private String character;
	private Boolean guess;
	private Boolean isWin=false;
	private Integer losses=0;
	private Integer wins=0;
	private HashMap<String,Integer> categoriesWins= new HashMap();
	
	
	
	public Integer getWins() {
		return wins;
	}
	public void setWins(Integer wins) {
		this.wins = wins;
	}
	public Integer getLosses() {
		return losses;
	}
	public void setLosses(Integer losses) {
		this.losses = losses;
	}
	public Boolean getIsWin() {
		return isWin;
	}
	public void setIsWin(Boolean isWin) {
		this.isWin = isWin;
	}


	public HashMap<String, Integer> getCategoriesWins() {
		return categoriesWins;
	}
	public void setCategoriesWins(HashMap<String, Integer> categoriesWins) {
		this.categoriesWins = categoriesWins;
	}
	public int getGuesses() {
		return guesses;
	}
	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}
	public Boolean getGuess() {
		return guess;
	}
	public void setGuess(Boolean guess) {
		this.guess = guess;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Integer> getPosition() {
		return position;
	}
	public void setPosition(List<Integer> position) {
		this.position = position;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	
	
}
