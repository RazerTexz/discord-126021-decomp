package b.f.j.e;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.f.j.e.o, reason: use source file name */
/* JADX INFO: compiled from: PriorityThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class PriorityThreadFactory2 implements ThreadFactory {
    public final int j;
    public final String k;
    public final boolean l;
    public final AtomicInteger m = new AtomicInteger(1);

    /* JADX INFO: renamed from: b.f.j.e.o$a */
    /* JADX INFO: compiled from: PriorityThreadFactory.java */
    public class a implements Runnable {
        public final /* synthetic */ Runnable j;

        public a(Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(PriorityThreadFactory2.this.j);
            } catch (Throwable unused) {
            }
            this.j.run();
        }
    }

    public PriorityThreadFactory2(int i, String str, boolean z2) {
        this.j = i;
        this.k = str;
        this.l = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.l) {
            str = this.k + "-" + this.m.getAndIncrement();
        } else {
            str = this.k;
        }
        return new Thread(aVar, str);
    }
}
