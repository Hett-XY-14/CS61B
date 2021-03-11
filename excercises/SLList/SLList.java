public class SLList {
    private  class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

/**	C r e a t e s  a n  e m p t y  S L L i s t	*/
    public SLList() {
        sentinel = new IntNode(67, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(67, null);
	sentinel.next = new IntNode(x, null);
        size = 1;
    }

/*	A  D  D    F  I  R  S  T	*/

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

/*	A  D  D    L  A  S  T	*/
    
    private void addLastPrivate(IntNode p, int x) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
            size += 1;
        }
        else {
            addLastPrivate(p.next, x);
        }  
    }
    
    public void addLast(int x) {
        addLastPrivate(sentinel, x);
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
        return getLast(sentinel.next);
    }

/*	G  E  T    S  I  Z  E	*/
    
    public int size() {
        return size;
    }

/*	M  A  I  N    M  E  T  H  O  D	*/

    public static void main(String[] args) {
        SLList L = new SLList(10)  ;
        /*System.out.println(L);*/
        L.addFirst(12);
        System.out.println(L.getFirst());
        L.addLast(3);
        System.out.println(L.getLast());
        System.out.println(L.size());
    }
}
