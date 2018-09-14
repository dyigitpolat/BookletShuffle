public final class UserInterfaceController {
	
	private static final UserInterfaceController uic = new UserInterfaceController();
	private Screen window;
	private WelcomePanel wp;
	
	private UserInterfaceController() {
		window = new Screen("BookletShuffle", 600, 400);
		wp = new WelcomePanel();
		window.setPanel(wp);

	}
	
	public static UserInterfaceController getInstance() {
		return uic;
	}
}
