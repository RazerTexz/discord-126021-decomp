package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window$OnFrameMetricsAvailableListener;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class FrameMetricsAggregator$FrameMetricsApi24Impl extends FrameMetricsAggregator$FrameMetricsBaseImpl {
    private static final int NANOS_PER_MS = 1000000;
    private static final int NANOS_ROUNDING_VALUE = 500000;
    private static Handler sHandler;
    private static HandlerThread sHandlerThread;
    public int mTrackingFlags;
    public SparseIntArray[] mMetrics = new SparseIntArray[9];
    private ArrayList<WeakReference<Activity>> mActivities = new ArrayList<>();
    public Window$OnFrameMetricsAvailableListener mListener = new FrameMetricsAggregator$FrameMetricsApi24Impl$1(this);

    public FrameMetricsAggregator$FrameMetricsApi24Impl(int i) {
        this.mTrackingFlags = i;
    }

    @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
    public void add(Activity activity) {
        if (sHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            sHandlerThread = handlerThread;
            handlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
        for (int i = 0; i <= 8; i++) {
            SparseIntArray[] sparseIntArrayArr = this.mMetrics;
            if (sparseIntArrayArr[i] == null && (this.mTrackingFlags & (1 << i)) != 0) {
                sparseIntArrayArr[i] = new SparseIntArray();
            }
        }
        activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
        this.mActivities.add(new WeakReference<>(activity));
    }

    public void addDurationItem(SparseIntArray sparseIntArray, long j) {
        if (sparseIntArray != null) {
            int i = (int) ((500000 + j) / 1000000);
            if (j >= 0) {
                sparseIntArray.put(i, sparseIntArray.get(i) + 1);
            }
        }
    }

    @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
    public SparseIntArray[] getMetrics() {
        return this.mMetrics;
    }

    @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
    public SparseIntArray[] remove(Activity activity) {
        for (WeakReference<Activity> weakReference : this.mActivities) {
            if (weakReference.get() == activity) {
                this.mActivities.remove(weakReference);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
        return this.mMetrics;
    }

    @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
    public SparseIntArray[] reset() {
        SparseIntArray[] sparseIntArrayArr = this.mMetrics;
        this.mMetrics = new SparseIntArray[9];
        return sparseIntArrayArr;
    }

    @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
    public SparseIntArray[] stop() {
        for (int size = this.mActivities.size() - 1; size >= 0; size--) {
            WeakReference<Activity> weakReference = this.mActivities.get(size);
            Activity activity = weakReference.get();
            if (weakReference.get() != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                this.mActivities.remove(size);
            }
        }
        return this.mMetrics;
    }
}
