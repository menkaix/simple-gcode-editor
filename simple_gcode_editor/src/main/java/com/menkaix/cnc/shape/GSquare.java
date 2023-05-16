package com.menkaix.cnc.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.menkaix.cnc.Engravable;
import com.menkaix.jometry.basics.SimplePoint;
import com.menkaix.jometry.basics.StraightLine2D;

public class GSquare implements Engravable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3757649924616530583L;

	private ArrayList<StraightLine2D> edges = new ArrayList<>();
	private ArrayList<SimplePoint> points = new ArrayList<>();;

	private SimplePoint origin = new SimplePoint();
	private double size = 10;

	public GSquare() {
		update();
	}

	public GSquare(double x, double y) {
		this();
		setOrigin(new SimplePoint(x, y));
		update();
	}

	public GSquare(double x, double y, double size) {
		this(x, y);
		setSize(size);
		update();
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {

		points.clear();
		edges.clear();

		points.add(origin);
		points.add(new SimplePoint(origin.getX() + size, origin.getY()));
		points.add(new SimplePoint(origin.getX() + size, origin.getY() + size));
		points.add(new SimplePoint(origin.getX(), origin.getY() + size));

		for (int i = 0; i < points.size(); i++) {

			edges.add(new StraightLine2D(points.get(i), points.get((i + 1) % points.size())));

		}

	}

	@Override
	public void draw(Graphics graphics) {

		synchronized (points) {

			for (int i = 0; i < points.size() - 1; i++) {
				graphics.drawLine((int) points.get(i).getX(), (int) points.get(i).getY(),
						(int) points.get(i + 1).getX(), (int) points.get(i + 1).getY());
			}

		}

	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	public SimplePoint getOrigin() {
		return origin;
	}

	public void setOrigin(SimplePoint origin) {
		this.origin = origin;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

}
