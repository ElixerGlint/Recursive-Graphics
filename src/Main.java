import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Recursion");
		window.setSize(1000, 800);
		Screen gamepanel = new Screen();
		window.add(gamepanel);
		window.setVisible(true);

		JFrame settings = new JFrame();
		settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settings.setResizable(false);
		settings.setTitle("settings");
		settings.setSize(1000, 800);
		Settings settingspanel = new Settings();
		settings.add(settingspanel);
		settings.setVisible(true);

		
		window.repaint();
		
	}
}