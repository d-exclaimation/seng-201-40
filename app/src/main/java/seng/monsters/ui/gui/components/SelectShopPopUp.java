package seng.monsters.ui.gui.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import seng.monsters.model.GameManager;
import seng.monsters.ui.gui.GUI;
import seng.monsters.ui.gui.ItemShopScreen;
import seng.monsters.ui.gui.MonsterShopScreen;

public final class SelectShopPopUp extends PopUp {
	private final GUI gui;
	private final GameManager gameManager;
	
	/**
     * Create the application.
     */
    public SelectShopPopUp(GUI gui, GameManager gameManager) {
    	this.gui = gui;
    	this.gameManager = gameManager;
        render();
    }

    private void render() {
        // Title label using the name of the monster
        JLabel titleLabel = new JLabel("Choose which shop to go to");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        titleLabel.setBounds((PopUp.WIDTH - 600) / 2, 52, 600, 39);
        frame.getContentPane().add(titleLabel);

        	JButton itemShopButton = new JButton("Item Shop");
        	itemShopButton.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        	itemShopButton.setBounds((PopUp.WIDTH - 200) / 2, 160, 200, 60);
        	frame.getContentPane().add(itemShopButton);

        	JButton monsterShopButton = new JButton("Monster Shop");
        	monsterShopButton.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        	monsterShopButton.setBounds((PopUp.WIDTH - 200) / 2, 280, 200, 60);
        	monsterShopButton.setEnabled(!gameManager.getShop().getMonsterStock().isEmpty());
        	frame.getContentPane().add(monsterShopButton);

            
        	JButton backToMainMenu = new JButton();
        backToMainMenu.setText("Main menu");
        backToMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
        backToMainMenu.setBounds(330, 398, 156, 30);
        frame.getContentPane().add(backToMainMenu);  
        	
        	monsterShopButton.addActionListener(goToMonsterShopAction());
        	itemShopButton.addActionListener(goToItemShopAction());
        	backToMainMenu.addActionListener(backToMainMenuAction());
        	
        frame.setVisible(true);
    }
    
    private ActionListener goToMonsterShopAction() {
    	return e -> {
    		if (gameManager.getShop().getMonsterStock().isEmpty()) 
    			return;
    		gui.navigateTo(new MonsterShopScreen(gui, gameManager));
    		frame.dispose();
    	};
    }
    
    private ActionListener goToItemShopAction() {
    	return e -> {
    		gui.navigateTo(new ItemShopScreen(gui, gameManager));
    		frame.dispose();
    	};
    }
    
    /**
     * The action performed when the user chose to return the main menu
     */
    private ActionListener backToMainMenuAction() {
        return ignoredEvent -> frame.dispose();
    }
}
