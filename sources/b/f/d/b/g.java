package b.f.d.b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: UiThreadImmediateExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends d {
    public static g k;

    public g() {
        super(new Handler(Looper.getMainLooper()));
    }

    @Override // b.f.d.b.d, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.j.getLooper().getThread()) {
            runnable.run();
        } else {
            this.j.post(runnable);
        }
    }
}
