import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends JPanel {
    private Screen window;

    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;

    public Settings(Screen screen) {
        window = screen;

        slider1 = new JSlider(0, 360, 50);
        slider2 = new JSlider(1, 300, 120);
        slider3 = new JSlider(1, 20, 10);


        setLayout(new GridLayout(3, 2)); // 3 sliders and labels


        add(new JLabel("Angle:"));
        add(slider1);
        add(new JLabel("Length:"));
        add(slider2);
        add(new JLabel("Depth"));
        add(slider3);

        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                System.out.println("Slider 1 value: " + slider1.getValue());
                window.setChangeinangle(slider1.getValue());
                screen.repaint();
            }
        });

        slider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Slider 2 value: " + slider2.getValue());
                window.setLength(slider2.getValue());
                System.out.println(window.getLength());
                screen.repaint();
            }
        });

        slider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Slider 3 value: " + slider3.getValue());
                window.setdepth(slider3.getValue());
                screen.repaint();


            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }




    public int getSliderValue1() {
        return slider1.getValue();
    }

    public int getSliderValue2() {
        return slider2.getValue();
    }

    public int getSliderValue3() {
        return slider3.getValue();
    }
}
