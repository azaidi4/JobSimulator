import java.util.Iterator;

/**
 * Test class used to check if all the methods of JobList work as required.
 *
 * Created by ahmad on 2/24/2017.
 */
public class Test_Joblist {
    /**
     * This runs all the tests of Test_JobList.
     * @param args unused.
     */
    public static void main(String[] args) {
        JobList jobs = new JobList();

        //Create and add new Job instances to JobList
        System.out.println("**********************TEST ADD(Job item)**********************");
        jobs.add(new Job("JobA", 10, 10));
        jobs.add(new Job("JobB", 11, 11));
        jobs.add(new Job("JobC", 12, 12));
        jobs.add(new Job("JobD", 13, 13));
        displayJobList(jobs);

        //Remove jobs
        System.out.println("**********************TEST REMOVE(int pos)**********************");
        jobs.remove(0);
        System.out.println("Removing JobA (index 0) ");
        jobs.remove(2);
        System.out.println("Removing JobD (index 2) ");
        displayJobList(jobs);

        System.out.println("**********************TEST ADD(int pos, Job item)**********************");
        jobs.add(1, new Job("JobX", 20, 30));
        jobs.add(2, new Job("JobY", 15, 25));
        displayJobList(jobs);

        //Testing contain()
        System.out.println("**********************TEST CONTAIN(Job item)**********************");
        Job test1 = new Job("JobY", 15, 25);
        Job test2 = new Job("JobD", 13, 13);
        Job test3 = new Job("JobY", 10, 25);
        Job test4 = new Job("JobY", 15, 20);

        System.out.println("Should return true: " + jobs.contains(test1));           //Should return true
        System.out.println("Should return true: " + jobs.contains(test2));           //Should return true
        System.out.println("Should return false: " + jobs.contains(test3));           //Should return false
        System.out.println("Should return false: " + jobs.contains(test4));           //Should return false
        System.out.println();

        //Testing Iterator
        System.out.println("**********************TEST ITERATOR(ListNode<Job> head, int numItems)**********************");
        Iterator<Job> itr = jobs.iterator();
        displayJobList(itr);
    }

    /**
     * This method displays the toString() method of all the Job objects stored
     * in a JobList. Uses a for loop.
     * @param job JobList whose contents are being displayed.
     */
    public static void displayJobList(JobList job){
        for(int i = 0; i < job.size(); i++) {
            System.out.println(job.get(i).toString());
        }
        System.out.println();
    }

    /**
     * This method displays the toString() method of all the Job objects stored
     * in a JobList. Uses a JobListIterator
     * @param itr JobListIterator used to cycle through the list.
     */
    public static void displayJobList(Iterator<Job> itr){
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
        }
    }
}
