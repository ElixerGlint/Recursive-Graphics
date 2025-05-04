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
    
    /**
     * This is the no parameter constructor for screen
     */
    public Screen() {
        changeinangle = 10;
        length = 100;
        depth = 7;
        calcbranches();
        crazy = 0;
        colorshift = 0;
    }

    /**
     * This is the full parameter constructor for the screen
     * @param runs this represents the depth for the recursion of the program
     * @param changeangle this is for how much each stick deviates from the previous one
     * @param len this is how long the branches are
     */
    public Screen(int runs, int changeangle, int len) {
        depth = runs;
        changeinangle = changeangle;
        length = len;
        calcbranches();
        colorshift = 0;
        crazy = 0;
    }

    /**
     * This paints the branches with the current settings
     */
    public void paintComponent(Graphics g) { //paints everything
		super.paintComponent(g);
        recursivetree(g, depth, 0, 500, 600, length, 270);
        g.setColor(Color.white);
        g.drawString("Total branches: " + branches, 10, 20);
    }

    /**
     * This calculates the total amount of branches, and updates the value whenever the slider switches to a different depth
     */
    public void calcbranches() {
        int output = 0;

        int temp = depth;
        while(temp >= 1) {
            output += Math.pow(2, temp-1);
            temp--;
        }
        branches = output;
    }

    /**
     * This draws out the recursive pattern
     * @param g the graphics driver
     * @param total how many layers deep the program goes
     * @param current the current layer it is on
     * @param x the x position (of the start of the stick)
     * @param y the y position
     * @param length the length of the stick
     * @param angle the angle that the stick deviates from the terminal axis
     */
    public void recursivetree(Graphics g, int total, int current, int x, int y, int length, int angle) {
        if(total == current) { //kicking out if its reached the correct layer
            return;
        }
        
        //color changing based on layer
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


        //drawing the two lines for each line
        g.drawLine(x, y, x - (int)(Math.cos(Math.toRadians(angle+crazy))*length), y + (int)(Math.sin(Math.toRadians(angle+crazy))*length)); 
        
        g.drawLine(x, y, x + (int)(Math.cos(Math.toRadians(angle+crazy))*length), y + (int)(Math.sin(Math.toRadians(angle+crazy))*length)); 

        //calling 2 more, one for the "left" branch and one for the "right"
        recursivetree(g, total, current + 1, x - (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);
        recursivetree(g, total, current + 1, x + (int)(Math.cos(Math.toRadians(angle))*length), y + (int)(Math.sin(Math.toRadians(angle))*length), length, angle + changeinangle);

    }

    //getters and setters
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