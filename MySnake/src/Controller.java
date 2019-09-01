package mySnake.controllers;

import mySnake.models.Square;
import mySnake.models.Food;
import mySnake.models.Body;
import mySnake.views.SnakeBoard;


import java.awt.*;
import java.util.TimerTask;
import javax.swing.*;

public class Controller
{
    private SnakeBoard snakeBoard;
    private int boardWidth;
    private int boardHeight;
    private Food food;
    private Timer timer;
    private Body[] body;
    private boolean flag = true;

    private int currentDirection = 3;
    private int number = 0;
    private int score = 0;
    private int timeOfRepaint = 150;

    public Controller(int boardWidth, int boardHeight, SnakeBoard snakeBoard)
    {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.snakeBoard = snakeBoard;
        food = new Food();
        body = new Body[boardWidth * boardHeight];
        body[0] = new Body(5,2,number);
        body[1] = new Body(4,2,++number);
        body[2] = new Body(3,2,++number);
        timer = new Timer(timeOfRepaint, snakeBoard);
        timer.start();

    }


    public void paint(Graphics g, double width, double height)
    {
        int squareWidth = (int) width / boardWidth;
        int squareHeight = (int) height / boardHeight;


        Color colorFood = new Color(204,30,50);
        Color colorBody = new Color(0, 0, 0);
        g.setColor(colorBody);
        for(int i = 0; i <= number; i++)
            snakeBoard.drawSquare(g, body[i].getX() * squareWidth, body[i].getY() * squareHeight);
        g.setColor(colorFood);
        snakeBoard.drawSquare(g, food.getX() * squareWidth, food.getY() * squareHeight);
        //snakeBoard.drawImage(g, food.getImage(),food.getX(),food.getY());
    }

    public void gameAction()
    {
        if(currentDirection == 1)
            moveLeft();
        if(currentDirection == 2)
            moveUp();
        if(currentDirection == 3)
             moveRight();
        if(currentDirection == 4)
             moveDown();
        eating();

    }

    public void flag(boolean status)
    {
        flag = status;
    }



    public boolean tryMove(int newX, int newY)
    {
        int x = newX;
        int y = newY;


        if(x < 0 || x >= boardWidth || y < 0 || y >= boardHeight)
        {System.out.println("false " +body[0].getX() + " " + body[0].getY() + flag);
            return false;}

            for (int i = number; i > 0; i--) {
                body[i].setX(body[i - 1].getX());
                body[i].setY(body[i - 1].getY());
            }
            body[0].setX(newX);
            body[0].setY(newY);

            if(isTaken())
            {
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" + flag);
                return false;
            }
            else
            {
                snakeBoard.repaint();
                System.out.println("true " + body[0].getX() + " " + body[0].getY() + flag);
                return true;
            }


    }

    public void moveRight()
    {
        tryMove(body[0].getX() + 1, body[0].getY());
    }
    public void moveLeft()
    {
        tryMove(body[0].getX() - 1, body[0].getY());
    }
    public void moveUp()
    {
        tryMove( body[0].getX(), body[0].getY() - 1);
    }
    public void moveDown()
    {
        tryMove( body[0].getX(), body[0].getY() + 1);
    }

    public boolean setDirectionLeft()
    {
        if(currentDirection == 3)
            return false;

        if(flag)
        {
            currentDirection = 1;
            return true;
        }
        else
            return false;
    }
    public boolean setDirectionUp()
    {
        if(currentDirection == 4)
            return false;
        if(flag)
        {
            currentDirection = 2;
            return true;
        }
        else
            return false;
    }
    public boolean setDirectionRight()
    {
        if(currentDirection == 1)
                return false;
        if(flag)
        {
            currentDirection = 3;
            return true;
        }
        else
            return false;
    }

    public boolean setDirectionDown()
    {
        if(currentDirection == 2)
            return false;
        if(flag)
        {
            currentDirection = 4;
            return true;
        }
        else
            return false;

    }


    public void eating()
    {
        if(body[0].getX() == food.getX() && body[0].getY() == food.getY())
        {
            snakeBoard.setScore(String.valueOf(countScore()));
            food = new Food();
            grow();
        }
    }

    public int countScore()
    {
        score = score + food.getPoints();
        return score;
    }


    public void grow()
    {
        int x = body[number].getX();
        int y = body[number].getY();
        ++number;
        body[number] = new Body(x,y,number);
    }

    public boolean isTaken()
    {
        int x = body[0].getX();
        int y = body[0].getY();
        for(int i = 1; i <= number; i++)
        {
            if(body[i].getX() == x && body[i].getY() == y)
                return true;
        }
            return false;

    }

    public void setDifficulty(int time)
    {
        timeOfRepaint = time;
    }

}
