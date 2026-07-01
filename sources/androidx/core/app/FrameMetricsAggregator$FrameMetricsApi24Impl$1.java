package androidx.core.app;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;

/* JADX INFO: loaded from: classes.dex */
public class FrameMetricsAggregator$FrameMetricsApi24Impl$1 implements Window$OnFrameMetricsAvailableListener {
    public final /* synthetic */ FrameMetricsAggregator$FrameMetricsApi24Impl this$0;

    public FrameMetricsAggregator$FrameMetricsApi24Impl$1(FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl) {
        this.this$0 = frameMetricsAggregator$FrameMetricsApi24Impl;
    }

    @Override // android.view.Window$OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl.mTrackingFlags & 1) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl.mMetrics[0], frameMetrics.getMetric(8));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl2 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl2.mTrackingFlags & 2) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl2.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl2.mMetrics[1], frameMetrics.getMetric(1));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl3 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl3.mTrackingFlags & 4) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl3.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl3.mMetrics[2], frameMetrics.getMetric(3));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl4 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl4.mTrackingFlags & 8) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl4.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl4.mMetrics[3], frameMetrics.getMetric(4));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl5 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl5.mTrackingFlags & 16) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl5.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl5.mMetrics[4], frameMetrics.getMetric(5));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl6 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl6.mTrackingFlags & 64) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl6.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl6.mMetrics[6], frameMetrics.getMetric(7));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl7 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl7.mTrackingFlags & 32) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl7.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl7.mMetrics[5], frameMetrics.getMetric(6));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl8 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl8.mTrackingFlags & 128) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl8.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl8.mMetrics[7], frameMetrics.getMetric(0));
        }
        FrameMetricsAggregator$FrameMetricsApi24Impl frameMetricsAggregator$FrameMetricsApi24Impl9 = this.this$0;
        if ((frameMetricsAggregator$FrameMetricsApi24Impl9.mTrackingFlags & 256) != 0) {
            frameMetricsAggregator$FrameMetricsApi24Impl9.addDurationItem(frameMetricsAggregator$FrameMetricsApi24Impl9.mMetrics[8], frameMetrics.getMetric(2));
        }
    }
}
