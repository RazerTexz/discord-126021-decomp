package j0.l.a;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable$a;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1<T> extends j0.m.b<T> implements Subscription {
    public static final Func0 k = new j1$a();
    public final Observable<? extends T> l;
    public final AtomicReference<j1$f<T>> m;
    public final Func0<? extends j1$e<T>> n;

    public j1(Observable$a<T> observable$a, Observable<? extends T> observable, AtomicReference<j1$f<T>> atomicReference, Func0<? extends j1$e<T>> func0) {
        super(observable$a);
        this.l = observable;
        this.m = atomicReference;
        this.n = func0;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        j1$f<T> j1_f = this.m.get();
        return j1_f == null || j1_f.isUnsubscribed();
    }

    @Override // j0.m.b
    public void k0(Action1<? super Subscription> action1) {
        j1$f<T> j1_f;
        while (true) {
            j1_f = this.m.get();
            if (j1_f != null && !j1_f.isUnsubscribed()) {
                break;
            }
            j1$f<T> j1_f2 = new j1$f<>(this.n.call());
            j1_f2.add(new j0.r.a(new m1(j1_f2)));
            if (this.m.compareAndSet(j1_f, j1_f2)) {
                j1_f = j1_f2;
                break;
            }
        }
        boolean z2 = !j1_f.r.get() && j1_f.r.compareAndSet(false, true);
        ((z) action1).call(j1_f);
        if (z2) {
            this.l.i0(j1_f);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.m.lazySet(null);
    }
}
