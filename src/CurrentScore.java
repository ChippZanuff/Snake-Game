public class CurrentScore
{
    private int score = 0;

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public String getScoreForDrawer()
    {
        return "Score: " + this.score;
    }
}
