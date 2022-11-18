package serverProgramProjectThree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hangman.main.GameLogic;


class MyTest {

	@Test
	void testHeroes() {
		String[] superHeroes = { "superman", "flash","batman", "ironman", "spiderman", "terminator", "wolverine", "aquaman", "antman" };
		GameLogic logic = new GameLogic();
		logic.generateWord("superHeroes");
		int count = 0;
		String getWord = logic.getCurrentWord();
		for (int i = 0; i < superHeroes.length; i++) {
			if (superHeroes[i].contains(getWord)) {
				count++;
			}
		}
		assertTrue(count==1);
	
	}
	
	@Test
	void testFood() {
		String[] food = { "burger", "pasta","pizza", "sandwich", "cake", "custard", "rice", "bread", "omelette" };
		GameLogic logic = new GameLogic();
		logic.generateWord("food");
		int count = 0;
		String getWord = logic.getCurrentWord();
		for (int i = 0; i < food.length; i++) {
			if (food[i].contains(getWord)) {
				count++;
			}
		}
		assertTrue(count==1);
	}
	
	@Test
	void testUsaStates() {
		String[] unitedStates = { "california", "florida","texas", "georgia", "alaska", "washington", "arizona", "virginia", "ohio" };
		GameLogic logic = new GameLogic();
		logic.generateWord("usaStates");
		int count = 0;
		String getWord = logic.getCurrentWord();
		for (int i = 0; i < unitedStates.length; i++) {
			if (unitedStates[i].contains(getWord)) {
				count++;
			}
		}
		assertTrue(count==1);
	}
	
	@Test
	void testfindOccurencesCountry1() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("alaska");
		List<Integer> arr = logic.findOccurence("a");
		assertEquals(arr.size(), 3);
	}
	
	@Test
	void testfindOccurencesCountry2() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("alaska");
		List<Integer> arr = logic.findOccurence("a");
		int []list1 = {0,2,5};
		int [] list2 = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			list2[i] = arr.get(i);
		}
		assertArrayEquals(list1,list2);
	}
	
	@Test
	void testfindOccurencesFood1() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("pizza");
		List<Integer> arr = logic.findOccurence("z");
		assertEquals(arr.size(), 2);
	}
	
	@Test
	void testfindOccurencesHero2() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("aquaman");
		List<Integer> arr = logic.findOccurence("m");
		int []list1 = {4};
		int [] list2 = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			list2[i] = arr.get(i);
		}
		assertArrayEquals(list1,list2);
	}
	
	@Test
	void testfindOccurencesHero1() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("spiderman");
		List<Integer> arr = logic.findOccurence("d");
		assertEquals(arr.size(), 1);
	}
	
	@Test
	void testfindOccurencesFood2() {
		GameLogic logic = new GameLogic();
		logic.setCurrentWord("pasta");
		List<Integer> arr = logic.findOccurence("a");
		int []list1 = {1,4};
		int [] list2 = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			list2[i] = arr.get(i);
		}
		assertArrayEquals(list1,list2);
	}
	
	@Test
	void assignedGuesses() {
		GameLogic logic = new GameLogic();
		assertEquals(6,logic.getRemainingGuesses());
	}
	
	

}
