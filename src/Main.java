import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Snake snake = new Snake();
        Movement move = new  Movement(snake);
        Apple apple = new Apple();
        Records records = new Records();
        TextField textField = new TextField(records);
        Drawer drawer = new Drawer(apple, snake, textField);
        JFrame jf = new JFrame();
        Test t = new Test(move, drawer, apple, snake);
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
