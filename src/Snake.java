import java.awt.*;
import java.util.LinkedList;

public class Snake
{
    private LinkedList<Point> p;
    private Point temporaryLocation;

    public Snake()
    {
        this.p = new LinkedList<>();
        this.p.add(new Point(40,40));
        this.p.add(new Point(30,40));
        this.p.add(new Point(20,40));
    }

    public Point getSnakeHeadLoc()
    {
        return this.p.get(0);
    }

    public void setBack()
    {
        this.p.add(this.p.getLast().getLocation());
    }

    public LinkedList<Point> getBody()
    {
        return this.p;
    }


    public void setUp(int dot)
    {
        this.p.get(0).y -= dot;
    }

    public void setRight(int dot)
    {
        this.p.get(0).x += dot;
    }

    public void setLeft(int dot)
    {
        this.p.get(0).x -= dot;
    }

    public void setDown(int dot)
    {
        this.p.get(0).y += dot;
    }

    public void bodyFollowsHead()
    {
        Point secondTemporaryLocation;

        for(int i = 0; i < p.size(); i++)
        {
            if(i != 0)
            {
                secondTemporaryLocation = this.p.get(i).getLocation();
                this.p.set(i, this.temporaryLocation.getLocation());
                this.temporaryLocation = secondTemporaryLocation.getLocation();
            }
        }
    }

    public void setTemporaryLocation()
    {
        this.temporaryLocation = new Point(this.p.get(0).getLocation());
    }

    /*public void setToDefault()
    {
        for(int i = 0; i < this.p.size(); i++)
        {
            this.p.removeAll(p);
        }
        this.p.add(new Point(40,40));
        this.p.add(new Point(30,40));
        this.p.add(new Point(20,40));
    }*/
}
