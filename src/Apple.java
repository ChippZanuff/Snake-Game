import java.awt.*;
import java.util.LinkedList;

public class Apple
{
    private Point apple;
    private boolean appleOnDesk;
    private int mapWidth, mapHeight, border, dot;

    public Apple(int mapWidth, int mapHeight, int border, int dot, Point apple)
    {
        this.apple = apple;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.border = border;
        this.dot = dot;
        this.appleOnDesk = false;
    }

    public void appleSet()
    {
        this.apple = new Point(this.getRandomCoord(this.mapWidth),this.getRandomCoord(this.mapHeight));
    }

    public Point getApple()
    {
        return this.apple;
    }

    public boolean isAppleOnDesk()
    {
        return this.appleOnDesk;
    }

    public void setAppleOnDesk(boolean b)
    {
        this.appleOnDesk = b;
    }

    public int getRandomCoord(int mapSize)
    {
        int coord = (int) (Math.random() * mapSize) + this.border;
        int coordmod = coord % this.dot;
        return coord - coordmod;
    }
}
