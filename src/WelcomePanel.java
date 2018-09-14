import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class WelcomePanel extends KangalPanel {
	KangalLabel welcomeMessage;
	KangalLabel credit;
	JButton proceed;
	
	public WelcomePanel(UserInterfaceController uic) {
		super(uic);
		
		welcomeMessage = new KangalLabel("Welcome to BookletShuffle", 30);
		welcomeMessage.setPreferredSize( new Dimension(580, 100));
		welcomeMessage.setAlignmentX(0.5f);
		
		credit = new KangalLabel("Doğukan Yiğit Polat - 2018", 15);
		credit.setPreferredSize( new Dimension(580, 100));
		credit.setAlignmentX(0.5f);
		
		proceed = new JButton("Proceed");
		proceed.setPreferredSize(new Dimension(100, 50));
		proceed.setAlignmentX(0.5f);
		
		add(welcomeMessage);
		add(credit);
		add(proceed);

		proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uic.setState(UIState.CONFIG);
            }
        });
		
		render();
	}
}
