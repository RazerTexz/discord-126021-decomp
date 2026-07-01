package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public class LiveData$1 implements Runnable {
    public final /* synthetic */ LiveData this$0;

    public LiveData$1(LiveData liveData) {
        this.this$0 = liveData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        synchronized (this.this$0.mDataLock) {
            obj = this.this$0.mPendingData;
            this.this$0.mPendingData = LiveData.NOT_SET;
        }
        this.this$0.setValue(obj);
    }
}
