package j0.l.a;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable$a;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1<T> extends j0.m.b<T> {
    public final Observable<? extends T> k;
    public final AtomicReference<h1$b<T>> l;

    public h1(Observable$a<T> observable$a, Observable<? extends T> observable, AtomicReference<h1$b<T>> atomicReference) {
        super(observable$a);
        this.k = observable;
        this.l = atomicReference;
    }

    @Override // j0.m.b
    public void k0(Action1<? super Subscription> action1) {
        h1$b<T> h1_b;
        while (true) {
            h1_b = this.l.get();
            if (h1_b != null && !h1_b.isUnsubscribed()) {
                break;
            }
            h1$b<T> h1_b2 = new h1$b<>(this.l);
            h1_b2.add(new j0.r.a(new i1(h1_b2)));
            if (this.l.compareAndSet(h1_b, h1_b2)) {
                h1_b = h1_b2;
                break;
            }
        }
        boolean z2 = !h1_b.p.get() && h1_b.p.compareAndSet(false, true);
        ((z) action1).call(h1_b);
        if (z2) {
            this.k.i0(h1_b);
        }
    }
}
