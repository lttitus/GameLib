package com.greenslimy.gamelib.display.graphics;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Drawable {
	
	public Color c;
	public int x, y, w, h;
	public boolean destroy = false;
	
	public Drawable(Color c, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.y = y;
		this.c = c;
	}
	
	public Drawable(Color c, int x, int y) {
		this(c, x, y , 0, 0);
	}
	
	public Drawable(int x, int y) {
		this(Color.WHITE, x, y, 0, 0);
	}
	
	public void predraw(Graphics g) {
		g.setColor(c);
	}
	
	/**
	 * This is called after the Drawable is removed from the active render list.
	 */
	public void removed() { }

	public abstract void update();
	/**
	 * The default draw method for all drawable objects.
	 * @param g The Graphics object it will be drawn to.
	 */
	public abstract void draw(Graphics g);
	
}
