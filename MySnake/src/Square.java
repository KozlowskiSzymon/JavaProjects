package mySnake.models;

import java.util.Random;

public class Square
{

    private int x;
    private int y;


    public Square()
    {
        setRandomLocation();
    }
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setRandomLocation()
    {
        Random r = new Random();
        int x = r.nextInt(20);
        int y = r.nextInt(20);
        this.setX(x);
        this.setY(y);
    }
}
