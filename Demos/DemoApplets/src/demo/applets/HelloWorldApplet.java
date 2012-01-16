package demo.applets;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class HelloWorldApplet extends Applet {

	private static final long serialVersionUID = 1L;

	private StringBuffer buffer; 

	public void init() {
		buffer = new StringBuffer();
		addItem("init() ");
	}

	public void start() {
		addItem("start() ");
	}

	public void stop() {
		addItem("stop() ");
	}

	public void destroy() {
		addItem("destroy() ");
	}

	private void addItem(String message) {
		System.out.println(message);
		buffer.append(message);
		repaint();
	}

	public void paint(Graphics g) {
		// Draw a Rectangle around the applet's display area.
		g.setColor(Color.RED);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);

		// Draw the current string inside the rectangle.
		g.drawString(buffer.toString(), 5, 15);
	}
}