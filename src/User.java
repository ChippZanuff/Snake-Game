public class User implements Comparable
{
    private String name = "";
    private int score;

    public User()
    {}

    public User(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    @Override
    public int compareTo(Object user)
    {
        User temporary = (User) user;

        if(this.score > temporary.getScore())
        {
            return -1;
        }
        else if(this.score < temporary.getScore())
        {
            return 1;
        }

        return 0;
    }
}
