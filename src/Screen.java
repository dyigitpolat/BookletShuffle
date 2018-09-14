

import java.awt.Color;
import javax.swing.*;

public class Screen extends JFrame implements Renderable {
	private int width;
	private int height;
	private RenderBehaviour rb;
	
	public Screen( String title, int w, int h) {
		//init
		super( title);
		width = w;
		height = h;
		rb = new RenderBehaviour();
		
		//frame properties
		//800x600, centered
		setWindowSize( width, height); 
		setResizable(false);

		//add default panel
		setPanel(new KangalPanel());

		//show
		setVisible( true);
		setEnabled( true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		render();
	}
	
	public void setWindowSize(int w, int h) {
		width = w;
		height = h;
		super.setSize( width, height); 
		setLocationRelativeTo( null); //center frame
		render();
	}
	
	public void setPanel(KangalPanel p) {
		getContentPane().removeAll();
		getContentPane().add(p);
		render();
	}
	
	public void render() {
		rb.perform( this);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
