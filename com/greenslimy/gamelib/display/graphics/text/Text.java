package com.greenslimy.gamelib.display.graphics.text;

import java.awt.Color;
import java.awt.Graphics;

import com.greenslimy.gamelib.display.graphics.Drawable;

/**
 * Creates a new Text object.
 * <p>Bold is required:<br>
 * Color c<br>
 * <b>String s<br>
 * int x<br>
 * int y</b></p>
 * @author Green
 *
 */
public class Text extends Drawable {
	
	public String text;
	
	/**
	 * Creates a basic Text object.<br>
	 * Must instantiate with update() method.
	 * @param c Color
	 * @param s String of Text
	 * @param x
	 * @param y
	 */
	public Text(Color c, String s, int x, int y) {
		super(c, x, y);
		this.text = s;
	}
	
	/**
	 * Creates a basic Text object.<br>
	 * Must instantiate with update() method.
	 * @param s String of Text
	 * @param x
	 * @param y
	 */
	public Text(String s, int x, int y) {
		this(Color.WHITE, s, x, y);
	}
	
	public void update(Color c) {
		this.c = c;
	}
	
	public void update(String text) {
		this.text = text;
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(String text, int x, int y) {
		this.update(x, y);
		this.text = text;
	}

	public void draw(Graphics g) {
		g.setColor(c);
		g.drawString(text, x, y);
	}

}
