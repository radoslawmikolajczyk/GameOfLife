package components;

import screen.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class which creates boxes on the board
 *
 * @author Radosław Mikołajczyk
 */

public class Box {

    private int xPosition;
    private int yPosition;
    private Color color;

    /**
     * Box constructor
     * @param xPosition sets x position
     * @param yPosition sets y position
     * @see #findColor()
     */

    public Box(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        findColor();
    }

    /**
     * Method draws objects of Box class
     * @param g2d is drawing rectangle
     */

    public void draw(Graphics2D g2d){

        g2d.drawRect(xPosition,yPosition, Screen.WIDTH/(Board.CELLS),Screen.HEIGHT/(Board.CELLS));
        g2d.setColor(color);
        g2d.fillRect(xPosition,yPosition, Screen.WIDTH/(Board.CELLS),Screen.HEIGHT/(Board.CELLS));
    }

    /**
     * Method is setting colors basics on array from Board class, when value is 1 color is red, when value is 0 color is white
     */

    public void findColor(){
        int scale = Screen.WIDTH/(Board.CELLS);
        if(Board.array[xPosition/scale][yPosition/scale] == 1){
            color = Color.RED;
        } else {
            color = Color.WHITE;
        }
    }
}
