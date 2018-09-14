import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ShufflePanel extends KangalPanel{

	public ShufflePanel( UserInterfaceController uic) {
		super( uic);
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
}
