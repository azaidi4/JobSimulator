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
 * Created by ahmad on 2/24/2017.
 */
/**
 * This is the structure for a singly linked list node
 * Consists of the data to be stored in the node
 * and the link to the next node in the list
 * @param <E>
 */
public class Listnode<E>{

    /** The data members
     * data: Holds the value of each node in the list
     * next: Holds the link to the next node in list
     */
    private E data;
    private Listnode<E> next;
    /**
     * Constructor for instantiating a Listnode with only the data parameter.
     * @param data: Holds the value of each node in the list
     */
    public Listnode(E data) {
        this.data = data;
        this.next = null;
    }
    /**
     * Constructor for instantiating a Listnode with both the data and next parameter.
     * @param data: Holds the value of each node in the list
     * @param next: Holds the link to the next node in list
     */
    public Listnode(E data, Listnode<E> next) {
        this.data = data;
        this.next = next;
    }
    /**
     * 
     * @return data: which is the value of each node in the list.
     */
    public E getData() {
        return data;
    }
/**
 * Sets the value of data.
 * @param data: Holds the value of each node in the list
 */
    public void setData(E data) {
        this.data = data;
    }
/**
 * 
 * @return next: which is the link to the next node in the list.
 */
    public Listnode<E> getNext() {
        return next;
    }
/**
 * Sets the link to which node is next in the list.
 * @param next: Holds the link to the next node in list
 */
    public void setNext(Listnode<E> next) {
        this.next = next;
    }
}