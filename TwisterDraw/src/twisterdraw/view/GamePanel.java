/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twisterdraw.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javazoom.jl.player.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;


/**
 *
 * @author Szymon
 */
public class GamePanel extends JPanel implements ActionListener{
    
    private final Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
    private String blueSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\blue.mp3";
    private String yellowSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\yellow.mp3";
    private String redSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\red.mp3";
    private String greenSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\green.mp3";
    private String handSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\hand.mp3";
    private String legSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\leg.mp3";
    private String leftSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\left.mp3";
    private String rightSound = "C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\sounds\\right.mp3";
    private String[] colorPaths = {redSound, blueSound, yellowSound, greenSound};
    private int i = 0;
    Random generator = new Random();
    Image image;

    public GamePanel(){
        try {
            this.image = ImageIO.read(new File("C:\\IdeaProjects\\IdeaProjects\\TwisterDraw\\src\\images\\limbs.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        setLayout(new BorderLayout());

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.repaint();
        System.out.println(this.getWidth() + "   " + this.getHeight());
    }
    
    private void  sound(String soundPath){
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(soundPath));
            Player player = new Player(fis);
            player.play();
        } catch (FileNotFoundException | JavaLayerException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    private void playSequence(String side, String limb, String color){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sound(side);
                sound(limb);
                sound(color);
            }
        });
        thread.start();
    }

    private int selectRandom(){
        return generator.nextInt(2000001)%4;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int colorSound = selectRandom()%4;
        switch(selectRandom()%4){
            case 0:
                g.setColor(colors[colorSound]); 
                g.fillRect(0, 0, this.getWidth()/2, this.getHeight()/2);
                playSequence(leftSound, handSound, colorPaths[colorSound]);
                break;
            case 1:
                g.setColor(colors[colorSound]);
                g.fillRect(this.getWidth()/2, 0, this.getWidth(), this.getHeight()/2);
                playSequence(rightSound, handSound, colorPaths[colorSound]);
                break;
            case 2:
                g.setColor(colors[colorSound]);
                g.fillRect(0, this.getHeight()/2, this.getWidth()/2, this.getHeight());
                playSequence(leftSound, legSound, colorPaths[colorSound]);
                break;
            case 3:
                g.setColor(colors[colorSound]);
                g.fillRect(this.getWidth()/2, this.getHeight()/2, this.getWidth(), this.getHeight());
                playSequence(rightSound, legSound, colorPaths[colorSound]);
                break;
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawImage(image, 0, 0, null);

    }
}
