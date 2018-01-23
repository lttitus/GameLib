package com.greenslimy.gamelib.display.graphics.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.greenslimy.gamelib.display.graphics.Drawable;

public abstract class Sprite extends Drawable {
	
	protected BufferedImage img;
	
	public Sprite(BufferedImage img, int x, int y, int w, int h) {
		super(Color.WHITE, x, y, w, h);
		this.img = img;
	}
	
	public Sprite(String imgPath, int x, int y, int w, int h) throws IOException {
		this(ImageIO.read(new File(imgPath)), x, y, w, h);
	}
	
	/**
	 * Creates a Sprite from a chosen space on an image sheet.
	 * @param sheet
	 * @param imgX
	 * @param imgY
	 * @param imgW
	 * @param imgH
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Sprite(BufferedImage sheet, int imgX, int imgY, int imgW, int imgH, int x, int y, int w, int h) {
		this(sheet.getSubimage(imgX, imgY, imgW, imgH), x, y, w, h);
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	public abstract void update();

}
