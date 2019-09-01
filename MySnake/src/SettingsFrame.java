package mySnake.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mySnake.controllers.Controller;

public class SettingsFrame extends JFrame implements ActionListener
{
    private JButton applyButton;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JLabel text;

    public SettingsFrame()

    {

        //opcje frame'a
        super("Settings");
        setSize(1024, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(100,255,50));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //obrazek w tle frame'a
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("C:\\Java\\workspace\\MySnake\\src\\green-background-11982.jpeg"));
        background.setLayout(new GridLayout(1,2,50,0));
        add(background);

        JPanel applyPanel = new JPanel();
        applyPanel.setLayout(new GridLayout(1,1,0,0));
        applyPanel.setBorder(BorderFactory.createEmptyBorder(350,50,20,50));
        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        applyPanel.add(applyButton);
        applyPanel.setOpaque(false);

        JPanel speedPanel = new JPanel();
        speedPanel.setLayout(new GridLayout(4,1,0,20));
        speedPanel.setBorder(BorderFactory.createEmptyBorder(50,20,50,20));
        text = new JLabel("  Choose Difficulty");
        text.setFont(new Font("Consolas", 3, 40));
        easyButton = new JButton("easy");
        mediumButton = new JButton("medium");
        hardButton = new JButton("hard");
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        speedPanel.add(text);
        speedPanel.add(easyButton);
        speedPanel.add(mediumButton);
        speedPanel.add(hardButton);
        speedPanel.setOpaque(false);


        background.add(speedPanel);
        background.add(applyPanel);







        //odswiezenie frame'a
        setSize(1023, 499);
        setSize(1024, 500);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == applyButton)
        {
            this.dispose();
        }
        if(source == easyButton)
        {

        }
    }

}
