import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ahmad on 2/18/2017.
 */
public class JobListIterator implements Iterator<Job> {
    Listnode <Job> headerNode;
    int currPos;
    int numItems;


    public JobListIterator(Listnode <Job> header, int numItems){
        headerNode = header;
        currPos = 0;
        this.numItems = numItems;
    }
    @Override
    public boolean hasNext() {
        return currPos < numItems;
    }

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
