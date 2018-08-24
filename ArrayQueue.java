package Queue;

import java.lang.Object;

/**
 * This class implements the IQueue interface for a queue data storage.
 *
 * @author Michael Hoog
 * @version 1.0
 */
public class ArrayQueue implements IQueue {
    /**
     * Maximum size of queue data elements
     */
    private static final int MAX_SIZE = 5;

    /**
     * Data array to store queue data objects
     */
    private Object[] data;

    /**
     * Array read index
     */
    private int readIdx;

    /**
     * Array write index
     */
    private int writeIdx;

    /**
     * Number of items currently stored in queue.
     */
    private int nbrOfItems;

    /**
     * ArrayQueue constructor
     */
    ArrayQueue() {
        this.data = new Object[MAX_SIZE];
        this.readIdx = 0;
        this.writeIdx = 0;
        this.nbrOfItems = 0;
    }

    /**
     * @param obj Data object to store in queue.
     * @throws ArrayIndexOutOfBoundsException Queue is full
     */
    public void insert(Object obj) {
        if(full()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full.");
        } else {
            data[writeIdx] = obj;

            ++nbrOfItems;

            if(writeIdx == (MAX_SIZE - 1)) {
                writeIdx = 0;
            } else {
                ++writeIdx;
            }
        }
    }

    /**
     * @return returnObj|null Data object first inserted to queue.
     */
    public Object remove() {
        if(empty()) {
            return null;
        } else {
            Object returnObj = data[readIdx];

            --nbrOfItems;

            if(readIdx == (MAX_SIZE - 1)) {
                readIdx = 0;
            } else {
                ++readIdx;
            }

            return returnObj;
        }
    }

    /**
     * @return true|false
     */
    public boolean empty() {
        return (nbrOfItems == 0);
    }

    /**
     * @return true|false
     */
    public boolean full() {
        return (nbrOfItems == MAX_SIZE);
    }
}
