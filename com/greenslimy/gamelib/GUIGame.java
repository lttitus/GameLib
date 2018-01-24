package com.greenslimy.gamelib;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.greenslimy.gamelib.display.Display;
import com.greenslimy.gamelib.display.graphics.Drawable;

public abstract class GUIGame extends Game implements KeyListener, MouseListener {

	public int fps = 0;
	protected Display disp;
	private int w, h;
	
	protected final boolean[] keysPressed = new boolean[200];
	
	public GUIGame(String title, int w, int h) {
		super(title);
		this.w = w;
		this.h = h;
		init();
	}
	
	public GUIGame(int w, int h) {
		this("No name given.", w, h);
	}
	
	public GUIGame(String title) {
		this(title, 800, 600);
	}
	
	public GUIGame() {
		this(800, 600);
	}
	
	protected void init() {
		disp = new Display(title, w, h);

		/** This class should handle all incoming user events. */
		disp.addMouseListener(this);
		disp.addKeyListener(this);
	}
	
	/**
	 * Adds a Drawable graphic that is constantly updated
	 * @param d The Drawable object
	 */
	public boolean addDrawable(Drawable d) {
		return disp.addDrawable(d);
	}

	protected Point mousePoint;
	/**
	 * Calls <b>logicUpdate()</b>, automatically handles updating and destroying(removing) Drawables.<br>
	 */
	private void logic() {
		mousePoint = getMousePosition();
		logicUpdate();	//Leave the logic updates to the user of the framework.
	}
	
	protected boolean mPressed = false;
	protected boolean mLeftPressed = false;
	protected boolean mRightPressed = false;
	protected int mpx, mpy;
	
	/**
	 * Called every update, right before rendering the drawables.
	 */
	protected abstract void logicUpdate();
	
	private long curTime, lastTime = System.currentTimeMillis();
	private int frameCount = 0;
	protected void gameUpdate() {
		frameCount++;
		if(curTime-lastTime>=1000/60) {
			fps = frameCount;
			frameCount = 0;
			logic();
			disp.render();
			lastTime = System.currentTimeMillis();
		}
		curTime = System.currentTimeMillis();
	}
	
	/**
	 * This method is not really used, as we have it handled in keyPressed(ke).
	 */
	public void keyTyped(KeyEvent ke) {	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("Key Pressed: "+ke.getKeyCode());
		this.keysPressed[ke.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent ke) {
		System.out.println("Key Released: "+ke.getKeyCode());
		this.keysPressed[ke.getKeyCode()] = false;
	}
	
	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	protected Point mousePressPoint;
	public void mousePressed(MouseEvent me) {
		mPressed = true;
		mousePressPoint = getMousePosition();
		/*mpx = me.getX();
		mpy = me.getY();*/
		if(me.getButton() == MouseEvent.BUTTON1) {	//Left
			mLeftPressed = true;
		}else if(me.getButton() == MouseEvent.BUTTON3) {	//Right
			mRightPressed = true;
		}
		mousePress();
	}

	public void mouseReleased(MouseEvent me) {
		mPressed = false;
		if(me.getButton() == MouseEvent.BUTTON1) {	//Left
			mLeftPressed = false;
		}else if(me.getButton() == MouseEvent.BUTTON3) {	//Right
			mRightPressed = false;
		}
		mouseRelease();
	}
	
	public Point getMousePosition() {
		Point dim = MouseInfo.getPointerInfo().getLocation();
		return new Point(dim.x, dim.y);
	}
	
	protected abstract void mousePress();
	protected abstract void mouseRelease();

}
