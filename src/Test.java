import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Test implements ActionListener
{
    private Movement moveme;
    private Drawer draw;
    private Snake snake;
    private CurrentScore curScore;
    private FieldParam fieldParam;
    private int delay = 350;
    private boolean game = true;
    private final int scoreAdd = 9;

    private Apple apple;
    private boolean collision = false;


    public Timer time = new Timer(this.delay,this);

    public Test(Movement m, Drawer d, Apple a, Snake s, CurrentScore sc, FieldParam fp)
    {
        this.fieldParam = fp;
        this.curScore = sc;
        this.draw = d;
        this.apple = a;
        this.moveme = m;
        this.snake = s;
        this.delay = 350;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.snakeBodyIncrement();

        this.appleCreation();

        this.moveme.turnLocation(this.fieldParam.getDot());

        this.draw.repaint();

        this.collisionCheck();

        if(this.snake.getSnakeHeadLoc().x == 0 || this.snake.getSnakeHeadLoc().y == 0 || this.snake.getSnakeHeadLoc().x == 220 || this.snake.getSnakeHeadLoc().y == 200 || this.collision)
        {
            this.time.stop();
            this.game = false;
        }
        this.isGameOver();
    }

    private void appleCreation()
    {
        if(!this.apple.isAppleOnDesk())
        {
            this.apple.appleSet();
            for(Point p : this.snake.getBody())
            {
                if(p.equals(this.apple.getApple().getLocation()))
                {
                    this.appleCreation();
                }
            }
            this.apple.setAppleOnDesk(true);
        }
    }

    private void collisionCheck()
    {
        int i = 0;
        for(Point p : this.snake.getBody())
        {
            if(p.equals(this.snake.getSnakeHeadLoc()))
            {
                if(i != 0)
                {
                    this.collision = true;
                }
                i++;
            }
        }
    }

    private void snakeBodyIncrement()
    {
        if((this.snake.getSnakeHeadLoc().getLocation()).equals(this.apple.getApple().getLocation()))
        {
            this.apple.setAppleOnDesk(false);
            this.snake.setBack();
            this.curScore.setScore(scoreAdd);
            this.draw.repaint();
            this.time.setDelay(this.setDelay());
        }
    }

    private int setDelay()
    {
        return this.time.getDelay() - this.time.getDelay() * 5 / 100;
    }

    private void isGameOver()
    {
        if(!this.game)
        {
            draw.getTextField();
        }
    }
}
