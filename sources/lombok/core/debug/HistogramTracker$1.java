package lombok.core.debug;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/HistogramTracker$1.SCL.lombok */
class HistogramTracker$1 extends Thread {
    final /* synthetic */ HistogramTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistogramTracker$1(HistogramTracker histogramTracker, String $anonymous0) {
        super($anonymous0);
        this.this$0 = histogramTracker;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int[] currentInterval = new int[1];
        long[] b2 = (long[]) HistogramTracker.access$0(this.this$0).get(currentInterval);
        HistogramTracker.access$1(this.this$0, currentInterval[0], b2);
    }
}
