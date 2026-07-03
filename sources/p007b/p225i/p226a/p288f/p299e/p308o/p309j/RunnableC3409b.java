package p007b.p225i.p226a.p288f.p299e.p308o.p309j;

import android.os.Process;

/* JADX INFO: renamed from: b.i.a.f.e.o.j.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3409b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final Runnable f9604j;

    public RunnableC3409b(Runnable runnable) {
        this.f9604j = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f9604j.run();
    }
}
