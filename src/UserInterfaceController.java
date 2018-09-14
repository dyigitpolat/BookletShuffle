import java.util.ArrayList;

public final class UserInterfaceController {
	private static final UserInterfaceController uic = new UserInterfaceController();
	private Screen window;
	private WelcomePanel wp;
	private ConfigPanel cp;
	private QuestionPanel qp;
	private UIState state;
	
	//config
	private int questionCount;
	private int choiceCount;
	
	//data
	Exam e;
	ArrayList<Question> questions;
	
	//control
	private int currentQuestion = 0;
	
	private UserInterfaceController() {
		//init
		window = new Screen("BookletShuffle", 600, 400);
		wp = new WelcomePanel(this);
		cp = new ConfigPanel(this);
		setState(UIState.WELCOME);
	}
	
	public void setState(UIState state) {
		this.state = state;
		switch(state) {
		case WELCOME:
			window.setPanel(wp);
			break;
		case CONFIG:
			window.setPanel(cp);
			break;
		case QUESTION:
			if( choiceCount > 2) window.setWindowSize(600, 400 + 50*(choiceCount - 2));
			qp = new QuestionPanel(this);
			window.setPanel(qp);
			break;
		case DEFAULT:
			break;
		}
	}
	
	public void setConfig(int questionCount, int choiceCount) {
		this.questionCount = questionCount;
		this.choiceCount = choiceCount;
	}
	
	public int getQuestionCount() {
		return questionCount;
	}
	
	public int getChoiceCount() {
		return choiceCount;
	}
	
	public Question getPreviousQuestion() {
		return questions.get(--currentQuestion);
	}
	
	public void nextQuestion( Question q) {
		currentQuestion++;
		questions.add(q);
	}
	
	public static UserInterfaceController getInstance() {
		return uic;
	}
}

enum UIState {
	WELCOME, CONFIG, QUESTION, SHUFFLE, DEFAULT;
}
