import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends JPanel {
    private Screen window;

    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JSlider slider4;
    private JSlider slider5;

    /**
     * This is the one parameter constructor for the settings panel
     * @param screen this is the screen, allows us to grab variables from it with ease
     */
    public Settings(Screen screen) {
        window = screen;
        //settings up all of the different sliders used for different things (length, angle, color, ect)
        slider1 = new JSlider(0, 360, 10);
        slider2 = new JSlider(1, 300, 100);
        slider3 = new JSlider(1, 20, 7);
        slider4 = new JSlider(0, 5, 0);
        slider5 = new JSlider(0, 360, 0);

        //This standardizes the lengths of the new panel created
        setLayout(new GridLayout(5, 2)); // 3 sliders and labels

        //This gives text to the sliders and adds them to the panel
        add(new JLabel("Angle:"));
        add(slider1);
        add(new JLabel("Length (zoom):"));
        add(slider2);
        add(new JLabel("Depth"));
        add(slider3);
        add(new JLabel("Colorshift"));
        add(slider4);
        add(new JLabel("Fun amount"));
        add(slider5);

        //below are all of the listeners. When they change value they update private variables in the Screen and repaints
        slider1.addChangeListener(new ChangeListener() { //angle
            public void stateChanged(ChangeEvent e) {
                window.setChangeinangle(slider1.getValue());
                screen.repaint();
            }
        });

        slider2.addChangeListener(new ChangeListener() { // length
            public void stateChanged(ChangeEvent e) {
                window.setLength(slider2.getValue());
                screen.repaint();
            }
        });

        slider3.addChangeListener(new ChangeListener() { //depth
            public void stateChanged(ChangeEvent e) {
                window.setdepth(slider3.getValue());
                window.calcbranches(); //calls this because this is the only thing that would change the amount of branches
                screen.repaint();
            }
        });

        slider4.addChangeListener(new ChangeListener() { //depth
            public void stateChanged(ChangeEvent e) {
                window.setColorshift(slider4.getValue());
                screen.repaint();
            }
        });

        slider5.addChangeListener(new ChangeListener() { //depth
            public void stateChanged(ChangeEvent e) {
                window.setCrazy(slider5.getValue());
                screen.repaint();
            }
        });
    }

    //required
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //getters and setters
    public int getSliderValue1() {
        return slider1.getValue();
    }

    public int getSliderValue2() {
        return slider2.getValue();
    }

    public int getSliderValue3() {
        return slider3.getValue();
    }

    public Screen getWindow() {
        return window;
    }

    public void setWindow(Screen window) {
        this.window = window;
    }

    public JSlider getSlider1() {
        return slider1;
    }

    public void setSlider1(JSlider slider1) {
        this.slider1 = slider1;
    }

    public JSlider getSlider2() {
        return slider2;
    }

    public void setSlider2(JSlider slider2) {
        this.slider2 = slider2;
    }

    public JSlider getSlider3() {
        return slider3;
    }

    public void setSlider3(JSlider slider3) {
        this.slider3 = slider3;
    }

    public JSlider getSlider4() {
        return slider4;
    }

    public void setSlider4(JSlider slider4) {
        this.slider4 = slider4;
    }

    public JSlider getSlider5() {
        return slider5;
    }

    public void setSlider5(JSlider slider5) {
        this.slider5 = slider5;
    }

}
