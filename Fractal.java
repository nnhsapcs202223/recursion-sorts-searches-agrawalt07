import javax.swing.*; 
import java.awt.MouseInfo;
import javax.swing.event.*;
import java.awt.*; 
/**
 * Write a description of class Fractal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fractal extends JFrame
{
    // instance variables - replace the example below with your own
    
    private JFrame frame; 
    private JPanel panel; 
    private JSlider slider; 
    private JToolBar toolBar; 
    private JLabel angle; 
    private JSlider slider2; 
    private int i; 
    private Branch b;
    public Fractal(){
        this.i = 30;
        this.panel = new JPanel(); 
        this.panel.setSize(800,700);
        this.setSize(1200,800);
        this.b = new Branch();
        this.b.setPreferredSize(new Dimension(800,700));
        this.panel.add(b);
        this.add(this.panel, BorderLayout.WEST);
        this.toolBar = new JToolBar();
        this.slider = new JSlider(); 
        this.angle = new JLabel(); 
        this.angle.setText("Angle is: 0");
        this.slider  = new JSlider(JSlider.HORIZONTAL, 0, 180, 0); 
        this.slider2  = new JSlider(JSlider.HORIZONTAL, 0, 80, 0);
        this.add(slider);
        this.add(slider2);
        this.add(angle);
        this.toolBar.add(this.angle);
        this.toolBar.add(this.slider);
        this.toolBar.addSeparator(new Dimension(50,0));
        this.toolBar.add(this.slider2); 
        event e = new event(); 
        slider.addChangeListener(e);
        this.toolBar.setOrientation(JToolBar.VERTICAL);
        this.toolBar.setFloatable(false); 
        this.toolBar.setPreferredSize(new Dimension(400,100));
        this.add(this.toolBar, BorderLayout.EAST);
        this.setTitle("Fractal Tree"); 
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false);
        this.setVisible(true); 
    }
    public class event implements ChangeListener{
        public void stateChanged(ChangeEvent e){        
            i= slider.getValue();
            b.setAngle(i);
            //panel.removeAll();
            angle.setText("Angle is: " + i);
            repaint();
        }
    }
    public static void main(String[] args){
        Fractal fractal = new Fractal(); 
    }
    //@Override
    public void paint(Graphics g)
    {
        super.paint(g);
        b.repaint();
        //Graphics2D g2 = (Graphics2D) g; 
       //b.drawFractalTree(400,700, -90, g2, 10, 11, i); 
    }
}
