package b.f.d.b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: b.f.d.b.g, reason: use source file name */
/* JADX INFO: compiled from: UiThreadImmediateExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    public static UiThreadImmediateExecutorService k;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    @Override // b.f.d.b.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.j.getLooper().getThread()) {
            runnable.run();
        } else {
            this.j.post(runnable);
        }
    }
}
