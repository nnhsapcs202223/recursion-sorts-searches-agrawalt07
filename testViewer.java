import javax.swing.*; 
import javax.swing.event.*;
import java.awt.*; 

/**
 * Write a description of class testViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testViewer extends JFrame
{
    // instance variables - replace the example below with your own
    private JSlider slider;
    private JLabel label; 

    /**
     * Constructor for objects of class testViewer
     */
    public testViewer()
    {
     setLayout(new FlowLayout()); 
     slider  = new JSlider(JSlider.HORIZONTAL, 0, 20, 0); 
     slider.setMajorTickSpacing(5);
     slider.setPaintTicks(true); 
     this.add(slider); 
     label = new JLabel("Current value 0"); 
     
     event e = new event(); 
     slider.addChangeListener(e);
    }
    
    public class event implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            int i = slider.getValue(); 
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
