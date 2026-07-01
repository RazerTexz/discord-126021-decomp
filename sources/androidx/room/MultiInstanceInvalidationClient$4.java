package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient$4 implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$4(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
    }
}
