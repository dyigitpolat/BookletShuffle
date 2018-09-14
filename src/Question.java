import java.util.ArrayList;
import java.util.Collections;


public class Question {
	public String text;
	public ArrayList<Choice> choices;
	
	public Question(String text, ArrayList<Choice> choices) {
		this.text = text;
		this.choices = choices;
	}
	
	public void shuffle() {
		Collections.shuffle(choices);
	}
	

}
