package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public class Worker$1 implements Runnable {
    public final /* synthetic */ Worker this$0;

    public Worker$1(Worker worker) {
        this.this$0 = worker;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.this$0.mFuture.set(this.this$0.doWork());
        } catch (Throwable th) {
            this.this$0.mFuture.setException(th);
        }
    }
}
