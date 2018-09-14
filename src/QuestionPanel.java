import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class QuestionPanel extends KangalPanel {

	private JTextPane qTextPane;
	private ArrayList<JTextField> choiceFields;
	private ArrayList<JRadioButton> choiceButtons;
	private JButton proceed;
	private JButton back;
	
	public QuestionPanel( UserInterfaceController uic) {
		super( uic);
		
		qTextPane = new JTextPane();
		qTextPane.setPreferredSize( new Dimension(500, 200));
		qTextPane.setText("Enter question text");
		add(qTextPane);
		
		choiceFields = new ArrayList<>(); 
		choiceButtons = new ArrayList<>(); 
		ButtonGroup group = new ButtonGroup();
		for( int i = 0; i < uic.getChoiceCount(); i++) {
			JRadioButton radioButton = new JRadioButton();
			radioButton.setPreferredSize( new Dimension(20, 30));
			radioButton.setBackground(Color.BLACK);
			choiceButtons.add( radioButton);
			group.add(radioButton);
		}
		
		for( int i = 0; i < uic.getChoiceCount(); i++) {
			JPanel panel = new JPanel();
			JTextField choiceField = new JTextField("Enter Choice " + (char) ('A' + i));
			choiceField.setPreferredSize( new Dimension(480, 30));
			choiceFields.add( choiceField);
			panel.add(choiceButtons.get(i));
			panel.add(choiceField);
			panel.setBackground(Color.black);
			add(panel);
		}
		
		proceed = new JButton("NEXT >");
		proceed.setPreferredSize(new Dimension(250, 50));
		proceed.setAlignmentX(0.5f);
		proceed.setFont(new Font("Arial", 0, 20));
		
		back = new JButton("< BACK");
		back.setPreferredSize(new Dimension(250, 50));
		back.setAlignmentX(0.5f);
		back.setFont(new Font("Arial", 0, 20));
		
		add(back);
		add(proceed);
		
		render();
	}
	
	public void addQuestion() {
		
	}
	
	public void backButton() {
		
	}
	
}
