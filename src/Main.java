import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        FieldParam fieldParam = new FieldParam();
        CurrentScore currentScore = new CurrentScore();
        Snake snake = new Snake();
        Movement move = new  Movement(snake);
        Apple apple = new Apple(180,180,20,10, new Point());
        Records records = new Records(new File("src/Records/Records.txt"), "/Records/Records.txt",currentScore);
        TextField textField = new TextField(records);
        Drawer drawer = new Drawer(apple, snake, textField,currentScore, fieldParam);
        JFrame jf = new JFrame();
        Test t = new Test(move, drawer, apple, snake,currentScore, fieldParam);
        drawer.setBackground(Color.BLACK);
        t.time.start();


        jf.addKeyListener(move);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(drawer);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
