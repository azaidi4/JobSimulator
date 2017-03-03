import java.util.Iterator;

/**
 * Created by ahmad on 2/24/2017.
 */
public class Scoreboard implements ScoreboardADT {
    ListADT<Job> list = new JobList();
    Iterator <Job> itr = list.iterator();


    @Override
    public int getTotalScore() {
        int totalPoints = 0;

        while(itr.hasNext()){
            totalPoints += itr.next().getPoints();
        }
        return totalPoints;
    }

    @Override
    public void updateScoreBoard(Job job) {
        if(job.isCompleted())
            list.add(job);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void displayScoreBoard() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("At Position: " + i + list.get(i).toString());

        }
    }
}
