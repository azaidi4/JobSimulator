/////////////////////////////////////////////////////////////////////////////
//Semester:         CS367 Spring 2016
//PROJECT:          Program 2: Welcome to the Job Market
//FILE:             Scoreboard.java
//
//TEAM:    Team 16: 00010000
//Authors: Team 16
//
////////////////////////////80 columns wide //////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The JobListIterator class is responsible for creating the direct access 
 * iterator used by the JobList class.
 *
 */
public class JobListIterator implements Iterator<Job> {
    Listnode <Job> headerNode;
    int currPos;
    int numItems;

/**
 * Constructor for instantiating a job iterator
 * @param header: denotes which node is the header node.
 * @param numItems: denotes how many items are in the list
 */
    public JobListIterator(Listnode <Job> header, int numItems){
        headerNode = header;
        currPos = 0;
        this.numItems = numItems;
    }
    /**
     * To check if there is more Jobs in the JobList matching the given category.
     * @returns true if there are more such Jobs; returns false if there is not.
     */
    @Override
    public boolean hasNext() {
        return currPos < numItems;
    }

    /**
     * If there is more Jobs belonging to the given category, pick up the next Job.
     * @return Job which matches the given category.
     */
    @Override
    public Job next() {
        if(headerNode.getNext() == null){
            throw new NoSuchElementException();
        }
        else{
            Listnode <Job> curr = headerNode;
            for(int i = 0; i < currPos + 1; i++){
                curr = curr.getNext();
            }
            currPos++;
            return curr.getData();
        }
    }
}
