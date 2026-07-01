package j0.l.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler$Worker;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends Scheduler implements k {
    public static final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeUnit f3785b = TimeUnit.SECONDS;
    public static final a$c c;
    public static final a$a d;
    public final ThreadFactory e;
    public final AtomicReference<a$a> f;

    static {
        a$c a_c = new a$c(j0.l.e.j.j);
        c = a_c;
        a_c.unsubscribe();
        a$a a_a = new a$a(null, 0L, null);
        d = a_a;
        a_a.a();
        a = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.e = threadFactory;
        a$a a_a = d;
        AtomicReference<a$a> atomicReference = new AtomicReference<>(a_a);
        this.f = atomicReference;
        a$a a_a2 = new a$a(threadFactory, a, f3785b);
        if (atomicReference.compareAndSet(a_a, a_a2)) {
            return;
        }
        a_a2.a();
    }

    @Override // rx.Scheduler
    public Scheduler$Worker a() {
        return new a$b(this.f.get());
    }

    @Override // j0.l.c.k
    public void shutdown() {
        a$a a_a;
        a$a a_a2;
        do {
            a_a = this.f.get();
            a_a2 = d;
            if (a_a == a_a2) {
                return;
            }
        } while (!this.f.compareAndSet(a_a, a_a2));
        a_a.a();
    }
}
