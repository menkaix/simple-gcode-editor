package com.menkaix.jometry.drawable;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7810080216315419499L;

	private Canvas canvas;

	protected List<Drawable> elements = new ArrayList<Drawable>();

	public boolean isVisible = true ;
	public String name = "default" ;
	
	public void clear() {
		synchronized (elements) {
			elements.clear();
		}

	}
	
	public void add(Drawable d) {
		synchronized (elements) {
			elements.add(d) ;
		}
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void draw(Graphics graphics) {
		// do not clear, thou art not alone
		// graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		synchronized (elements) {
			for (Drawable d : elements) {
				d.draw(graphics);
			}
		}
	}

	public void setColor(Color color) {

		canvas.setBackground(color);

	}

	public void update() {
		
		synchronized (elements) {
			for (Drawable d : elements) {
				d.update();
			}
		}

	}

}
