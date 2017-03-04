import java.util.Scanner;

public class GameApp{
    /**
     * Scanner instance for reading input from console
     */
    private static final Scanner STDIN = new Scanner(System.in);
    private Game playedGame;
    /**
     * Constructor for instantiating game class
     * @param seed: Seed value as processed in command line
     * @param timeToPlay: Total time to play from command line
     */
    public GameApp(int seed, int timeToPlay){
       playedGame = new Game(seed, timeToPlay);
    }

    /**
     * Main function which takes the command line arguments and instantiate the
     * GameApp class.
     * The main function terminates when the game ends.
     * Use the getIntegerInput function to read inputs from console
     *
     * @param args: Command line arguments <seed> <timeToPlay>
     */
    public static void main(String[] args){

        System.out.println("Welcome to the Job Market!");

        int seed = Integer.parseInt(args[0]);
        int timeToPlay = Integer.parseInt(args[1]);

        try {

            if (seed <= 0 || timeToPlay <= 0 || args.length != 2)
                throw new IllegalArgumentException();

            GameApp gameApp = new GameApp(seed, timeToPlay);
            gameApp.mainMenuLoop();
        } catch (IllegalArgumentException e){
            System.out.println("Illegal argument entered. Exiting...");
        }
    }

    /**
     * Add Comments as per implementation
     */
    private void start(){

        System.out.println("You have " + playedGame.getTimeToPlay() + " left in the game!");

        playedGame.createJobs();    //SIMULATE JOBS
        playedGame.displayActiveJobs();
        System.out.println();

        int index = getIntegerInput("Select job to work on: ");
        int duration = getIntegerInput("For how long would you like to work on this job?: ");

       if(playedGame.updateJob(index, duration).isCompleted()){
           System.out.println("Job Completed! Current score: " + playedGame.getTotalScore());
           System.out.println("Total Score: " + playedGame.getTotalScore());
           playedGame.displayCompletedJobs();
       }

    }

    /**
     * Displays the prompt and returns the integer entered by the user
     * to the standard input stream.
     *
     * Does not return until the user enters an integer.
     * Does not check the integer value in any way.
     * @param prompt The user prompt to display before waiting for this integer.
     */
    public static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        while ( ! STDIN.hasNextInt() ) {
            System.out.print(STDIN.next()+" is not an int.  Please enter an integer.");
        }
        return STDIN.nextInt();
    }

    public void mainMenuLoop(){
        while(!playedGame.isOver()){
            start();
        }
        System.out.println("Game Over!");
        System.out.println(playedGame.getTotalScore());
    }
}