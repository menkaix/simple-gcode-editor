package com.menkaix.jometry.drawable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.menkaix.jometry.basics.SimplePoint;
import com.menkaix.jometry.basics.Vector;

public class MathScene extends Scene{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2015606473027851493L;
	public int width;
	public int height;

	// get bounds
	public double minx = 1e14;
	public double miny = 1e14;

	public double maxx = -1e14;
	public double maxy = -1e14;

	public int math2pixX(double x){
		double ax = (width)/(maxx-minx);
		
		return (int) (x * ax - ax * minx) ;
	}
	
	public int math2pixY(double y) {
		
		double ay = -(height)/(maxy-miny);
		
		return (int) (y *ay + ay * miny) ;
	}
	
	public MathScene(int pixelWidth, int pixelHeight) {

		width = pixelWidth ;
		height = pixelHeight ;
		
	}
	
	public void draw(Graphics graphics) {
		
		for(Drawable d : elements) {
			d.draw(graphics);
		}

	}

	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

}
