package mySnake.views;

import mySnake.controllers.Controller;
import mySnake.views.SnakeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class SnakeBoard extends JPanel implements ActionListener
{
    private final int BOARD_WIDTH = 20;
    private final int BOARD_HEIGHT = 20;
    private JLabel scoreBar;

    private Controller controller;

    public SnakeBoard(SnakeFrame parent)
    {
        setFocusable(true);
        controller = new Controller(BOARD_WIDTH, BOARD_HEIGHT, this);
        scoreBar = parent.getScoreBar();
        addKeyListener(new TAdapter());
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        controller.gameAction();
    }

    public void setScore(String text)
    {
        scoreBar.setText("Score: " + text);
    }

    public void paint(Graphics g)
    {
        setFlag(true);
        super.paint(g);
        controller.paint(g, getSize().getWidth(), getSize().getHeight());

    }

    private int squareWidth()
    {
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    private int squareHight()
    {
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    public void drawSquare(Graphics g, int x, int y)
    {

        g.fillRect(x,y,squareWidth(), squareHight());

    }
    public void drawImage(Graphics g,Image img, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, x, y, this);
        g2.finalize();
    }

    public void setFlag(boolean status)
    {
        controller.flag(status);
    }

    public class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            switch (keycode)

            {
                case KeyEvent.VK_LEFT:
                            controller.setDirectionLeft();
                            setFlag(false);
                        break;
                case KeyEvent.VK_RIGHT:
                            controller.setDirectionRight();
                            setFlag(false);
                        break;
                case KeyEvent.VK_UP:
                            controller.setDirectionUp();
                            setFlag(false);
                        break;
                case KeyEvent.VK_DOWN:
                            controller.setDirectionDown();
                            setFlag(false);
                            break;

            }
        }
    }
}

