package com.greenslimy.gamelib.display;

import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;

import com.greenslimy.gamelib.display.graphics.Drawable;

public class Display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int w, h;
	public Canvas canv;
	
	public Display(String title, int w, int h, LayoutManager lm) {
		this.w = w;
		this.h = h;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setPreferredSize(new Dimension(w, h));
		this.pack();
		this.setVisible(true);
		this.setLayout(lm);
		
		init();
	}
	
	public Display(String title, int w, int h) {
		this(title, w, h, null);
	}
	
	private void init() {
		this.canv = new Canvas(w, h);
		this.add(canv);
	}
	
	/**
	 * Adds a drawable graphic that is constantly updated
	 * @param d
	 */
	public boolean addDrawable(Drawable d) {
		return canv.addDrawable(d);
	}
	
	public void render() {
		canv.repaint();
	}
	
	public Canvas getCanvas() {
		return this.canv;
	}

}
