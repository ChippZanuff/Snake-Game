public class User implements Comparable
{
    private String name = "";
    private int score = 0;
    private int scoreAdding = 9;

    public User()
    {}

    public User(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public User(int scoreAdding, String name)
    {
        this.name = name;
        this.scoreAdding = scoreAdding;
    }

    public void addScore()
    {
        this.score += this.scoreAdding;
    }

    public String getScoreForDrawer()
    {
        return "Score: " + this.score;
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
    public String toString()
    {
        return this.name + " - " + this.score + '\n';
    }

    @Override
    public int compareTo(Object user)
    {
        User temporary = (User) user;

        if(this.score > temporary.getScore())
        {
            return 1;
        }
        else if(this.score < temporary.getScore())
        {
            return -1;
        }

        return 0;
    }
}
