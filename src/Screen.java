import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO; //using collections
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Screen extends JPanel {









    public void paintComponent(Graphics g) { //paints everything
		super.paintComponent(g);
        g.fillRect(100, 100, 200, 200);
    }


}