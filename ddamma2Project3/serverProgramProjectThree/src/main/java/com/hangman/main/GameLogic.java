package com.hangman.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameLogic {
	
	private int remainingGuesses=6;
	private String currentCategory;
	private HashMap<String, Integer> wordsGuessed= new HashMap<String, Integer>();
	private String currentWord;
	private static String[] superHeroes = { "superman", "flash","batman", "ironman", "spiderman", "terminator", "wolverine", "aquaman", "antman" };
	private static String[] food = { "burger", "pasta","pizza", "sandwich", "cake", "custard", "rice", "bread", "omelette" };
	private static String[] unitedStates = { "california", "florida","texas", "georgia", "alaska", "washington", "arizona", "virginia", "ohio" };
	
	
	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}

	public static String[] getSuperHeroes() {
		return superHeroes;
	}

	public static void setSuperHeroes(String[] superHeroes) {
		GameLogic.superHeroes = superHeroes;
	}

	public static String[] getFood() {
		return food;
	}

	public static void setFood(String[] food) {
		GameLogic.food = food;
	}

	public static String[] getUnitedStates() {
		return unitedStates;
	}

	public static void setUnitedStates(String[] unitedStates) {
		GameLogic.unitedStates = unitedStates;
	}

	public GameLogic(){}
	
	public int getRemainingGuesses() {
		return remainingGuesses;
	}
	public void setRemainingGuesses(int remainingGuesses) {
		this.remainingGuesses = remainingGuesses;
	}
	public String getCurrentCategory() {
		return currentCategory;
	}
	public void setCurrentCategory(String currentCategory) {
		this.currentCategory = currentCategory;
	}
	public HashMap<String, Integer> getWordsGuessed() {
		return wordsGuessed;
	}
	public void setWordsGuessed(HashMap<String, Integer> wordsGuessed) {
		this.wordsGuessed = wordsGuessed;
	}

	public String generateWord(String category) {
		// TODO Auto-generated method stub
		String word="";
		switch(category){
		case "superHeroes":
			 word = superHeroes[(int) (Math.random() * superHeroes.length)];
			 break;
		case "food":
			 word = food[(int) (Math.random() * food.length)];
			 break;
		case "usaStates":
			word = unitedStates[(int) (Math.random() * unitedStates.length)];
			break;
		default:
			break;
		}
		
		this.currentWord=word;
		return word;
	}

	public List<Integer> findOccurence(String word) {
        List<Integer> indexes = new ArrayList<Integer>();
        String lowerCaseTextString = currentWord.toLowerCase();
        String lowerCaseWord = word.toLowerCase();

        int index = 0;
        while(index != -1){
            index = lowerCaseTextString.indexOf(lowerCaseWord, index);
            if (index != -1) {
                indexes.add(index);
                index++;
            }
        }
        return indexes;
    }
	

}
