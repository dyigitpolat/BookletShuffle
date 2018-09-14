import java.util.ArrayList;
import java.util.Collections;

public class Exam {
	public ArrayList<Question> questions;
	
	public Exam(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public void shuffle() {
		Collections.shuffle(questions);
		questions.parallelStream().forEach(x -> x.shuffle());
	}
}
