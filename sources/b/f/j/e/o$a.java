package b.f.j.e;

import android.os.Process;

/* JADX INFO: compiled from: PriorityThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class o$a implements Runnable {
    public final /* synthetic */ Runnable j;
    public final /* synthetic */ o k;

    public o$a(o oVar, Runnable runnable) {
        this.k = oVar;
        this.j = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(this.k.j);
        } catch (Throwable unused) {
        }
        this.j.run();
    }
}
