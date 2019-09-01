package mySnake.views;

import mySnake.views.SnakeFrame;
import mySnake.views.SettingsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFrame extends JFrame implements ActionListener
{
    private JButton startButton;
    private JButton settingsButton;
    private JButton exitButton;

    public MenuFrame()

    {
        //opcje frame'a
        super("Snake");
        setSize(1024, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //obrazek w tle frame'a
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("C:\\Java\\workspace\\MySnake\\src\\snake-face-26924-hd-wallpapers.jpg"));
        background.setLayout(new BorderLayout());
        add(background);

        //Panel z guzikami manu startowego
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,0,20));
        panel.setBorder(BorderFactory.createEmptyBorder(250,410,20,410));
        startButton = new JButton("Start");
        settingsButton = new JButton("Settings");
        exitButton = new JButton("Exit");
        startButton.addActionListener(this);
        settingsButton.addActionListener(this);
        exitButton.addActionListener(this);
        panel.add(startButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        panel.setOpaque(false);
        background.add(panel);

        //odswiezenie frame'a
        setSize(1023, 499);
        setSize(1024, 500);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == startButton)
        {
            SnakeFrame game = new SnakeFrame();
            game.init();
        }
        if(source == settingsButton)
        {
            SettingsFrame settings = new SettingsFrame();

        }
        if (source == exitButton)
        {
            System.exit(0);
        }

    }

}

