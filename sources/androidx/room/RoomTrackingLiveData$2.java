package androidx.room;

import androidx.annotation.MainThread;

/* JADX INFO: loaded from: classes.dex */
public class RoomTrackingLiveData$2 implements Runnable {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    public RoomTrackingLiveData$2(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    @Override // java.lang.Runnable
    @MainThread
    public void run() {
        boolean zHasActiveObservers = this.this$0.hasActiveObservers();
        if (this.this$0.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
            this.this$0.getQueryExecutor().execute(this.this$0.mRefreshRunnable);
        }
    }
}
