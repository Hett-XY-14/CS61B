package es.datastructur.synthesizer;

public interface BoundedQueue<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return the number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from front
    default boolean isEmpty() {
        return (fillCount() == 0);  // True if there's no items in the buffer, false otherwise
    }
    default boolean isFull() {
        return fillCount() == capacity();   // True if the buffer is full, false otherwise
    }
}
