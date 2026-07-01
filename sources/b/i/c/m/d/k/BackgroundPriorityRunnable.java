package b.i.c.m.d.k;

import android.os.Process;

/* JADX INFO: renamed from: b.i.c.m.d.k.d, reason: use source file name */
/* JADX INFO: compiled from: BackgroundPriorityRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
