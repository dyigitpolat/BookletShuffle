import java.util.ArrayList;

public final class UserInterfaceController {
	private static final UserInterfaceController uic = new UserInterfaceController();
	private Screen window;
	private WelcomePanel wp;
	private ConfigPanel cp;
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
		case DEFAULT:
			break;
		}
	}
	
	public static UserInterfaceController getInstance() {
		return uic;
	}
}

enum UIState {
	WELCOME, CONFIG, QUESTION, SHUFFLE, DEFAULT;
}
