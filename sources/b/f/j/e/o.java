package b.f.j.e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PriorityThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements ThreadFactory {
    public final int j;
    public final String k;
    public final boolean l;
    public final AtomicInteger m = new AtomicInteger(1);

    public o(int i, String str, boolean z2) {
        this.j = i;
        this.k = str;
        this.l = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        o$a o_a = new o$a(this, runnable);
        if (this.l) {
            str = this.k + "-" + this.m.getAndIncrement();
        } else {
            str = this.k;
        }
        return new Thread(o_a, str);
    }
}
