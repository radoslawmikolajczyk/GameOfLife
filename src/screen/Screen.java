package screen;

import components.Board;
import components.Box;
import components.Grid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is drawing a grid on the window, boxes and animate Conway's Game of Life
 *
 * @see javax.swing.JPanel
 * @author Radosław Mikołajczyk
 */

public class Screen extends JPanel {

    /**
     * @param WIDTH sets width of window
     * @param HEIGHT sets height of window
     * @param scale sets size of boxes
     * @param pattern is a pointer on current pattern, values between <1,3>
     * @param boxes is a list of Box objects
     * @param grid creates grid on window
     */

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private int scale = Screen.WIDTH/(Board.CELLS);
    private int pattern = 1;

    List<Box> boxes = new ArrayList<>();
    Grid grid = new Grid();

    /**
     * Screen constructor is set as default on first pattern
     * It adds boxes to a list and starts animation
     * @see #addBoxes()
     * @see AnimationThread
     */

    public Screen(){
        Board.firstPattern();
        addBoxes();
        animation.start();
    }

    /**
     * Method is adding boxes to the list, position is multiplied by a scale to get a good view
     */

    public void addBoxes(){
        for(int i = 0; i < Board.CELLS; i++) {
            for (int j = 0; j < Board.CELLS; j++) {
                boxes.add(new Box(i * scale,j*scale));
            }
        }
    }

    /**
     * Inner class which extends from Thread class and is responsible for running app
     * @see Thread
     */

    class AnimationThread extends Thread{

        /**
         * Method runs Conway's Game of Life, change values in board and refresh colors of boxes
         * @see #changeBoard()
         * @see #repaint()
         */
        @Override
        public void run() {
            while (true) {
                changeBoard();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (Box b : boxes){
                    b.findColor();
                }
                repaint();
            }
        }
    }

    /**
     * @param animation private object of inner class which runs app
     */

    private AnimationThread animation = new AnimationThread();

    /**
     * Method checks the rules of Conway's Game of Life and refresh the values of the array
     * @param i is first index number
     * @param j is second index number
     * @return 0 or 1
     */

    public int check(int i, int j){
        int neighbors = 0;
        if(j > 0){
            if(Board.array[i][j-1] == 1) neighbors++;
            if(i>0) if(Board.array[i-1][j-1] == 1) neighbors++;
            if(i<Board.CELLS-1) if(Board.array[i+1][j-1] == 1) neighbors++;
        }
        if(j < Board.CELLS-1){
            if(Board.array[i][j+1] == 1) neighbors++;
            if(i>0) if(Board.array[i-1][j+1] == 1) neighbors++;
            if(i<Board.CELLS-1) if(Board.array[i+1][j+1] == 1) neighbors++;
        }
        if(i>0) if(Board.array[i-1][j] == 1) neighbors++;
        if(i<Board.CELLS-1) if(Board.array[i+1][j] == 1) neighbors++;
        if(neighbors == 3) return 1;
        if(Board.array[i][j] == 1 && neighbors == 2) return 1;
        return 0;
    }

    /**
     * Method refresh values in the arrays, first of all adding to help variable
     * nextArray values, and the assign it to 'main' array
     * @see Board
     */

    public void changeBoard(){

        for (int i = 0; i < Board.CELLS; i++){
            for (int j = 0; j < Board.CELLS; j++){
                Board.nextArray[i][j] = check(i,j);
            }
        }
        for (int i = 0; i < Board.CELLS; i++){
            System.arraycopy(Board.nextArray[i], 0, Board.array[i], 0, Board.CELLS);
        }
    }

    /**
     * Method is updating pattern, when enter is pressed value of pattern increase
     * When pattern value is 3 then the next enter make it number 1
     *
     */
    public void changePattern(){
        ++pattern;
        if(pattern > 3)
            pattern = 1;

        Board.array = new int[Board.CELLS][Board.CELLS];
        switch (pattern){
            case 1:
                Board.firstPattern();
                break;
            case 2:
                Board.secondPattern();
                break;
            case 3:
                Board.thirdPattern();
                break;
        }
    }

    /**
     * Method draw boxes and grid on the window
     * @param g is drawing components
     * @see Graphics
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Box b : boxes){
            b.draw(g2);
        }
        g2.setColor(Color.BLACK);
        grid.draw(g2);
    }
}
