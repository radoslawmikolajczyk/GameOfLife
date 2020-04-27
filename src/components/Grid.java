package components;

import screen.Screen;

import java.awt.*;

/**
 * This class is drawing a grid on the window
 *
 * @see Screen
 * @author Radosław Mikołajczyk
 */

public class Grid {

    /**
     * @param width copy a window width
     * @param height copy a window height
     * @param rows sets number of grid rows
     * @param cols sets number of grid columns
     */

    private int width = Screen.WIDTH;
    private int height = Screen.HEIGHT;
    private int rows = height/(Board.CELLS);
    private int cols = width/(Board.CELLS);

    /**
     * Method draws a grid using method drawLine
     * @see Graphics2D
     * @param g2d draws lines
     */
    public void draw(Graphics2D g2d){
        for (int i = 0; i < Board.CELLS; i++){
            g2d.drawLine(0,i*rows,width,i*rows);
        }

        for (int i = 0; i < Board.CELLS; i++){
            g2d.drawLine(i*cols,0,i*cols,height);
        }
    }
}
