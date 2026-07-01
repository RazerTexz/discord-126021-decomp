package lombok.core.debug;

import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/HistogramTracker.SCL.lombok */
public class HistogramTracker {
    private static final long[] RANGES = {250001, 500001, 1000001, 2000001, 4000001, 8000001, 16000001, 32000001, 64000001, 128000001, 256000001, 512000001, 1024000001, 2048000001, 10000000001L};
    private static final long REPORT_WINDOW = 60000;
    private final String category;
    private final AtomicStampedReference<long[]> bars;
    private final AtomicBoolean addedSysHook;
    private final PrintStream out;

    static /* synthetic */ AtomicStampedReference access$0(HistogramTracker histogramTracker) {
        return histogramTracker.bars;
    }

    public HistogramTracker(String category) {
        this.bars = new AtomicStampedReference<>(new long[RANGES.length + 2], 0);
        this.addedSysHook = new AtomicBoolean(false);
        this.category = category;
        this.out = null;
        printInit();
    }

    public HistogramTracker(String category, PrintStream out) {
        this.bars = new AtomicStampedReference<>(new long[RANGES.length + 2], 0);
        this.addedSysHook = new AtomicBoolean(false);
        this.category = category;
        this.out = out;
        printInit();
    }

    private void printInit() {
        if (this.category == null) {
            if (this.out != null) {
                this.out.println("Initialized histogram");
                return;
            } else {
                ProblemReporter.info("Initialized histogram", null);
                return;
            }
        }
        if (this.out != null) {
            this.out.printf("Initialized histogram tracker for '%s'%n", this.category);
        } else {
            ProblemReporter.info(String.format("Initialized histogram tracker for '%s'", this.category), null);
        }
    }

    public long start() {
        return System.nanoTime();
    }

    public void end(long startToken) {
        long[] newBars;
        if (!this.addedSysHook.getAndSet(true)) {
            Runtime.getRuntime().addShutdownHook(new HistogramTracker$1(this, "Histogram Printer"));
        }
        long end = System.nanoTime();
        long now = System.currentTimeMillis();
        long delta = end - startToken;
        if (delta < 0) {
            delta = 0;
        }
        int interval = (int) (now / 60000);
        int[] currentInterval = new int[1];
        long[] bars = this.bars.get(currentInterval);
        if (currentInterval[0] != interval) {
            printReport(currentInterval[0], bars);
            newBars = new long[RANGES.length + 2];
            if (!this.bars.compareAndSet(bars, newBars, currentInterval[0], interval)) {
                newBars = this.bars.get(currentInterval);
            }
        } else {
            newBars = bars;
        }
        long[] jArr = newBars;
        int length = RANGES.length + 1;
        jArr[length] = jArr[length] + delta;
        for (int i = 0; i < RANGES.length; i++) {
            if (delta < RANGES[i]) {
                long[] jArr2 = newBars;
                int i2 = i;
                jArr2[i2] = jArr2[i2] + 1;
                return;
            }
        }
        long[] jArr3 = newBars;
        int length2 = RANGES.length;
        jArr3[length2] = jArr3[length2] + 1;
    }

    static /* synthetic */ void access$1(HistogramTracker histogramTracker, int i, long[] jArr) {
        histogramTracker.printReport(i, jArr);
    }

    private void printReport(int interval, long[] bars) {
        StringBuilder sb = new StringBuilder();
        if (this.category != null) {
            sb.append(this.category).append(" ");
        }
        sb.append("[");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(((long) interval) * 60000);
        int hour = gc.get(11);
        int minute = gc.get(12);
        if (hour < 10) {
            sb.append('0');
        }
        sb.append(hour).append(":");
        if (minute < 10) {
            sb.append('0');
        }
        sb.append(minute).append("] {");
        long sum = bars[RANGES.length];
        int count = 0;
        int lastZeroPos = sb.length();
        for (int i = 0; i < RANGES.length; i++) {
            sum += bars[i];
            sb.append(bars[i]);
            if (bars[i] != 0) {
                lastZeroPos = sb.length();
            }
            sb.append(" ");
            count++;
            if (count == 3) {
                sb.append("-- ");
            }
            if (count == 9) {
                sb.append("-- ");
            }
        }
        if (sum == 0) {
            return;
        }
        sb.setLength(lastZeroPos);
        double millis = bars[RANGES.length + 1] / 1000000.0d;
        long over = bars[RANGES.length];
        if (over > 0) {
            sb.append(" -- ").append(bars[RANGES.length]);
        }
        sb.append("} total calls: ").append(sum).append(" total time (millis): ").append((int) (millis + 0.5d));
        if (this.out != null) {
            this.out.println(sb.toString());
        } else {
            ProblemReporter.info(sb.toString(), null);
        }
    }
}
