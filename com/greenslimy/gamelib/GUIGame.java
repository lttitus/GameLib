package com.greenslimy.gamelib;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import com.greenslimy.gamelib.display.Display;
import com.greenslimy.gamelib.display.graphics.Drawable;

public abstract class GUIGame extends Game implements KeyListener {

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
		disp.canv.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {

			}

			public void mouseEntered(MouseEvent arg0) {

			}

			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent me) {
				mPressed = true;
				mpx = me.getX();
				mpy = me.getY();
				if(me.getButton() == MouseEvent.BUTTON1) {	//Left
					mLeftPressed = true;
					leftClicked();
				}else if(me.getButton() == MouseEvent.BUTTON3) {	//Right
					mRightPressed = true;
					rightClicked();
				}
				GUIGame.this.mouseClicked();
			}

			public void mouseReleased(MouseEvent me) {
				mPressed = false;
				if(me.getButton() == MouseEvent.BUTTON1) {	//Left
					mLeftPressed = false;
				}else if(me.getButton() == MouseEvent.BUTTON3) {	//Right
					mRightPressed = false;
				}
			}
			
		});
		disp.canv.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent me) {
				mcx = me.getX();
				mcy = me.getY();
			}

			public void mouseMoved(MouseEvent me) {
				mcx = me.getX();
				mcy = me.getY();
			}
		});
		disp.addKeyListener(this);
	}
	
	/**
	 * Adds a Drawable graphic that is constantly updated
	 * @param d The Drawable object
	 */
	public boolean addDrawable(Drawable d) {
		return disp.addDrawable(d);
	}

	private Drawable d;
	/**
	 * Calls <b>logicUpdate()</b>, automatically handles updating and destroying(removing) Drawables.<br>
	 * <b>Drawable.update()</b> is called from here.<br>
	 * <b>Drawable.removed()</b> is called after the Drawable is destroyed.
	 */
	private void logic() {
		logicUpdate();
		for(Iterator<Drawable> i=disp.canv.drawables.iterator();i.hasNext();) {
			d = i.next();	//This cannot be in the above for loop for some reason.
			if(d != null) {
				if(!d.destroy) {
					d.update();
				}else{
					i.remove();	//This is to avoid the ConcurrentModificationException.
					d.removed();
				}
			}
		}
	}
	
	protected boolean mPressed = false;
	protected boolean mLeftPressed = false;
	protected boolean mRightPressed = false;
	protected int mpx, mpy;
	protected int mcx, mcy;
	
	/**
	 * Called every update, right before rendering.
	 */
	protected abstract void logicUpdate();
	/**
	 * Called when the user left clicks on the Display.<br>
	 * <p>Modified variables:<br>
	 * <b>boolean mPressed<br>
	 * boolean mLeftPressed<br>
	 * int mpx<br>
	 * int mpy</b></p>
	 */
	protected abstract void leftClicked();
	/**
	 * Called when the user right clicks on the Display.<br>
	 * <p>Modified variables:<br>
	 * <b>boolean mPressed<br>
	 * boolean mRightPressed<br>
	 * int mpx<br>
	 * int mpy</b></p>
	 */
	protected abstract void rightClicked();
	/**
	 * Called when the user clicks on the Display.<br>
	 * Called after <b>leftClicked</b> and <b>rightClicked</b> voids.<br>
	 * <p>Modified variables:<br>
	 * <b>boolean mPressed<br>
	 * int mpx<br>
	 * int mpy</b></p>
	 */
	protected abstract void mouseClicked();
	
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
			//System.out.println("Mouse: "+mpx+", "+mpy+", "+mcx+", "+mcy);
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

}
