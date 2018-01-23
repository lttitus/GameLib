package com.greenslimy.gamelib.display.graphics.shapes;

import java.awt.Color;
import java.awt.Graphics;

import com.greenslimy.gamelib.display.graphics.Drawable;

public abstract class Primitive extends Drawable {

	public Primitive(Color c, int x, int y) {
		super(c, x, y);
	}

	/*protected boolean needsUpdate = false;
	public void update() {
		if(needsUpdate) {
			updatePrimitive();
			//needsUpdate = false;
		}
	}*/
	
	public abstract void update();
	
	/**
	 * Does the necessary updates for the primitive.
	 */
	//protected abstract void updatePrimitive();

	public abstract void draw(Graphics g);

}
