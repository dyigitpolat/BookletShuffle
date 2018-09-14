import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class QuestionPanel extends KangalPanel {

	private KangalLabel questionCounter;
	private JTextPane qTextPane;
	private ArrayList<JTextField> choiceFields;
	private ArrayList<JRadioButton> choiceButtons;
	private JButton proceed;
	private JButton back;
	
	public QuestionPanel( UserInterfaceController uic) {
		super( uic);
		
		questionCounter = new KangalLabel((uic.getCurrentQuestion() + 1) + "/" + uic.getQuestionCount(), 30);
		questionCounter.setPreferredSize(new Dimension(500, 30));
		add(questionCounter);
		
		qTextPane = new JTextPane();
		qTextPane.setPreferredSize( new Dimension(500, 170));
		qTextPane.setText("Enter question text here. \nMAKE SURE that you have selected the correct answer.");
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
		
		choiceButtons.get(0).setSelected(true);
		proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	addQuestion();
            }
        });
		
		back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	backButton();
            }
        });
		
		render();
	}
	
	public void reset() {
		questionCounter.setText((getUIC().getCurrentQuestion() + 1) + "/" + getUIC().getQuestionCount());
		qTextPane.setText("Enter question text here. \nMAKE SURE that you have selected the correct answer.");
		for( int i = 0; i < getUIC().getChoiceCount(); i++) {
			choiceFields.get( i).setText("Enter Choice " + (char) ('A' + i));
			choiceButtons.get( i).setSelected(i == 0);
		}
	}
	
	public void addQuestion() {
		ArrayList<Choice> choices = new ArrayList<>();
		for(int i = 0; i < choiceFields.size(); i++) {
			choices.add(new Choice(choiceFields.get(i).getText(), choiceButtons.get(i).isSelected()));
		}
		
		Question q = new Question(qTextPane.getText(), choices);
		getUIC().nextQuestion(q);
		
		if( getUIC().getCurrentQuestion() == getUIC().getQuestionCount()) return;
		
		if( getUIC().getMaxQuestion() == getUIC().getCurrentQuestion()) reset();
		else fillQuestion(getUIC().getQuestion());
	}
	
	public void backButton() {
		if( getUIC().getCurrentQuestion() == 0) {
			Object[] options = {"OK","CANCEL"};
			int n = JOptionPane.showOptionDialog(getParent(),
						"ALL UNSAVED PROGRESS WILL BE LOST",
						"WARNING!",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]); //default button title
						System.out.println(n);
			if( n == 0) { getUIC().setState(UIState.CONFIG); }
			return;
		}
		
		fillQuestion(getUIC().getPreviousQuestion());
	}
	
	public void fillQuestion(Question q) {
		reset();
		qTextPane.setText(q.text);
		
		for (int i = 0; i < choiceFields.size(); i++) {
			choiceFields.get(i).setText(q.choices.get(i).text);
			choiceButtons.get(i).setSelected(q.choices.get(i).isCorrect);
		}
	}
	
}
