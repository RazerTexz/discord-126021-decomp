package j0.l.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c<T, R> extends Subscriber<T> {
    public final Subscriber<? super R> j;
    public final j0.k.b<? super T, ? extends Observable<? extends R>> k;
    public final int l;
    public final Queue<Object> n;
    public final SerialSubscription q;
    public volatile boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f3773s;
    public final j0.l.b.a m = new j0.l.b.a();
    public final AtomicInteger o = new AtomicInteger();
    public final AtomicReference<Throwable> p = new AtomicReference<>();

    public h$c(Subscriber<? super R> subscriber, j0.k.b<? super T, ? extends Observable<? extends R>> bVar, int i, int i2) {
        this.j = subscriber;
        this.k = bVar;
        this.l = i2;
        this.n = j0.l.e.o.y.b() ? new j0.l.e.o.n<>(i) : new j0.l.e.n.c<>(i);
        this.q = new SerialSubscription();
        request(i);
    }

    public void a() {
        if (this.o.getAndIncrement() != 0) {
            return;
        }
        int i = this.l;
        while (!this.j.isUnsubscribed()) {
            if (!this.f3773s) {
                if (i == 1 && this.p.get() != null) {
                    Throwable thH = j0.l.e.d.h(this.p);
                    if (j0.l.e.d.g(thH)) {
                        return;
                    }
                    this.j.onError(thH);
                    return;
                }
                boolean z2 = this.r;
                Object objPoll = this.n.poll();
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    Throwable thH2 = j0.l.e.d.h(this.p);
                    if (thH2 == null) {
                        this.j.onCompleted();
                        return;
                    } else {
                        if (j0.l.e.d.g(thH2)) {
                            return;
                        }
                        this.j.onError(thH2);
                        return;
                    }
                }
                if (!z3) {
                    try {
                        Observable<? extends R> observableCall = this.k.call((Object) e.b(objPoll));
                        if (observableCall == null) {
                            b(new NullPointerException("The source returned by the mapper was null"));
                            return;
                        }
                        if (observableCall != c.k) {
                            if (observableCall instanceof j0.l.e.k) {
                                this.f3773s = true;
                                this.m.c(new h$a(((j0.l.e.k) observableCall).l, this));
                            } else {
                                h$b h_b = new h$b(this);
                                this.q.a(h_b);
                                if (h_b.isUnsubscribed()) {
                                    return;
                                }
                                this.f3773s = true;
                                observableCall.i0(h_b);
                            }
                            request(1L);
                        } else {
                            request(1L);
                        }
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.o1(th);
                        b(th);
                        return;
                    }
                }
            }
            if (this.o.decrementAndGet() == 0) {
                return;
            }
        }
    }

    public void b(Throwable th) {
        unsubscribe();
        if (!j0.l.e.d.f(this.p, th)) {
            j0.o.l.b(th);
            return;
        }
        Throwable thH = j0.l.e.d.h(this.p);
        if (j0.l.e.d.g(thH)) {
            return;
        }
        this.j.onError(thH);
    }

    @Override // j0.g
    public void onCompleted() {
        this.r = true;
        a();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (!j0.l.e.d.f(this.p, th)) {
            j0.o.l.b(th);
            return;
        }
        this.r = true;
        if (this.l != 0) {
            a();
            return;
        }
        Throwable thH = j0.l.e.d.h(this.p);
        if (!j0.l.e.d.g(thH)) {
            this.j.onError(thH);
        }
        this.q.j.unsubscribe();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // j0.g
    public void onNext(T t) {
        Queue<Object> queue = this.n;
        Object obj = t;
        if (t == null) {
            obj = e.f3771b;
        }
        if (queue.offer(obj)) {
            a();
        } else {
            unsubscribe();
            onError(new MissingBackpressureException());
        }
    }
}
