import javax.swing.*;
import java.awt.*;


public class Drawer extends JPanel
{
    private Apple apple;
    private Snake snake;
    private TextField field;
    private FieldParam fieldParam;
    private String currentScore = "Score: 0";

    public Drawer(Apple a, Snake s, TextField t, FieldParam fp)
    {
        this.fieldParam = fp;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(this.fieldParam.getWestWall(),this.fieldParam.getSouthWall()));
        this.apple = a;
        this.snake = s;
        this.field = t;
    }

    public void getUsername(User user)
    {
        this.add(this.field.getField());
        this.field.getField().requestFocus();
        this.field.setUserName(user);
    }

    public void setScore(String score)
    {
        this.currentScore = score;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        int a = 0;

        g.setColor(Color.RED);
        int smoothing = 100;


        for(int i = 0; i < this.fieldParam.getSouthWall(); i += this.fieldParam.getDot())
        {
            g.fillRoundRect(i, this.fieldParam.getNorthWall(), this.fieldParam.getDot(), this.fieldParam.getDot(), smoothing,smoothing);

            if(i != this.fieldParam.getSouthWall() - this.fieldParam.getDot() && i != this.fieldParam.getSouthWall())
            {
                g.fillRoundRect(0,i,this.fieldParam.getDot(),this.fieldParam.getDot(),smoothing,smoothing);
            }
            g.fillRoundRect(i,200,this.fieldParam.getDot(),this.fieldParam.getDot(),smoothing,smoothing);
            if(i != this.fieldParam.getSouthWall() - this.fieldParam.getDot() && i != this.fieldParam.getSouthWall())
            {
                g.fillRoundRect(this.fieldParam.getSouthWall(),i,this.fieldParam.getDot(),this.fieldParam.getDot(),smoothing,smoothing);
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
            g.fillRoundRect(point.x,point.y,this.fieldParam.getDot(), this.fieldParam.getDot(), smoothing,smoothing);
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
        g.fillRoundRect(this.apple.getApple().x, this.apple.getApple().y, this.fieldParam.getDot(), this.fieldParam.getDot(),smoothing,smoothing);

        g.setColor(Color.WHITE);
        g.drawString(this.currentScore, this.fieldParam.getEastWall(), this.fieldParam.getSouthWall());
    }
}
