import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends JPanel {
    private Screen window;
    
    private int sliderValue1 = 50;
    private int sliderValue2 = 50;
    private int sliderValue3 = 50;

    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;

    public Settings(Screen screen) {
        window = screen;

        // Initialize sliders with a range of 0 to 100
        slider1 = new JSlider(0, 100, sliderValue1);
        slider2 = new JSlider(0, 100, sliderValue2);
        slider3 = new JSlider(0, 100, sliderValue3);

        // Set layout for the panel
        setLayout(new GridLayout(3, 2)); // 3 sliders and labels

        // Add sliders to the panel
        add(new JLabel("Slider 1:"));
        add(slider1);
        add(new JLabel("Slider 2:"));
        add(slider2);
        add(new JLabel("Slider 3:"));
        add(slider3);

        // Add change listeners to update the private variables when sliders are changed
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue1 = slider1.getValue();
                System.out.println("Slider 1 value: " + sliderValue1);
            }
        });

        slider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue2 = slider2.getValue();
                System.out.println("Slider 2 value: " + sliderValue2);
            }
        });

        slider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue3 = slider3.getValue();
                System.out.println("Slider 3 value: " + sliderValue3);
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // You can also render something based on slider values here
    }

    // Getters for the private variables
    public int getSliderValue1() {
        return sliderValue1;
    }

    public int getSliderValue2() {
        return sliderValue2;
    }

    public int getSliderValue3() {
        return sliderValue3;
    }

    // Example of how you could use this in your window (Screen) class
    public static void main(String[] args) {
        JFrame frame = new JFrame("Settings");
        Settings settingsPanel = new Settings(null); // Pass your screen object here
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(settingsPanel);
        frame.setSize(400, 200); // Adjust the window size
        frame.setVisible(true);
    }
}
