package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Process;

/* JADX INFO: renamed from: b.i.c.m.d.k.d */
/* JADX INFO: compiled from: BackgroundPriorityRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC4616d implements Runnable {
    /* JADX INFO: renamed from: a */
    public abstract void mo6398a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        mo6398a();
    }
}
