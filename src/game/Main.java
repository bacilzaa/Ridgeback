package game;

import javax.swing.JFrame;

import game.main.GamePanel;

public class Main {

	public static void main(String args[]){
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Ridgeback");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		gamePanel.startGameThread();
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
