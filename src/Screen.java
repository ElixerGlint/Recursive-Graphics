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
    private int branches;
    private int colorshift;
    private int crazy; //max 180
    

    public Screen() {
        changeinangle = 10;
        length = 100;
        depth = 7;
        calcbranches();
        crazy = 0;
        colorshift = 0;
    }
    public Screen(int runs, int changeangle, int len) {
        depth = runs;
        changeinangle = changeangle;
        length = len;
        calcbranches();
        colorshift = 0;
        crazy = 0;
    }


    public void paintComponent(Graphics g) { //paints everything
		super.paintComponent(g);
        recursivetree(g, depth, 0, 500, 600, length, 270);
        g.setColor(Color.white);
        g.drawString("Total branches: " + branches, 10, 20);
    }

    public void calcbranches() {
        int output = 0;

        int temp = depth;
        while(temp >= 1) {
            output += Math.pow(2, temp-1);
            temp--;
        }
        branches = output;
    }



    public void recursivetree(Graphics g, int total, int current, int x, int y, int length, int angle) {
        if(total == current) {
            return;
        }
        
        if((current + colorshift)%6 == 0) {
            g.setColor(java.awt.Color.RED);
        }
        if((current + colorshift)%6 == 1) {
            g.setColor(java.awt.Color.ORANGE);
        }
        if((current + colorshift)%6 == 2) {
            g.setColor(java.awt.Color.YELLOW);
        }
        if((current + colorshift)%6 == 3) {
            g.setColor(java.awt.Color.GREEN);
        }
        if((current + colorshift)%6 == 4) {
            g.setColor(java.awt.Color.BLUE);
        }
        if((current + colorshift)%6 == 5) {
            g.setColor(java.awt.Color.PINK);
        }


        g.drawLine(x, y, x - (int)(Math.cos(Math.toRadians(angle+crazy))*length), y + (int)(Math.sin(Math.toRadians(angle+crazy))*length)); 
        
        g.drawLine(x, y, x + (int)(Math.cos(Math.toRadians(angle+crazy))*length), y + (int)(Math.sin(Math.toRadians(angle+crazy))*length)); 

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
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getBranches() {
        return branches;
    }
    public void setBranches(int branches) {
        this.branches = branches;
    }
    public int getColorshift() {
        return colorshift;
    }
    public void setColorshift(int colorshift) {
        this.colorshift = colorshift;
    }
    public int getCrazy() {
        return crazy;
    }
    public void setCrazy(int crazy) {
        this.crazy = crazy;
    }
    
}