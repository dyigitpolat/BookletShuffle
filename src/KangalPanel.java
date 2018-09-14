import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//our UI Panels should inherit from this class.
public class KangalPanel extends JPanel implements Renderable {

	private RenderBehaviour rb;
	
	public KangalPanel() {
		//init
		rb = new RenderBehaviour();
		
		//properties
		setBorder( BorderFactory.createLineBorder(Color.white) );
		setBackground( Color.black);
	}
	
	public void render() {
		rb.perform( this);
	}
			
}
