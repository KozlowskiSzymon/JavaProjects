package mySnake.models;

import mySnake.models.Square;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Food extends Square
{
    public int points = 7;
    public BufferedImage image = null;

    public void setImage()
    {
        try{
            image = ImageIO.read(getClass().getResource("/resources/food1.png"));
        }catch (IOException e){
                System.out.println("lllllllllllllllllllllllllllllll");
        }

    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getPoints()
    {
        return points;
    }

    public BufferedImage getImage()
    {
        setImage();
        return image;
    }
}
