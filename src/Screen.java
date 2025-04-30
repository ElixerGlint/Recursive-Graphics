import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO; //using collections
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Screen extends JPanel {
    private int depth;
    private int changeinangle;
    private int length;
    

    public Screen() {
        changeinangle = 10;
        length = 100;
        depth = 7;
    }
    public Screen(int runs, int changeangle, int len) {
        depth = runs;
        changeinangle = changeangle;
        length = len;
    }


    public void paintComponent(Graphics g) { //paints everything
		super.paintComponent(g);
        recursivetree(g, depth, 0, 500, 600, length, 270);
    }



    public void recursivetree(Graphics g, int total, int current, int x, int y, int length, int angle) {
        if(total == current) {
            return;
        }
        
        if(current%6 == 0) {
            g.setColor(java.awt.Color.RED);
        }
        if(current%6 == 1) {
            g.setColor(java.awt.Color.ORANGE);
        }
        if(current%6 == 2) {
            g.setColor(java.awt.Color.YELLOW);
        }
        if(current%6 == 3) {
            g.setColor(java.awt.Color.GREEN);
        }
        if(current%6 == 4) {
            g.setColor(java.awt.Color.BLUE);
        }
        if(current%6 == 5) {
            g.setColor(java.awt.Color.PINK);
        }



        g.drawLine(x, y, x - (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length)); 
        
        g.drawLine(x, y, x + (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length)); 

        recursivetree(g, total, current + 1, x - (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);
        recursivetree(g, total, current + 1, x + (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);

    }

    public int getdepth() {
        return depth;
    }
    public void setdepth(int totalruns) {
        this.depth = totalruns;
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