package b.i.a.f.e.o.j;

import android.os.Process;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final Runnable j;

    public b(Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.j.run();
    }
}
