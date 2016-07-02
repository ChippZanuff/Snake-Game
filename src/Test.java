import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Test implements ActionListener
{
    private Movement moveme;
    private User[] user;
    private Drawer draw;
    private Snake snake;
    private FieldParam fieldParam;
    private int delay = 350;
    private boolean game = true;
    private final int scoreAdd = 9, currentUser = 0;

    private Apple apple;
    private boolean collision = false;


    public Timer time = new Timer(this.delay,this);

    public Test(Movement m, Drawer d, Apple a, Snake s, FieldParam fp, User[] u)
    {
        this.user = u;
        this.user[this.currentUser] = new User();
        this.fieldParam = fp;
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
            this.user[this.currentUser].addScore();
            this.draw.setScore(this.user[this.currentUser].getScoreForDrawer());
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
            this.draw.getUsername(user[currentUser]);
        }
    }
}
