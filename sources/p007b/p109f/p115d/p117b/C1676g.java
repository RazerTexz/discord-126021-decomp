package p007b.p109f.p115d.p117b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: b.f.d.b.g */
/* JADX INFO: compiled from: UiThreadImmediateExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class C1676g extends ScheduledExecutorServiceC1673d {

    /* JADX INFO: renamed from: k */
    public static C1676g f3090k;

    public C1676g() {
        super(new Handler(Looper.getMainLooper()));
    }

    @Override // p007b.p109f.p115d.p117b.ScheduledExecutorServiceC1673d, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.f3088j.getLooper().getThread()) {
            runnable.run();
        } else {
            this.f3088j.post(runnable);
        }
    }
}
