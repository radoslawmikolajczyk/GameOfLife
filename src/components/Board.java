package components;

import java.util.Random;

/**
 * This is a class which is representing the status of each boxes
 *
 * @author Radosław Mikołajczyk
 */

public class Board {

    /**
     * @param CELLS is a number of cells
     * @param array is an array with values 0 or 1 (dead or live)
     * @param nextArray is helpful parameter for next move in animation
     */

    public static final int CELLS = 50;
    public static int[][] array = new int[CELLS][CELLS];
    public static int[][] nextArray = new int[CELLS][CELLS];

    /**
     * Creates first pattern as a random array, where there is half cells dead (0) and live (1)
     */
    public static void firstPattern(){
        Random random = new Random();
        int deadCounter = 0;
        int liveCounter = 0;

        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                int r = random.nextInt(2);
                if (r == 0){
                    deadCounter++;
                } else {
                    liveCounter++;
                }
                if (deadCounter <= 1250){
                    array[i][j] = 1;
                } else if (liveCounter <= 1250){
                    array[i][j] = 0;
                }
                array[i][j] = r;
            }
        }
    }

    /**
     * Creates array according to second pattern
     */

    public static void secondPattern(){

        array[23][22] = 1;
        array[24][22] = 1;
        array[25][23] = 1;
        array[26][24] = 1;
        array[26][25] = 1;
        array[26][26] = 1;
        array[25][27] = 1;
        array[24][28] = 1;
        array[23][28] = 1;

    }

    /**
     * Creates array according to third pattern
     */

    public static void thirdPattern(){
        array[20][28] = 1;
        array[21][28] = 1;
        array[25][28] = 1;
        array[26][28] = 1;
        array[20][27] = 1;
        array[20][26] = 1;
        array[21][24] = 1;
        array[21][23] = 1;
        array[22][27] = 1;
        array[22][26] = 1;
        array[22][25] = 1;
        array[22][24] = 1;
        array[22][23] = 1;
        array[26][27] = 1;
        array[26][26] = 1;
        array[24][27] = 1;
        array[24][26] = 1;
        array[24][25] = 1;
        array[24][24] = 1;
        array[24][23] = 1;
        array[25][24] = 1;
        array[25][23] = 1;
    }
}
