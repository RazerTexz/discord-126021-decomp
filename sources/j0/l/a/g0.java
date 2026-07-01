package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable$a;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0<T> implements Observable$a<T> {
    public final Observable<T> j;
    public final long k;
    public final TimeUnit l;
    public final Scheduler m;
    public final Observable<? extends T> n;

    public g0(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, Observable<? extends T> observable2) {
        this.j = observable;
        this.k = j;
        this.l = timeUnit;
        this.m = scheduler;
        this.n = observable2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        g0$b g0_b = new g0$b(subscriber, this.k, this.l, this.m.a(), this.n);
        subscriber.add(g0_b.r);
        subscriber.setProducer(g0_b.o);
        g0_b.q.a(g0_b.m.b(new g0$b$a(g0_b, 0L), g0_b.k, g0_b.l));
        this.j.U(g0_b);
    }
}
