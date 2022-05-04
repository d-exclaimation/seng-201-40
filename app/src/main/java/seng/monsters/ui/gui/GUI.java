package seng.monsters.ui.gui;

import seng.monsters.model.GameManager;

/**
 * The GUI class manager to handle window navigation and closing
 */
public final class GUI {
	/** The GameManager for the GUI */
	private final GameManager gameManager;
	
	/** Currently active screen */
	private Screen activeScreen;
	
	public GUI() {
		gameManager = new GameManager();
		activeScreen = new TitleScreen(this, gameManager);
		activeScreen.initialize();
	}
	
	/**
	 * Navigate to a new Java Swing Screen.
	 * 
	 * This will close the currently active screen and replace it with the new one.
	 * 
	 * If you are planning to display a pop out, just display the JFrame normally
	 * 
	 * @param screen The UI Screen to be displayed
	 */
	public void navigateTo(Screen screen) {
		final var oldScreen = activeScreen;
		activeScreen = screen;
		activeScreen.initialize();
		oldScreen.dispose();
	}
	
	/**
	 * Close the active screen and end the entire application (no screen left)
	 */
	public void quit() {
		activeScreen.dispose();
	}
}
