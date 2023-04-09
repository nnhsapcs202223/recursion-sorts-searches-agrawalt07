import javax.swing.*; 
import java.awt.*;
import java.awt.MouseInfo;
 
/**
 * Write a description of class Branch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Branch extends JFrame 
{
    public Branch()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
    }
    public void drawFractalTree(int x, int y, double a, Graphics2D g2, int h, int t){
        if(h==0){
            g2.setColor(Color.GREEN); 
            g2.fillOval(x-2,y,5,5);
            return;
            
        }
        int x2 = x+ (int)(Math.cos(Math.toRadians(a))*h *10); 
        int y2 = y+(int)(Math.sin(Math.toRadians(a))*h*10); 
        g2.setStroke(new BasicStroke(t));
        g2.setColor(new Color(102,51,0));
        g2.drawLine(x,y,x2,y2); 
        drawFractalTree(x2,y2,a-30,g2, h-1, t-1);
        drawFractalTree(x2,y2,a+30,g2, h-1, t-1);
    }
    //Taken from stackOverflow
    static double map(double value, double start1, double stop1, double start2, double stop2) {
        return (value - start1) / (stop1 - start1) * (stop2 - start2) + start2;
    }

    
    
    
    
    
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; 
        this.drawFractalTree(400,700, -90, g2, 10, 11); 
    }
    public static void run(){
        Branch tree = new Branch(); 
        tree.setSize(1000,800);
        tree.setVisible(true); 
        tree.setTitle("Fractal Tree"); 
        tree.setBackground(Color.BLACK);
    }
}
