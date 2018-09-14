import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class WelcomePanel extends KangalPanel {
	KangalLabel welcomeMessage;
	KangalLabel credit;
	JButton proceed;
	public WelcomePanel() {
		
		welcomeMessage = new KangalLabel("Welcome to BookletShuffle", 30);
		welcomeMessage.setPreferredSize( new Dimension(600, 100));
		welcomeMessage.setAlignmentX(0.5f);
		
		credit = new KangalLabel("Doğukan Yiğit Polat - 2018", 15);
		credit.setPreferredSize( new Dimension(600, 100));
		credit.setAlignmentX(0.5f);
		
		proceed = new JButton("Proceed");
		proceed.setPreferredSize(new Dimension(100, 50));
		proceed.setAlignmentX(0.5f);
		
		add(welcomeMessage);
		add(credit);
		add(proceed);

		this.setLayout( new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		render();
	}
}
