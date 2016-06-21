import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class Records
{
    private User[] users;
    private int count, curScore;
    private String curName;
    private String path;
    private File records;
    private Reader paramReader;
    private char[] buf;

    public Records()
    {
        this.records = new File("src/Records/Records.txt");
        this.path = "/Records/Records.txt";
        this.paramReader = new InputStreamReader(getClass().getResourceAsStream(this.path));
        this.users = new User[11];
        this.buf = new char[300];
    }

    public char[] readFile() throws IOException
    {
        int data = paramReader.read(), count = 0;

        while(data != -1)
        {
            char dataChar = (char) data;
            data = paramReader.read();
            this.buf[count] = dataChar;
            count++;
        }
        return this.buf;
    }


    public void writeFile() throws IOException
    {
        FileWriter fileWriter = new FileWriter(this.records);
        for (int i = 0; i < 10; i++)
        {
            String scoreToString = Integer.toString(this.users[i].getScore());
            fileWriter.write(this.users[i].getName() + scoreToString);
            fileWriter.write(System.getProperty("line.separator"));
        }

        fileWriter.flush();
    }

    public void temporaryNameStockpile(String name)
    {
        this.users[this.count] = new User();
        this.users[this.count].setName(name);
    }

    public void temporaryScoresStockpile(int score)
    {
        this.users[this.count].setScore(score);
        this.count++;
    }

    public void setCurResult(String curName, int curScore)
    {
        this.curName = curName;
        this.curScore = curScore;
    }

    public void getPreviousRecords()
    {
        try
        {
            boolean numbersEnd = true, nameEnd = false;
            char[] recFile = this.readFile();
            String name = "";
            String score = "";
            for(int i = 0; i < recFile.length; i++)
            {
                if(!Character.isSpaceChar(recFile[i]) && !nameEnd && recFile[i] != '-' && recFile[i] != '\n' && this.intSymbolsCheck(recFile[i]))
                {
                    name += recFile[i];
                }

                if(i > 0 && recFile[i - 1] == '-')
                {
                    this.temporaryNameStockpile(name + " " + "-" + " ");
                    nameEnd = true;
                    name = "";
                }

                if(recFile[i] != '-' && recFile[i] != '\n' && !Character.isSpaceChar(recFile[i]) && nameEnd)
                {
                    score += recFile[i];
                    if (i + 1 != recFile.length && recFile[i + 1] == '\r' || i == recFile.length - 1)
                    {
                        numbersEnd = false;
                    }
                }

                if(!numbersEnd)
                {
                    this.temporaryScoresStockpile(Integer.parseInt(score));
                    score = "";
                    numbersEnd = true;
                    nameEnd = false;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void showResult()
    {
        String result = new String(buf);
        JOptionPane.showMessageDialog(new JPanel(),result);
    }
    public void addCurrentResults()
    {
        this.users[count] = new User();
        this.users[count].setName(curName + " " + "-" + " ");
        this.users[count].setScore(curScore);
    }

    public void sortPreviousResultWithCurrent()
    {
        Arrays.sort(users);
    }

    private boolean intSymbolsCheck(char ch)
    {
        for (int i = 0; i < 10; i++)
        {
            if((int) ch == 1 || (int) ch == 2 || (int) ch == 3 || (int) ch == 4 || (int) ch == 5 || (int) ch == 6 || (int) ch == 7 || (int) ch == 8 || (int) ch == 9 || (int) ch == 0)
            {
                return false;
            }
        }

        return true;
    }

}
