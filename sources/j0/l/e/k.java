package j0.l.e;

import rx.Observable;
import rx.Scheduler;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends Observable<T> {
    public static final boolean k = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T l;

    public k(T t) {
        super(j0.o.l.a(new k$d(t)));
        this.l = t;
    }

    public <R> Observable<R> k0(j0.k.b<? super T, ? extends Observable<? extends R>> bVar) {
        return Observable.h0(new k$c(this, bVar));
    }

    public Observable<T> l0(Scheduler scheduler) {
        return Observable.h0(new k$e(this.l, scheduler instanceof j0.l.c.b ? new k$a(this, (j0.l.c.b) scheduler) : new k$b(this, scheduler)));
    }
}
