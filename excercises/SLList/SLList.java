public class SLList {
    private  class IntNode {
        public int item;
        public IntNode next;
        public IntNode previous;

        public IntNode(int i, IntNode n, IntNode e) {
            item = i;
            next = n;
            previous = e;
        }
    }

    private IntNode sentinel;
    private int size;
    private IntNode last;

    /**	C r e a t e s  a n  e m p t y  S L L i s t	*/
    public SLList() {
        sentinel = new IntNode(67, null, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(67, null, null);
	sentinel.next = new IntNode(x, null, sentinel);
        last = sentinel.next;
        size = 1;
    }

    /*	A  D  D    F  I  R  S  T	*/
    public void addFirst(int x) {
        IntNode oldFirst = sentinel.next;
        sentinel.next = new IntNode(x, sentinel.next, sentinel);
        oldFirst.previous = sentinel.next;
        size += 1;
    }

    public IntNode getFirst() {
        return sentinel.next;
    }

    /*	A  D  D    L  A  S  T	*/
    private void addLastPrivate(IntNode p, int x) {
        if (p.next == null) {
            p.next = new IntNode(x, null, p);
            last = p.next;
            size += 1;
        }
        else {
            addLastPrivate(p.next, x);
        }  
    }
    
    public void addLast(int x) {
        addLastPrivate(last, x);
    }

    /*	G  E  T    L  A  S  T	*/
    private static IntNode getLast(IntNode p) {
        if (p == null) {
            System.out.println("Error: Lista vacía");
            return null;
        }
        if (p.next == null) {
            return p;
        }
        return getLast(p.next);
    } 

    public IntNode getLast() {
        return getLast(last);
    }

    /*	R E M O V E   L A S T	*/
    private void removeLast(IntNode p) {
        IntNode pointer = p.previous.previous;
        last = p.previous;
        last.next = null;
        last.previous = pointer;
        size -= 1;
        System.out.println("last item removed succefully");
        System.out.println("current last node: " + last.item);
        System.out.println("current previous node: " + last.previous.item);
    }

    public void removeLast() {
        removeLast(last);
    }

    /*	G  E  T    S  I  Z  E	*/
    public int size() {
        System.out.println("List Size: "+ size);
        return size;
    }

    /*  I  N  S  E  R  T  */
    public void insert(int x, int position) {
        if (position >= size) {
            addLast(x);
        } else  {
            insert(x, position, getFirst());
        }
    }

    private void insert(int x, int position, IntNode current) {
        if (position == 0) {
            IntNode newNode = new IntNode(x, current, current.previous);
            current.previous.next = newNode;
            current.previous = newNode;
            size += 1;
        } else {
            insert(x, position - 1, current.next);
        }
    }

    /*  R  E  M  O  V  E    I  T  E  M  */
    public void removeItem(int x) {
        removeItem(x, getFirst());
    }

    private void removeItem(int x, IntNode current) {
        if (current == null) {
            System.out.println("All items: '" + x + "' removed successfully");
        } else if (current.item == x) {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size -= 1;
            removeItem(x, current.next);
        } else {
            removeItem(x, current.next);
        }
    }

    /*  P  R  I  N  T    L  I  S  T  */
    public void printList() {
        int i = 0;
        IntNode currentNode = getFirst();
        while(i < size) {
            System.out.println("Position: " + i + " Item: " + currentNode.item);
            currentNode = currentNode.next;
            i += 1;
        }
    }

    /*  R  E  V  E  R  S  E    L  I  S  T  */
    public void reverse() {
        reverse(getLast());
    }

    private void reverse(IntNode current) {
        if (current.previous == sentinel) {
            current.previous.next = last;
            current.previous = current.next;
            current.next = null;
            last = current;
        } else {
            IntNode tempNode = current;
            current.next = tempNode.previous;
            current.previous = tempNode.next;
            reverse(tempNode.previous);
        }
    }

    /*	M  A  I  N    M  E  T  H  O  D	*/

    public static void main(String[] args) {
        SLList L = new SLList(10);

        L.addFirst(9);
        L.addFirst(8);
        L.addFirst(7);

        L.addLast(11);
        L.addLast(12);
        L.addLast(13);

        L.printList();
        System.out.println(" End of section ---------");

        L.insert(6,0);
        L.insert(14, 100);
        L.insert(0, 6);

        L.printList();
        System.out.println(" End of section ---------");

        L.size();
        L.removeLast();

        L.printList();
        System.out.println(" End of section ---------");

        System.out.println(L.getFirst().item);
        System.out.println(L.getFirst().next.item);
        System.out.println(L.sentinel.next.item);
        System.out.println(L.getLast());

        L.printList();
        System.out.println(" End of section ---------");

        L.insert(0, 7);
        L.insert(0, 9);
        L.insert(0, 4);
        L.insert(0, 9);

        L.printList();
        System.out.println(" End of section ---------");

        L.removeItem(0);
        L.printList();
        System.out.println(" End of section ---------");

        L.reverse();
        L.printList();
        System.out.println(L.getLast().item);
        System.out.println(L.getFirst().item);
        System.out.println(L.sentinel.next.item);

        System.out.println(" End of section ---------");
    }
}
