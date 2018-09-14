

import javax.swing.JPanel;
import javax.swing.JFrame;

//custom rendering behaviours are handled within this class
public class RenderBehaviour {
	
	public void perform( JPanel p) {
		p.repaint();
	}
	
	public void perform( JFrame f) {
		f.invalidate();
		f.repaint();
		f.validate();
		f.revalidate();
	}
}
