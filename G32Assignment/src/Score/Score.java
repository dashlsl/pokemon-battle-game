package Score;

public class Score implements Comparable<Score> {
    private String name;
    private int score;

    //Constructor
    public Score(){
    }

    public Score(String n, int s){
        name=n;
        score=s;
    }

    //Setter
    public void setName(String n){
        name=n;
    }

    public void setScore(int s){
        score=s;
    }

    //Getter
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return score;
    }
    
    //method
    public void calculateScore(int roundsWon, int catchBonus){
        score=roundsWon*4000+catchBonus*1000;
    }

    //comparble interface implementaion, for arrays.sort
    @Override
    public int compareTo(Score otherScore) {
        return Integer.compare(this.score, otherScore.score);
    }


    //public get
    public String toString(){
        return "Name: "+name+"\nScore: "+score;
    }
}
