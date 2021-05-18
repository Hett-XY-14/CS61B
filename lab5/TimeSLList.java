import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast(1000, 128000, 2, 1000);
    }

    public static void timeGetLast(int start, int end, int mult, int numberOperations) {
        List<Integer> numberOfItems = new ArrayList<>();
        List<Double> operationTimes = new ArrayList<>();
        List<Integer> numberOfOperations = new ArrayList<>();
        SLList<Integer> intSLList = new SLList<>();

        for (int i  = start; i <= end; i *= mult) {
            for (int j = 1; j <= i; j += 1) {
                intSLList.addLast(i);
            }
            Stopwatch timer = new Stopwatch();
            for (int k  = 0; k <= numberOperations; k += 1) {
                intSLList.getLast();
            }
            double operationTime = timer.elapsedTime();

            numberOfItems.add(i);
            operationTimes.add(operationTime);
            numberOfOperations.add(numberOperations);
        }

        printTimingTable(numberOfItems, operationTimes, numberOfOperations);
    }

}
