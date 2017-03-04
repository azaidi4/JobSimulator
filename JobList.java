import java.util.Iterator;

/**
 * Created by ahmad on 2/18/2017.
 */
public class JobList implements ListADT<Job> {
     private Listnode<Job> head;
     private int numItems;

    /**
     *
      */
    public JobList() {
        head = new Listnode<Job>(null);
        numItems = 0;
    }
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

    @Override
    public boolean isEmpty() {
        return numItems > 0;
    }

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

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator<Job> iterator() {
        return new JobListIterator(head, numItems);
    }
}
