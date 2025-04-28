import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO; //using collections
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private int totalruns;
    private int changeinangle;
    private int length;

    public Screen() {
        totalruns = 7;
        changeinangle = 10;
        length = 10;
    }
    public Screen(int runs, int changeangle, int len) {
        totalruns = runs;
        changeinangle = changeangle;
        length = len;
    }


    public void paintComponent(Graphics g) { //paints everything
		super.paintComponent(g);
        recursivetree(g, totalruns, 0, 500, 600, length, 270);
    }



    public void recursivetree(Graphics g, int total, int current, int x, int y, int length, int angle) {
        if(total == current) {
            return;
        }

        g.drawLine(x, y, x - (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length)); 
        g.drawLine(x, y, x + (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length)); 

        recursivetree(g, total, current + 1, x - (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);
        recursivetree(g, total, current + 1, x + (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);

    }

    public int getTotalruns() {
        return totalruns;
    }
    public void setTotalruns(int totalruns) {
        this.totalruns = totalruns;
    }
    public int getChangeinangle() {
        return changeinangle;
    }
    public void setChangeinangle(int changeinangle) {
        this.changeinangle = changeinangle;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    
}