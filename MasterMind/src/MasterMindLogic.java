import java.awt.Color;
import java.util.Random;

public class MasterMindLogic {
	public String createCombo() {
		String answer = "";
		for(int i = 0; i < 4; i++) {
			Random rand = new Random();
			int value = rand.nextInt(4);
			if(value % 4 == 0) {
				answer += "R";
			} else if(value % 4 == 1) {
				answer += "Y";
			} else if(value % 4 == 2) {
				answer += "G";
			} else {
				answer += "B";
			}
		}
		
		return answer;
	}
	
	public String userGuessCombo(int button, int buttonValue) {
		String answer = "";
		if(buttonValue % 4 == 0) {
			answer += "R";
		} else if(buttonValue % 4 == 1) {
			answer += "Y";
		} else if(buttonValue % 4 == 2) {
			answer += "G";
		} else {
			answer += "B";
		}
		
		return answer;
	}
	
	public MasterMindHits findHits(String Sol, String Ans) {
		int hits = 0;
		int psuedohits = 0;
		String leftover = "";
		int[] miss = new int[10];
		for(int i = 0; i < Sol.length(); i++) {
			if(Sol.charAt(i) == Ans.charAt(i)) {
				hits++;
			} else {
				miss[Sol.charAt(i) % miss.length]++;
				leftover += Ans.charAt(i) + "";
			}
		}
		
		for(int i = 0; i < leftover.length(); i++) {
			if(miss[leftover.charAt(i) % miss.length] != 0) {
				psuedohits++;
				miss[leftover.charAt(i) % miss.length]--;
			}
		}
		
		return new MasterMindHits(psuedohits, hits);
	}
	
}
