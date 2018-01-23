package com.greenslimy.gamelib.display.graphics.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimatedSprite extends Sprite {
	
	/*
	 * Stores the different animations
	 */
	private HashMap<String,ArrayList<Sprite>> animations = new HashMap<String, ArrayList<Sprite>>();
	
	public String[] animTypes;
	public int animType = 0;
	private int curFrame = 0;

	/**
	 * Reads sprites in left->right, top->bottom order.
	 * @param sheet Sprite sheet
	 * @param imgX X of Top-left corner of each image of animation sprite sheet.
	 * @param imgY Y of Top-left corner.
	 * @param imgW W of each sprite in sheet.
	 * @param imgH H of each sprite in sheet.
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param startX X Start for top-left of animation sprite sheet.
	 * @param startY Y Start for top-left of sheet.
	 * @param frameCount
	 */
	public AnimatedSprite(BufferedImage sheet, int imgX, int imgY, int imgW, int imgH, int x, int y, int w, int h, int startX, int startY, int frameCount) {
		super(sheet, x, y, w, h);
	}

	public void update() {
		
	}
}
