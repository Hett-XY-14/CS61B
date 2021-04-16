/** Array based generic items list.
 *  @author Henry H.
 */
public class AList<Item> {
    public Item[] items;
    private int size;
    private int factor;
    private float R;
    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
        factor = 2;
        R = size / items.length;
    }
    /** Resizes the underlying array to the double of its size */
    public void resize(int factor) {
        Item[] a = (Item[]) new Object [items.length * factor];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void halve() {
        Item[] a = (Item[]) new Object [items.length / 2];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(factor);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        if (R <= 0.25) {
            halve();
        }
        Item temp = getLast();
        items[size-1] = null;
        size -= 1;
        System.out.println("array length: " + items.length + " size: " + size);
        return temp;
    }
    /** Inserts an int item into and int[] arr at the given position
     * returns the array
     */
    public Item[] insert(Item item, int position) {
        if (position >= items.length) {
            resize(factor);
        }
        if (position >= size) {
            addLast(item);
            return items;
        }
        Item[] newItems = (Item[]) new Object[items.length];
        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = item;
        System.arraycopy(items, position, newItems, position + 1, size - position);
        items = newItems;
        size += 1;
        return items;
    }
}
