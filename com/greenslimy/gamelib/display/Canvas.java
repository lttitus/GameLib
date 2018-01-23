package com.greenslimy.gamelib.display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import com.greenslimy.gamelib.display.graphics.Drawable;

public class Canvas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	public Canvas(int w, int h) {
		this.setSize(w, h);
		this.setBackground(Color.BLACK);
	}
	
	private Drawable d;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Iterator<Drawable> i=drawables.iterator();i.hasNext();) {
			d = i.next();
			if(d != null) {
				if(!d.destroy) {	//Do not render objects that are marked to be destroyed
					d.predraw(g);
					d.draw(g);
				}
			}
		}
	}
	
	/**
	 * Adds a Drawable graphic that is constantly updated
	 * @param d The Drawable object
	 */
	public boolean addDrawable(Drawable d) {
		return drawables.add(d);
	}
	
	/*public boolean removeDrawable(Drawable d) {
		return drawables.remove(d);
	}*/

}
