/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twisterdraw.controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Szymon
 */
public class Controller {

    private int timeOfDraw = 10000;
    private Color colorOfDraw;
    private int limbOfDraw; // 1 - left hand | 2 - right hand | 3 - left leg | 4 - right leg
    private final Timer timer;

    public Controller(JPanel resultPanel) {
        timer = new Timer(timeOfDraw, (ActionListener) resultPanel);
    }

    public void startTheGame(){
        timer.start();   
    }
    public int getTimeOfDraw() {
        return timeOfDraw;
    }

    public void setTimeOfDraw(int timeOfDraw) {
        timer.setDelay(timeOfDraw);
        
    }

    public Color getColorOfDraw() {
        return colorOfDraw;
    }

    public void setColorOfDraw(Color colorOfDraw) {
        this.colorOfDraw = colorOfDraw;
    }

    public int getLimbOfDraw() {
        return limbOfDraw;
    }

    public void setLimbOfDraw(int limbOfDraw) {
        this.limbOfDraw = limbOfDraw;
    }
    
    
}
