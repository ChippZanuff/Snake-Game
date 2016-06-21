import javax.swing.*;
import java.awt.*;


public class Drawer extends JPanel
{
    private int dot, score, northWall, westWall, southWall, eastWall;
    private Apple apple;
    private Snake snake;
    private String stringScore = "Score: 0";
    private TextField field;

    public Drawer(Apple a, Snake s, TextField t)
    {
        this.northWall = 0;
        this.westWall = 230;
        this.southWall = 0;
        this.eastWall = 220;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(this.westWall,this.eastWall));
        this.apple = a;
        this.snake = s;
        this.field = t;
        this.dot = 10;
        this.score = 0;

    }

    public void getTextField()
    {
        this.add(this.field.getField());
        this.field.getField().requestFocus();
        this.field.setScore(this.score);
    }

    public void setScore(int i)
    {
        this.score = i;
        this.stringScore = "Score: " + i;
    }

    public int getDot()
    {
        return this.dot;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        int a = 0;

        g.setColor(Color.RED);
        int smoothing = 100;



        for(int i = 0; i < this.eastWall; i += this.dot)
        {
            g.fillRoundRect(i,this.northWall,this.dot,this.dot,smoothing,smoothing);

            if(i != this.eastWall - this.dot && i != this.eastWall)
            {
                g.fillRoundRect(0,i,this.dot,this.dot,smoothing,smoothing);
            }
            g.fillRoundRect(i,200,this.dot,this.dot,smoothing,smoothing);
            if(i != this.eastWall - this.dot && i != this.eastWall)
            {
                g.fillRoundRect(this.eastWall,i,this.dot,this.dot,smoothing,smoothing);
            }
        }

        g.setColor(Color.PINK);
        for(Point point : this.snake.getBody())
        {
            if(a != 0)
            {
                if(point.getLocation().equals(this.snake.getSnakeHeadLoc().getLocation()))
                {
                    g.setColor(Color.RED);
                }
            }
            g.fillRoundRect(point.x,point.y,this.dot,this.dot,smoothing,smoothing);
            g.setColor(Color.PINK);
            a++;
        }
        if((this.snake.getSnakeHeadLoc().getLocation()).equals(this.apple.getApple().getLocation()))
        {
            g.setColor(Color.ORANGE);
        }
        else
        {
            g.setColor(Color.YELLOW);
        }
        g.fillRoundRect(this.apple.getApple().x, this.apple.getApple().y, this.dot, this.dot,smoothing,smoothing);

        g.setColor(Color.WHITE);
        g.drawString(this.stringScore, 0,this.eastWall);
    }
}
