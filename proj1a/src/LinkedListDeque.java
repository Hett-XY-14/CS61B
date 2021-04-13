/** A class implementation of a double ended deque
 *  based on linked list
 * @version 1.0.0 09/04/2021
 * @author Henry Hernández
 */

public class LinkedListDeque<T> {
    private class ItemNode {
        public T item;
        public ItemNode next;
        public ItemNode previous;

        public ItemNode(T i, ItemNode p, ItemNode n) {
            item = i;
            next = n;
            previous = p;
        }
    }
    private int size;
    private final ItemNode sentinel;

    // Creates an empty linked list deque
    public LinkedListDeque(){
        sentinel = new ItemNode((T) new Object(), null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }
    // Creates a one element new deque
    public LinkedListDeque(T item) {
        sentinel = new ItemNode( (T) new Object(), null, null);
        sentinel.next = new ItemNode(item, sentinel, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }
    // Adds a new element in front of the deque
    public void addFirst(T item) {
        sentinel.next.previous = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.previous;
        size += 1;
    }
    // Adds a new element in the last position of the deque
    public void addLast(T item) {
        sentinel.previous.next = new ItemNode(item, sentinel.previous, sentinel);
        sentinel.previous = sentinel.previous.next;
        size += 1;
    }
    // Returns true if the deque is empty, false otherwise
    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }
    // Returns the size of the deque
    public int size() {
        return size;
    }
    // Prints all the items in the deque
    public void printDeque() {

        if (this.isEmpty()) {
            System.out.println("The list is empty"+ "\n");
        } else {
            printDeque(sentinel.next);
            System.out.println("");
        }
    }

    private void printDeque(ItemNode node) {
        if (node.next == sentinel) {
            System.out.print(node.item + " ");
            return;
        }
        System.out.print(node.item + " ");
        printDeque(node.next);
    }

    // Removes the first element of the deque
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        ItemNode removed = sentinel.next;
        sentinel.next.next.previous = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removed.item;
    }
    // Removes the last element of the deque
    public T removeLast() {
        if (sentinel.previous == sentinel) {
            return null;
        }
        ItemNode removed = sentinel.previous;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
        size -= 1;
        return removed.item;
    }
    // Gets the item at the given index
    public T get(int index) {
        ItemNode current = sentinel;
        for (int i = 0; i <= index; i += 1) {
            current = current.next;
        }
        return current.item;
    }
    // Gets the item at a given index (method implemented recursively
    public T getRecursive(int index) {
        ItemNode returnedNode = getRecursive(index, sentinel.next);
        return returnedNode.item;
    }

    private ItemNode getRecursive(int index, ItemNode current) {
        if (index == 0) {
            return current;
        } else {
            return getRecursive(index - 1, current.next);
        }
    }
}