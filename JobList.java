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
/**
 * The JobList class is responsible for storing currently active jobs.
 * Iterates over the list of jobs with JobListIterator object.
 * 
 * @implements ListADT<Job>
 *
 */
public class JobList implements ListADT<Job> {
     private Listnode<Job> head;
     private int numItems;

    /**
     *Constructor for instantiating a JobList
     *Sets head to a new empty listnode
     *Sets number of items in list to 0.
      */
    public JobList() {
        head = new Listnode<Job>(null);
        numItems = 0;
    }
    /**@param item: the instance of Job that will be added to the list.
     * If item is not null, creates a new Node of from item
     * Then sets the new Nodes to be the last item in the list
     */
    @Override
    public void add(Job item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Listnode<Job> newNode = new Listnode<Job>(item);
        Listnode<Job> curr = head;

        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
        numItems++;
    }
    /**
     * @param pos: where in the list the new item will be added.
     * @param item: the instance of Job that will be added to the list.
     * if item is not null and pos is greater than or equal to 0
     * Adds the item into the list at the position denoted by pos.
     */
    @Override
    public void add(int pos, Job item) {
        if(pos < 0 || pos >= numItems || item == null){
            throw new IndexOutOfBoundsException();
        }
        Listnode<Job> newNode = new Listnode<Job>(item);
        Listnode<Job> curr = head;

        for(int i = 0; i < pos; i++){
            curr = curr.getNext();
        }
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);
        numItems++;
    }
    /**
     * @param item: the instance of Job that will be added to the list.
     * if item is not null, will search through the list to see if item is within in the list.
     * @return true if the item is within the list; false if not.
     */
    @Override
    public boolean contains(Job item) {
        Listnode<Job> curr = head;

        if(item == null)
            throw new IllegalArgumentException();

        while(curr.getNext() != null){
            curr = curr.getNext();
            if(curr.getData().toString().equals(item.toString())) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param pos: the position in the list that you would like to use.
     * if pos is greater than or equal to 0 and less than the total number of items within the list.
     * @return the job at the given position
     */
    @Override
    public Job get(int pos) {
        if(pos < 0 || pos >= numItems){
            throw new IndexOutOfBoundsException();
        }
        Listnode<Job> curr = head;

        for(int i = 0; i < pos + 1 ; i++){
            curr = curr.getNext();
        }
        return curr.getData();
    }
    /**
     * @return true if numItems is greater than 0; false if not
     */
    @Override
    public boolean isEmpty() {
        return numItems > 0;
    }
    /**
     * @param pos: the position in the list that you would like to remove.
     *  if pos is greater than or equal to 0 and less than the total number of items within the list
     *  Removes the item at the postion given and decrements numItems by 1.
     *  @return toRemove.getData(): which is the item that was removed from the list
     */
    @Override
    public Job remove(int pos) {
        if(pos < 0 || pos >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        Listnode<Job> temp = head;

        for(int i = 0; i < pos; i++){
           temp = temp.getNext();
        }
        Listnode<Job> toRemove = temp.getNext();
        temp.setNext(toRemove.getNext());

        numItems--;
        return toRemove.getData();
    }
    /**
     * @return numItems: Number of items in the list
     */
    @Override
    public int size() {
        return numItems;
    }
    /**
     * @return a new iterator that can iterate through the list of Jobs.
     */
    @Override
    public Iterator<Job> iterator() {
        return new JobListIterator(head, numItems);
    }
}
