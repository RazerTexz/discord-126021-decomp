package androidx.room;

import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public class RoomTrackingLiveData$1 implements Runnable {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    public RoomTrackingLiveData$1(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0053 */
    @Override // java.lang.Runnable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z2;
        if (this.this$0.mRegisteredObserver.compareAndSet(false, true)) {
            this.this$0.mDatabase.getInvalidationTracker().addWeakObserver(this.this$0.mObserver);
        }
        do {
            if (this.this$0.mComputing.compareAndSet(false, true)) {
                Object objCall = null;
                z2 = false;
                while (this.this$0.mInvalid.compareAndSet(true, false)) {
                    try {
                        objCall = this.this$0.mComputeFunction.call();
                        z2 = true;
                    } catch (Exception e) {
                        throw new RuntimeException("Exception while computing database live data.", e);
                    }
                }
                if (z2) {
                    RoomTrackingLiveData.access$000(this.this$0, objCall);
                }
                this.this$0.mComputing.set(false);
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        } while (this.this$0.mInvalid.get());
    }
}
