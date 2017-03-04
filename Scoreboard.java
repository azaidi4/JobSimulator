import java.util.Iterator;

/**
 * Created by ahmad on 2/24/2017.
 */
public class Scoreboard implements ScoreboardADT {
    ListADT<Job> list = new JobList();
    int totalPoints = 0;

    @Override
    public int getTotalScore() {
        return totalPoints;
    }

    @Override
    public void updateScoreBoard(Job job) {
            list.add(job);
            totalPoints += job.getPoints();
    }

    @Override
    public void displayScoreBoard() {
        System.out.println("The jobs completed: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Job Name: " + list.get(i).getJobName());
            System.out.println("Points Earned for this Job: " + list.get(i).getPoints());
            System.out.println("--------------------------------------------");
        }
    }
}
