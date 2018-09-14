import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

//prettier label for our UI with simple font size adjustment
public class KangalLabel extends JLabel {
	public KangalLabel( String title, int size) {
		super(title);
		setFont(new Font("Arial", 0, size));
		setForeground(Color.WHITE);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}
}
