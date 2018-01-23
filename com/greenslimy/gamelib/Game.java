package com.greenslimy.gamelib;

public abstract class Game implements Runnable {
	
	protected String title;
	
	public Game(String title) {
		this.title = title;
		//inited = true;
	}
	
	public Game() {
		this("No title given.");
	}
	
	boolean inited = false;
	protected abstract void init();
	
	public String getTitle() {
		return this.title;
	}
	
	boolean living = true;
	public void run() {
		//while(!inited) {continue;};	//Do not start until we are ready!
		
		System.out.println(title+ " Started");
		while(living) {
			gameUpdate();
		}
		System.err.println(title+" Dead");
	}
	
	protected abstract void gameUpdate();
	
}
