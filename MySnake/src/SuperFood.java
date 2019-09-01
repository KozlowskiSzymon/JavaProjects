package mySnake.models;

import mySnake.models.Square;

public class SuperFood extends Square
{
    public int points = 100;

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getPoints()
    {
        return points;
    }
}
