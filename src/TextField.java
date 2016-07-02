import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TextField implements ActionListener
{
    private String warn;
    private JTextField field;
    private User user;
    private Records rec;

    public void setUserName(User user)
    {
        this.user = user;
    }

    public TextField(Records r)
    {
        this.rec = r;
        this.warn = "Enter your name";
        this.field = new JTextField(warn,18);
        this.field.addActionListener(this);
        this.field.setFont(new java.awt.Font("Arial",Font.PLAIN, 15));
        this.field.setBounds(40,90,150,15);
        this.field.setHorizontalAlignment(SwingConstants.CENTER);
        this.field.setSelectedTextColor(Color.RED);
        this.field.setSelectionColor(Color.PINK);
        this.field.selectAll();
        this.field.setVisible(true);
    }

    public JTextField getField()
    {
        return this.field;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = this.field.getText();

        this.user.setName(name);

        this.rec.readFile();
        this.rec.sortPreviousResultWithCurrent();
        this.rec.showResult();

        try
        {
            this.rec.writeFile();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }
}
