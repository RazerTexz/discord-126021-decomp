package j0.l.a;

import rx.Observable$b;
import rx.Scheduler;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z0<T> implements Observable$b<T, T> {
    public final Scheduler j;
    public final boolean k;
    public final int l;

    public z0(Scheduler scheduler, boolean z2, int i) {
        this.j = scheduler;
        this.k = z2;
        this.l = i <= 0 ? j0.l.e.i.j : i;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler scheduler = this.j;
        if (scheduler instanceof j0.l.c.m) {
            return subscriber;
        }
        z0$a z0_a = new z0$a(scheduler, subscriber, this.k, this.l);
        Subscriber<? super T> subscriber2 = z0_a.j;
        subscriber2.setProducer(new y0(z0_a));
        subscriber2.add(z0_a.k);
        subscriber2.add(z0_a);
        return z0_a;
    }
}
