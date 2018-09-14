import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConfigPanel extends KangalPanel {
	
	private JSpinner questionCountSpinner;
	private JSpinner choiceCountSpinner;
	private JButton proceed;
	
	public ConfigPanel(UserInterfaceController uic) {
		super(uic);

		questionCountSpinner = new JSpinner();
		questionCountSpinner.setFont(new Font("Arial", 0, 20));
		questionCountSpinner.setPreferredSize( new Dimension(60, 30));
		questionCountSpinner.setValue(5);
		questionCountSpinner.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            if( (Integer) questionCountSpinner.getValue() < 1) questionCountSpinner.setValue(1);
	        }
	    });
		
		choiceCountSpinner = new JSpinner();
		choiceCountSpinner.setFont(new Font("Arial", 0, 20));
		choiceCountSpinner.setPreferredSize( new Dimension(60, 30));
		choiceCountSpinner.setValue(2);
		choiceCountSpinner.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            if( (Integer) choiceCountSpinner.getValue() < 2) choiceCountSpinner.setValue(2);
	        }
	    });
		
		proceed = new JButton("NEXT");
		proceed.setPreferredSize(new Dimension(300, 50));
		proceed.setAlignmentX(0.5f);
		proceed.setFont(new Font("Arial", 0, 20));
		
		proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int questionCount = (Integer) questionCountSpinner.getValue();
            	int choiceCount = (Integer) choiceCountSpinner.getValue();
            	uic.setConfig(questionCount, choiceCount);
                uic.setState(UIState.QUESTION);
            }
        });

		add(new KangalLabel("Question Count: ", 20)).setPreferredSize( new Dimension(300,100));
		add(questionCountSpinner);
		add(new KangalLabel("Choice Count: ", 20)).setPreferredSize( new Dimension(300,150));
		add(choiceCountSpinner);
		add(proceed);
		
		render();
	}
}
