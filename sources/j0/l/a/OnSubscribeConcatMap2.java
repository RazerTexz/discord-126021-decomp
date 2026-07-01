package j0.l.a;

import j0.k.Func1;
import j0.l.b.ProducerArbiter;
import j0.l.e.ExceptionsUtils;
import j0.l.e.ScalarSynchronousObservable;
import j0.l.e.n.SpscAtomicArrayQueue;
import j0.l.e.o.SpscArrayQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.h, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeConcatMap2<T, R> implements Observable.a<R> {
    public final Observable<? extends T> j;
    public final Func1<? super T, ? extends Observable<? extends R>> k;

    /* JADX INFO: renamed from: j0.l.a.h$a */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class a<T, R> implements Producer {
        public final R j;
        public final c<T, R> k;
        public boolean l;

        public a(R r, c<T, R> cVar) {
            this.j = r;
            this.k = cVar;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (this.l || j <= 0) {
                return;
            }
            this.l = true;
            c<T, R> cVar = this.k;
            cVar.j.onNext(this.j);
            cVar.m.b(1L);
            cVar.f3773s = false;
            cVar.a();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h$b */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class b<T, R> extends Subscriber<R> {
        public final c<T, R> j;
        public long k;

        public b(c<T, R> cVar) {
            this.j = cVar;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            c<T, R> cVar = this.j;
            long j = this.k;
            if (j != 0) {
                cVar.m.b(j);
            }
            cVar.f3773s = false;
            cVar.a();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            c<T, R> cVar = this.j;
            long j = this.k;
            if (!ExceptionsUtils.f(cVar.p, th)) {
                j0.o.l.b(th);
                return;
            }
            if (cVar.l == 0) {
                Throwable thH = ExceptionsUtils.h(cVar.p);
                if (!ExceptionsUtils.g(thH)) {
                    cVar.j.onError(thH);
                }
                cVar.unsubscribe();
                return;
            }
            if (j != 0) {
                cVar.m.b(j);
            }
            cVar.f3773s = false;
            cVar.a();
        }

        @Override // j0.Observer2
        public void onNext(R r) {
            this.k++;
            this.j.j.onNext(r);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.j.m.c(producer);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h$c */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class c<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> j;
        public final Func1<? super T, ? extends Observable<? extends R>> k;
        public final int l;
        public final Queue<Object> n;
        public final SerialSubscription q;
        public volatile boolean r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public volatile boolean f3773s;
        public final ProducerArbiter m = new ProducerArbiter();
        public final AtomicInteger o = new AtomicInteger();
        public final AtomicReference<Throwable> p = new AtomicReference<>();

        public c(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
            this.j = subscriber;
            this.k = func1;
            this.l = i2;
            this.n = UnsafeAccess.b() ? new SpscArrayQueue<>(i) : new SpscAtomicArrayQueue<>(i);
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
                        Throwable thH = ExceptionsUtils.h(this.p);
                        if (ExceptionsUtils.g(thH)) {
                            return;
                        }
                        this.j.onError(thH);
                        return;
                    }
                    boolean z2 = this.r;
                    Object objPoll = this.n.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable thH2 = ExceptionsUtils.h(this.p);
                        if (thH2 == null) {
                            this.j.onCompleted();
                            return;
                        } else {
                            if (ExceptionsUtils.g(thH2)) {
                                return;
                            }
                            this.j.onError(thH2);
                            return;
                        }
                    }
                    if (!z3) {
                        try {
                            Observable<? extends R> observableCall = this.k.call((Object) NotificationLite.b(objPoll));
                            if (observableCall == null) {
                                b(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (observableCall != EmptyObservableHolder.k) {
                                if (observableCall instanceof ScalarSynchronousObservable) {
                                    this.f3773s = true;
                                    this.m.c(new a(((ScalarSynchronousObservable) observableCall).l, this));
                                } else {
                                    b bVar = new b(this);
                                    this.q.a(bVar);
                                    if (bVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f3773s = true;
                                    observableCall.i0(bVar);
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
            if (!ExceptionsUtils.f(this.p, th)) {
                j0.o.l.b(th);
                return;
            }
            Throwable thH = ExceptionsUtils.h(this.p);
            if (ExceptionsUtils.g(thH)) {
                return;
            }
            this.j.onError(thH);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.r = true;
            a();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (!ExceptionsUtils.f(this.p, th)) {
                j0.o.l.b(th);
                return;
            }
            this.r = true;
            if (this.l != 0) {
                a();
                return;
            }
            Throwable thH = ExceptionsUtils.h(this.p);
            if (!ExceptionsUtils.g(thH)) {
                this.j.onError(thH);
            }
            this.q.j.unsubscribe();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.n;
            Object obj = t;
            if (t == null) {
                obj = NotificationLite.f3771b;
            }
            if (queue.offer(obj)) {
                a();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    public OnSubscribeConcatMap2(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.j = observable;
        this.k = func1;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(new SerializedSubscriber(subscriber), this.k, 2, 0);
        subscriber.add(cVar);
        subscriber.add(cVar.q);
        subscriber.setProducer(new OnSubscribeConcatMap(this, cVar));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.j.i0(cVar);
    }
}
