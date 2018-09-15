import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ShufflePanel extends KangalPanel{

	private KangalLabel doneMessage;
	private JTextPane examPane;
	private JTextPane answerKey;
	private JButton shuffle;
	
	private Exam exam;
	
	public ShufflePanel( UserInterfaceController uic) {
		super( uic);
		
		exam = uic.getExam();
		
		doneMessage = new KangalLabel("Booklet Ready!", 30);
		doneMessage.setPreferredSize(new Dimension(500, 30));
		add(doneMessage);
		
		examPane = new JTextPane();
		examPane.setPreferredSize( new Dimension(450, 270));
		add( new JScrollPane(examPane));
		
		answerKey = new JTextPane();
		answerKey.setPreferredSize( new Dimension(100, 270));
		add( new JScrollPane(answerKey));
		
		fillPanes();
		
		shuffle = new JButton("SHUFFLE!");
		shuffle.setPreferredSize(new Dimension(550, 30));
		shuffle.setAlignmentX(0.5f);
		shuffle.setFont(new Font("Arial", 0, 20));
		add(shuffle);
		
		shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	exam.shuffle();
            	fillPanes();
            }
        });
		
		render();
	}
	
	public void fillPanes() {
		examPane.setText("");
		answerKey.setText("");
		for( int i = 0; i < getUIC().getQuestionCount(); i++) {
			addBoldText(examPane, (i+1) + ". " + exam.questions.get(i).text + "\n\n");
			for( int j = 0; j < getUIC().getChoiceCount(); j++) {
				addNormalText(examPane, (char) ('A' + j) + ".) " + exam.questions.get(i).choices.get(j).text + "\n");
			}
			addNormalText(examPane, "\n\n");			
		}
		
		for( int i = 0; i < getUIC().getQuestionCount(); i++) {
			int correct = 0;
			for( int j = 0; j < getUIC().getChoiceCount(); j++) {
				if(exam.questions.get(i).choices.get(j).isCorrect) correct = j;
			}
			addNormalText(answerKey, (i+1) + "." + (char) ('A' + correct) + "\n");
		}
	}

	public void addBoldText(JTextPane pane, String text) {
        StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Bold Style", null);
        StyleConstants.setBold(style, true);
        try {
            doc.insertString(doc.getLength(), text, style);
        } 
        catch (BadLocationException e) {
            e.printStackTrace();
        }           
    }
	
	public void addNormalText(JTextPane pane, String text) {
        StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Bold Style", null);
        StyleConstants.setBold(style, false);
        try {
            doc.insertString(doc.getLength(), text, style);
        } 
        catch (BadLocationException e) {
            e.printStackTrace();
        }           
    }
}
