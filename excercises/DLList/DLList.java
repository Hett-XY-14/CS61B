public class DLList {
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
    public DLList() {
        sentinel = new IntNode(67, null, null);
        size = 0;
    }

    public DLList(int x) {
        sentinel = new IntNode(67, null, null);
	sentinel.next = new IntNode(x, null, sentinel);
        last = sentinel.next;
        size = 1;
    }

/*	A  D  D    F  I  R  S  T	*/

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next, sentinel);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
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

    private static int getLast(IntNode p) {
        if (p == null) {
            System.out.println("Error: Lista vacía");
            return 0;
        }
        if (p.next == null) {
            return p.item;
        }
        return getLast(p.next);
    } 

    public int getLast() {
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

/*	M  A  I  N    M  E  T  H  O  D	*/

    public static void main(String[] args) {
        DLList L = new DLList(10)  ;
        /*System.out.println(L);*/
        L.addFirst(12);
        System.out.println(L.getFirst());
        L.addLast(3);
        L.addLast(4);
        L.addLast(5);
        System.out.println(L.getLast());
        System.out.println(L.size());
        L.removeLast();
        System.out.println(L.size());
    }
}
