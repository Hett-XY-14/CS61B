public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}


/** Return the size of the list using recursion */

	public int size() {
		if (rest == null) {
			return 1;
		}
		return this.rest.size() + 1;
	}

/** Return the size of the list using iteration */
	public int iterativeSize() {
		int count;
		IntList next;
		count = 1;
		next = this.rest;
		while(next != null) {
			count += 1;
			next = next.rest;
		}
		return count;
	}

	public int get(int i) {
		if(i == 0) {
			return this.first;
		}
		return this.rest.get(i - 1);
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(14, L);
		L = new IntList(13, L);

		System.out.println(L.iterativeSize());
		System.out.println(L.size());
		System.out.println(L.get(2));
	}

}