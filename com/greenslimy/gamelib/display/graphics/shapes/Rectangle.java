package com.greenslimy.gamelib.display.graphics.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A Rectangle is defined by the starting point and the end-point, not x, y, w, h;.
 * @author Green
 *
 */
public class Rectangle extends Primitive {
	
	public int w, h;
	//private int maxx, maxy, minx, miny;
	public boolean filled;
	
	public Rectangle(Color c, int x, int y, int w, int h, boolean filled) {
		super(c, x, y);
		this.w = w;
		this.h = h;
		this.filled = filled;
		//this.needsUpdate = true;
	}

	public Rectangle(Color c, int x, int y, int w, int h) {
		this(c, x, y, w, h, false);
	}
	
	public Rectangle(int x, int y, int w, int h) {
		this(Color.WHITE, x, y, w, h);
	}
	
	/**
	 * Calls <b>updateRectangle()</b>
	 */
	public void update() {
		updateRectangle();
	}

	/**
	 * This update sequence finds the minimum x, y and the maximum x, y.<br>
	 * Calls updateRectangle();
	 */
	/*public void updatePrimitive() {
			minx = Math.min(x, x2);
			miny = Math.min(y, y2);
			maxx = Math.max(x, x2);
			maxy = Math.max(y, y2);
			updateRectangle();
	}*/

	/**
	 * Draws the Rectangle using the minimum x, y and maximum x, y.<br>
	 * Calls drawRectangle(g);
	 * @param g The Graphics object
	 */
	public void draw(Graphics g) {
		if(!filled) {
			g.drawRect(x, y, w, h);
		}else{
			g.fillRect(x, y, w, h);
		}
		drawRectangle(g);
	}
	
	/**
	 * This is called every frame the Rectangle is redrawn.<br>
	 * According to update() in Primitive, this is only called when<br>
	 * <b>needsUpdate = true;</b><br>
	 * A Rectangle needs updating when its points are changed.
	 * @param g The Graphics object
	 */
	protected void drawRectangle(Graphics g) { }
	/**
	 * This is called when the Rectangle is updated.<br>
	 * You must Override this method in order to use it.<br>
	 * This is not required, so it is not an abstract.
	 */
	protected void updateRectangle() { }
	
	public void changePoints(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		//needsUpdate = true;
	}

}
