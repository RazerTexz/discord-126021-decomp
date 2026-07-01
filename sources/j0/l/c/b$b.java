package j0.l.c;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b$c[] f3788b;
    public long c;

    public b$b(ThreadFactory threadFactory, int i) {
        this.a = i;
        this.f3788b = new b$c[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f3788b[i2] = new b$c(threadFactory);
        }
    }

    public b$c a() {
        int i = this.a;
        if (i == 0) {
            return b.f3787b;
        }
        b$c[] b_cArr = this.f3788b;
        long j = this.c;
        this.c = 1 + j;
        return b_cArr[(int) (j % ((long) i))];
    }
}
