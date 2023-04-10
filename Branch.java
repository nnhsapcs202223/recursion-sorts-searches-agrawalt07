import javax.swing.*; 
import java.awt.*;
import java.awt.MouseInfo;
 
/**
 * Write a description of class Branch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Branch extends JComponent
{
    private int angle;
    
    public void drawFractalTree(int x, int y, double a, Graphics2D g2, int h, int t, int i){
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
        drawFractalTree(x2,y2,a-i,g2, h-1, t-1, i);
        drawFractalTree(x2,y2,a+i,g2, h-1, t-1, i);
    }
    
    public void setAngle(int a)
    {
        angle = a;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        drawFractalTree(400,700, -90, g2, 10, 11, angle);
    }


}