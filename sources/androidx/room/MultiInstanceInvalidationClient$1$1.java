package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient$1$1 implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient$1 this$1;
    public final /* synthetic */ String[] val$tables;

    public MultiInstanceInvalidationClient$1$1(MultiInstanceInvalidationClient$1 multiInstanceInvalidationClient$1, String[] strArr) {
        this.this$1 = multiInstanceInvalidationClient$1;
        this.val$tables = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.mInvalidationTracker.notifyObserversByTableNames(this.val$tables);
    }
}
