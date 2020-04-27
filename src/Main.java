import screen.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main class which launch the program
 *
 * @see java.awt.Frame
 * @author Radosław Mikołajczyk
 */

public class Main extends JFrame{

    /**
     * @param screen creates container with content pane
     */

    Screen screen = new Screen();

    /**
     * No-argument constructor initializes frame, sets content pane
     * @see #build()
     */

    Main(){
        setTitle("Game of Life");
        setContentPane(screen);
        setSize(Screen.WIDTH,Screen.HEIGHT+37);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        build();
    }

    /**
     * Adds key listener for ENTER to frame
     */

    void build(){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    screen.changePattern();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };

        addKeyListener(listener);
    }

    /**
     *Main method launches the program
     */

    public static void main(String[] args) {
        Main main = new Main();
    }
}
