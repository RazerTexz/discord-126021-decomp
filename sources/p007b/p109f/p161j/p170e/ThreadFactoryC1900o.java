package p007b.p109f.p161j.p170e;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.f.j.e.o */
/* JADX INFO: compiled from: PriorityThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryC1900o implements ThreadFactory {

    /* JADX INFO: renamed from: j */
    public final int f3809j;

    /* JADX INFO: renamed from: k */
    public final String f3810k;

    /* JADX INFO: renamed from: l */
    public final boolean f3811l;

    /* JADX INFO: renamed from: m */
    public final AtomicInteger f3812m = new AtomicInteger(1);

    /* JADX INFO: renamed from: b.f.j.e.o$a */
    /* JADX INFO: compiled from: PriorityThreadFactory.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Runnable f3813j;

        public a(Runnable runnable) {
            this.f3813j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(ThreadFactoryC1900o.this.f3809j);
            } catch (Throwable unused) {
            }
            this.f3813j.run();
        }
    }

    public ThreadFactoryC1900o(int i, String str, boolean z2) {
        this.f3809j = i;
        this.f3810k = str;
        this.f3811l = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.f3811l) {
            str = this.f3810k + "-" + this.f3812m.getAndIncrement();
        } else {
            str = this.f3810k;
        }
        return new Thread(aVar, str);
    }
}
