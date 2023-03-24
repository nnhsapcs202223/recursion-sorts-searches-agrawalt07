import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * This DataPlotter object reads a space delimited text file of elevations
 * and plots the result as a range of greyscale images, and then calculates 
 * and plots the steepest downward path from each location in the image.
 * 
 * @author 
 * @version 
 */
public class DataPlotter
{
    private static String fileName = "Colorado";
    private static int[][] grid;
    private static DrawingPanel panel;
    private static Scanner fileReader;
    private static int rows, cols;

    public static void main(String[] args) throws IOException
    {
        readValues();
        plotData();
        try {Thread.sleep(3000); } catch (Exception e){};  // pause display for 3 seconds
        plotAllPaths();
    }

    private static void readValues() throws IOException
    {
        fileReader = new Scanner(new File(fileName + ".dat"));
        rows = fileReader.nextInt();    // first integer in file
        cols = fileReader.nextInt();    // second integer in file

        // instantiate and initialize the instance variable grid 
        grid = new int[rows][cols];
        // then read all of the data into the array in row major order
        for(int x = 0; x<rows; x++){
            for(int y = 0; y<cols; y++){
                grid[x][y] = fileReader.nextInt(); 
            }
        }
        System.out.println(grid[0][0]+" "+grid[0][cols-1]+ " " + grid[rows-1][0] + " " + grid[rows-1][cols-1]);
    }

    // plot the altitude data read from file
    private static void plotData()
    {
        panel = new DrawingPanel(cols, rows);
        int highest = grid[0][0]; 
        int lowest = grid[0][0]; 
        
        for(int x = 0; x<rows; x++){
            for(int y = 0; y<cols; y++){
                if(grid[x][y] > highest){
                    highest  = grid[x][y];
                }
                if(grid[x][y] < lowest){
                    lowest = grid[x][y];
                }
            }
        }  
        
        
        for(int x = 0; x<rows; x++){
            for(int y = 0; y<cols; y++){
                double sf = (grid[x][y] - (double)lowest) / ((double)highest - (double)lowest);
                int val = (int)(255 * sf);
                
                Color color = new Color(val, val, val);
                panel.setPixel(y, x, color);
            }
        }
        
    }

    // for a given x, y value, plot the downhill path from there
    private static void plotDownhillPath(int x, int y)
    {
        int yCor = 0; 
        int xCor = 0;
        int score = 100000; 
        for(int i = -1; i<2; i++){
            for(int j = -1; j<2; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                try{
                    int x_ = x+i; 
                    int y_ = y+j; 
                    if(grid[x_][y_]<score){
                        score = grid[x_][y_];
                        xCor = x_; 
                        yCor = y_;
                    }
                    
                }
                catch(Exception e){
                    
                }
            }
        }
        if(score>grid[x][y]){
            return; 
        }
                panel.setPixel(x, y, Color.blue);

        plotDownhillPath(xCor, yCor);
        
    }

    private static void plotAllPaths()
    {
        plotDownhillPath(0, 0);
    }

}