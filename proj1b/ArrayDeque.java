public class ArrayDeque<T> implements Deque<T>{
    public T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    // r  e  s  i  z  e
    // Resizes the array
    public void resize() {
        T[] newItems = (T[]) new Object[size * 2];
        int i = 0;
        do {
            newItems[nextFirst + 1 + i] = items[innerIndex(i)];
            i += 1;
        } while (innerIndex(i) != nextFirst);
        nextLast = nextFirst + items.length;
        items = newItems;
    }

    // r  e  s  i  z  e  D  o  w  n
    // Reduces the array size
    public void resizeDown() {
        T[] newItems = (T[]) new Object[items.length / 2];
        int i = 0;
        do {
            newItems[1 + i] = items[innerIndex(i)];
            i += 1;
        } while (innerIndex(i) != nextLast);
        nextFirst = 0;
        nextLast = nextFirst + size + 1;
        items = newItems;
    }

    // a  d  d  F  i  r  s  t
    // Adds an element in front of the deque
    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        if (nextFirst == nextLast) {
            resize();
        }
    }
    // a  d  d  L  a  s  t
    // Adds an element in the back of the deque
    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast == items.length) {
            nextLast = 0;
        }
        if (nextLast == nextFirst) {
            resize();
        }
    }

    // s  i  z  e
    // Returns the size of the deque
    @Override
    public int size() {
        return size;
    }

    // p  r  i  n  t  D  e  q  u  e
    // Prints the items in the deque from first to last separated by a space
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            T item = items[innerIndex(i)];
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    // r  e  m  o  v  e  F  i  r  s  t
    // Removes and returns the first element
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T toReturn;
        size -= 1;

        if (nextFirst == items.length - 1){
            toReturn = items[0];
            nextFirst = 0;
        } else {
            toReturn = items[nextFirst + 1];
            nextFirst += 1;
        }
        if (getRatio() < 0.25 && items.length > 8) {
            resizeDown();
        }
        return toReturn;
    }

    // r  e  m  o  v  e  L  a  s  t
    // Removes and returns the last element
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T toReturn;
        size -= 1;

        if (nextLast == 0) {
            toReturn = items[items.length - 1];
            nextLast = items.length - 1;
        } else {
            toReturn = items[nextLast - 1];
            nextLast -= 1;
        }
        if (getRatio() < 0.25 && items.length > 8) {
            resizeDown();
        }
        return toReturn;
    }

    //   g  e  t
    // Gets the item at the given index, where 0 is the front, 1 is the next item, etc.
    @Override
    public T get(int index) {
        if (innerIndex(index) >= nextLast && innerIndex(index) <= nextFirst) {
            return null;
        } else {
            return items[innerIndex(index)];
        }
    }

    // i  n  n  e  r  I  n  d  e  x
    // Returns the inner array index at a given deque index
    public int innerIndex(int index) {
        int innerIndex = nextFirst + 1 + index;
        if (innerIndex >= items.length) {
            return innerIndex - items.length;
        } else {
            return innerIndex;
        }
    }

    // g  e  t  R  a  t  i  o
    public double getRatio() {
        return  (double) size / items.length;
    }

    // p  r  i  n  t  A  r  r  a  y  S  i  z  e
    public void printArraySize() {
        System.out.println(items.length);
    }
}
