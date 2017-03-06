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
 * The ScoreboardADT interface is responsible for creating the ADT for 
 * Scoreboard. 
 *
 */
public interface ScoreboardADT {
		 /**
	     * Calculates the total combined number of points for every job in the scoreboard.
	     * 
	     * @return The summation of all the points for every job currently stored in the scoreboard.
	     */
		int getTotalScore();
		
		 /**
	     * Inserts the given job at the end of the scoreboard.
	     * 
	     * @param job 
	     * 		The job that has been completed and is to be inserted into the list.
	     */
	    void updateScoreBoard(Job job);
	
	    /**
	     * Prints out a summary of all jobs currently stored in the scoreboard. The formatting must match the example exactly.
	     */
	    void displayScoreBoard();
	}
