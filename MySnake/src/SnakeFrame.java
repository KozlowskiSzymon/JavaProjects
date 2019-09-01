package mySnake.views;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame
{
    private SnakeBoard board;
    private JLabel scoreBar;

    public SnakeFrame()
    {
        scoreBar = new JLabel("0");
        board = new SnakeBoard(this);
    }

    public void init()
    {
        setLayout(new BorderLayout());
        add(scoreBar, BorderLayout.SOUTH);
        add(board,BorderLayout.CENTER);
        setSize(400,400);
        setPreferredSize(new Dimension(400,400));
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    JLabel getScoreBar()
    {
        return scoreBar;
    }


}
