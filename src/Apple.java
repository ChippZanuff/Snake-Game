import java.awt.*;
import java.util.LinkedList;

public class Apple
{
    private Point apple;
    private boolean appleOnDesk;
    private final int mapWidth = 180, mapHeight = 180, border = 20, dot = 10;

    public Apple()
    {
        this.apple = new Point();
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
