package com.greenslimy.gamelib.display.graphics.text;

import java.awt.Color;

/**
 * This is a Text object that has a certain amount of time on the screen before it disappears(ttl).<br>
 * In order to create this object in line, use:<br><br>
 * <b>addDrawable(new TimedText(s, x, y, ttl) {</b><br>
 * public void updateText() {<br>
 * body here<br>
 * }<br>
 * <b>});</b>
 * @author Green
 *
 */
public abstract class TimedText extends Text {
	
	public long ttl;
	private long age;

	/**
	 * Creates a Timed Text Drawable.
	 * @param c Color
	 * @param s String
	 * @param x
	 * @param y
	 * @param ttl Time to Live in seconds
	 */
	public TimedText(Color c, String s, int x, int y, long ttl) {
		super(c, s, x, y);
		this.ttl = ttl;
	}
	
	/**
	 * Creates a Timed Text Drawable.
	 * @param s String
	 * @param x
	 * @param y
	 * @param ttl Time to Live in seconds
	 */
	public TimedText(String s, int x, int y, long ttl) {
		this(Color.WHITE, s, x, y, ttl);
	}
	
	/**
	 * Updates this object by advancing the age by one frame.<br>
	 * If the age >= the ttl, the object is set to be destroyed.
	 */
	public void update() {
		updateText();
		age++;
		if(age >= ttl*60) {
			destroy = true;
		}
	}
	
	public abstract void updateText();

}
