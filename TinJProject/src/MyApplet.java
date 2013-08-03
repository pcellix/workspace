import java.applet.Applet;
import java.awt.Graphics;

import javax.swing.RepaintManager;


public class MyApplet extends Applet {
	String message;
	
	public void init() {
		message = "Hello World";
		repaint();
	}
	
	public void start() {
		message = "It started";
	}
	
	public void stop() {
		message = "It started";
	}
	
	public void paint(Graphics g) {
		g.drawString(message, 5, 15);
	}

}
