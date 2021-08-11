package Test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

import TrelloApi.TrelloApiPage;

public class TrelloTest {
	private TrelloApiPage t;

	
	@Test
	public void TrelloTest() {
		t = new TrelloApiPage();
		ArrayList<String> board = new ArrayList<String>();
		ArrayList<String> cards = new ArrayList<String>();
		
		
		// Create Board
		String idBoard = t.createBoard("Trello Api Testing");
		board.add(idBoard);

		//Create Cards
		String idCard = t.createBoard("Card");
		cards.add(idCard);
		
	}
	
		
	
}