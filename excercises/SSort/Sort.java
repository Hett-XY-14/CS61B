public class Sort {
    public static void ssort (String[] x) {
        ssort(x, 0);
    }
    
    public static int fndSmallest (String[] x, int start) {
        int smallestIndex = start;
        for(int i = start ; i < x.length ; i += 1) {
            if (x[smallestIndex].compareTo(x[i]) > 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap (String[] x, int a, int b) {
        String temp = x[ a];
        x[a] = x[b];
        x[b] = temp;
    }

    private static void ssort(String[] x, int start) {
        if (start == x.length){
            return;
        }
            int smallestIndex = fndSmallest(x, start);
            swap(x, start, smallestIndex);
            ssort(x, start + 1);
    }

}