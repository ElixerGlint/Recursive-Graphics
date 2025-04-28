import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Recursion");
		window.setSize(1000, 800);
		Screen gamepanel = new Screen();
		gamepanel.setBackground(Color.BLACK);
		window.add(gamepanel);
		window.setVisible(true);

		String[] choices = {"Automatic","Manual"};
		String whichcolor = (String)(JOptionPane.showInputDialog(null, "How would you like to operate this technology", "Control selector",JOptionPane.QUESTION_MESSAGE,null,choices,choices[0])); 

		if(whichcolor.equals("Manual")) {
			JFrame settings = new JFrame();
			settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			settings.setResizable(false);
			settings.setTitle("settings");
			settings.setSize(1000, 800);
			Settings settingspanel = new Settings(gamepanel);
			settings.add(settingspanel);
			settings.setVisible(true);
		}

		else {
			while(true) {
				gamepanel.setChangeinangle(gamepanel.getChangeinangle()+1);
				window.repaint();
				if(gamepanel.getChangeinangle() == 360) {
					gamepanel.setChangeinangle(0);
				}
				Thread.sleep(10);
			}
		}

		

		
		window.repaint();
		
	}
}