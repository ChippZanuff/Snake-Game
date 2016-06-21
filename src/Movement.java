import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener
{

    private final int right = 1, down = 2, left = 3, up = 4;
    private int direct;
    private boolean isMoved;
    private Snake snake;

    public Movement(Snake s)
    {
        this.snake = s;
        this.direct = right;
        this.isMoved = true;
    }

    /*public void setToDefault()
    {
        this.direct = this.right;
    }*/

    public void turnLocation(int dot)
    {
        this.snake.setTemporaryLocation();

        if(this.direct == this.right)
        {
            snake.setRight(dot);
        }

        if(this.direct == this.down)
        {
            snake.setDown(dot);
        }

        if(this.direct == this.left)
        {
            snake.setLeft(dot);
        }

        if(this.direct == this.up)
        {
            snake.setUp(dot);
        }

        this.snake.bodyFollowsHead();

        this.isMoved = true;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(!this.isMoved)
        {
            return;
        }
        int key = e.getKeyCode();
        switch (key)
        {
            case KeyEvent.VK_RIGHT:
                if(this.direct != this.left)
                {
                    this.direct = this.right;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(this.direct != this.up)
                {
                    this.direct = this.down;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(this.direct != this.right)
                {
                    this.direct = this.left;
                }
                break;
            case KeyEvent.VK_UP:
                if(this.direct != this.down)
                {
                    this.direct = this.up;
                }
                break;
        }
        this.isMoved = false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {}

    @Override
    public void keyReleased(KeyEvent e)
    {}

}
