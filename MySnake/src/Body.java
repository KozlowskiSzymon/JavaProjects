package mySnake.models;

import mySnake.models.Square;

public class Body extends Square
{
    public int number;

    public Body(int x, int y, int number)
    {
        super(x,y);
        this.number = number;
    }
}
