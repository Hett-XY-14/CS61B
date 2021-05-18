import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
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
        timeAListConstruction(1000,128000000, 2);
    }

    public static void timeAListConstruction(int start, int end, int mult) {
        List<Integer> n = new ArrayList<>();
        List<Double> times = new ArrayList<>();

        for (int i  = start; i <= end; i *= mult) {
            n.add(i);
            AList<Integer> testAlist = new AList<>();
            Stopwatch time = new Stopwatch();
            for (int j = 1; j <= i; j += 1) {
                testAlist.addLast(j);
            }
            double operationTime = time.elapsedTime();
            times.add(operationTime);
        }

        printTimingTable(n, times, n);
    }
}