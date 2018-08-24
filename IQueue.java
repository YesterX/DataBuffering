package Queue;

/**
 * This interface describes which methods a queue data storage must implement.
 *
 * @author Michael Hoog
 */
public interface IQueue {

    /**
     * @param obj Data object to store in queue.
     * @throws ArrayIndexOutOfBoundsException Queue is full
     */
    void insert(Object obj);

    /**
     * @return java.lang.Object returnObj Data object first inserted to queue.
     */
    Object remove();

    /**
     * @return true|false
     */
    boolean empty();

    /**
     * @return true|false
     */
    boolean full();
}
