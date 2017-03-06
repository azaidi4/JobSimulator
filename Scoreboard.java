/////////////////////////////////////////////////////////////////////////////
//Semester:         CS367 Spring 2016
//PROJECT:          Program 2: Welcome to the Job Market
//FILE:             Scoreboard.java
//
//TEAM:    Team 16: 00010000
//Authors: Team 16
//
////////////////////////////80 columns wide //////////////////////////////////
/**
 * Creates and keeps track of the Scoreboard.
 *
 */
public class Scoreboard implements ScoreboardADT {
    ListADT<Job> list = new JobList();
    int totalPoints = 0;

    /**
     * @return totalPoints: the total amount of points within the Scoreboard
     */
    @Override
    public int getTotalScore() {
        return totalPoints;
    }
    /**
     * @param job; the Job that will be used to update the Scoreboard
     * Adds the job to the list of jobs
     * Then gets the points from the job and adds it to the total ScoreBoard
     */
    @Override
    public void updateScoreBoard(Job job) {
            list.add(job);
            totalPoints += job.getPoints();
    }
    /**
     * Displays the Scoreboard in the Console
     * Outputting the Job name and then how many points were received for each job
     */
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
