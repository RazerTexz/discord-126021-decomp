package j0.l.a;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n0<T> implements Observable$b<List<T>, T> {
    public final long j;
    public final long k;
    public final TimeUnit l;
    public final int m;
    public final Scheduler n;

    public n0(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.j = j;
        this.k = j2;
        this.l = timeUnit;
        this.m = i;
        this.n = scheduler;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler$Worker scheduler$WorkerA = this.n.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.j == this.k) {
            n0$a n0_a = new n0$a(this, serializedSubscriber, scheduler$WorkerA);
            n0_a.add(scheduler$WorkerA);
            subscriber.add(n0_a);
            Scheduler$Worker scheduler$Worker = n0_a.k;
            m0 m0Var = new m0(n0_a);
            long j = this.j;
            scheduler$Worker.c(m0Var, j, j, this.l);
            return n0_a;
        }
        n0$b n0_b = new n0$b(this, serializedSubscriber, scheduler$WorkerA);
        n0_b.add(scheduler$WorkerA);
        subscriber.add(n0_b);
        n0_b.a();
        Scheduler$Worker scheduler$Worker2 = n0_b.k;
        o0 o0Var = new o0(n0_b);
        long j2 = this.k;
        scheduler$Worker2.c(o0Var, j2, j2, this.l);
        return n0_b;
    }
}
