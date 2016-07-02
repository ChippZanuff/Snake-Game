import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Records
{
    private User[] users;
    private File records;


    public Records(File records, User[] u)
    {
        this.records = records;
        this.users = u;
    }

    public void readFile()
    {
        try
        {
            Scanner scan = new Scanner(this.records);
            int iterator = 1;

            while(scan.hasNextLine()){
                String[] row = scan.nextLine().split(" - ");
                if(Objects.equals(row[0],""))
                {
                    continue;
                }
                if (row.length > 0)
                {
                    users[iterator] = new User(row[0], Integer.parseInt(row[1]));
                    iterator++;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void writeFile() throws IOException
    {
        FileWriter fileWriter = new FileWriter(this.records);
        for (int i = 0; i < 10; i++)
        {
            fileWriter.write(this.users[i].toString());
            fileWriter.write(System.getProperty("line.separator"));
        }

        fileWriter.flush();
    }

    public void showResult()
    {
        String result = "";
        for(int i = 0; i < users.length - 1; i++)
        {
            result += users[i];
        }

        JOptionPane.showMessageDialog(new JPanel(), result);
    }

    public void sortPreviousResultWithCurrent()
    {
        Arrays.sort(this.users, Collections.reverseOrder());
    }
}
