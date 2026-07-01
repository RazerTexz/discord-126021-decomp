package j0.l.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler$Worker;

/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends Scheduler implements k {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b$c f3787b;
    public static final b$b c;
    public final ThreadFactory d;
    public final AtomicReference<b$b> e;

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        a = iIntValue;
        b$c b_c = new b$c(j0.l.e.j.j);
        f3787b = b_c;
        b_c.unsubscribe();
        c = new b$b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.d = threadFactory;
        b$b b_b = c;
        AtomicReference<b$b> atomicReference = new AtomicReference<>(b_b);
        this.e = atomicReference;
        b$b b_b2 = new b$b(threadFactory, a);
        if (atomicReference.compareAndSet(b_b, b_b2)) {
            return;
        }
        for (b$c b_c : b_b2.f3788b) {
            b_c.unsubscribe();
        }
    }

    @Override // rx.Scheduler
    public Scheduler$Worker a() {
        return new b$a(this.e.get().a());
    }

    @Override // j0.l.c.k
    public void shutdown() {
        b$b b_b;
        b$b b_b2;
        do {
            b_b = this.e.get();
            b_b2 = c;
            if (b_b == b_b2) {
                return;
            }
        } while (!this.e.compareAndSet(b_b, b_b2));
        for (b$c b_c : b_b.f3788b) {
            b_c.unsubscribe();
        }
    }
}
