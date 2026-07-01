package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.b.ProducerArbiter;
import j0.l.d.SequentialSubscription;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.g0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeTimeoutTimedWithFallback<T> implements Observable.a<T> {
    public final Observable<T> j;
    public final long k;
    public final TimeUnit l;
    public final Scheduler m;
    public final Observable<? extends T> n;

    /* JADX INFO: renamed from: j0.l.a.g0$a */
    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    public static final class a<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final ProducerArbiter k;

        public a(Subscriber<? super T> subscriber, ProducerArbiter producerArbiter) {
            this.j = subscriber;
            this.k = producerArbiter;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.j.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.j.onNext(t);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.k.c(producer);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.g0$b */
    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    public static final class b<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final long k;
        public final TimeUnit l;
        public final Scheduler.Worker m;
        public final Observable<? extends T> n;
        public final ProducerArbiter o = new ProducerArbiter();
        public final AtomicLong p = new AtomicLong();
        public final SequentialSubscription q;
        public final SequentialSubscription r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f3772s;

        /* JADX INFO: renamed from: j0.l.a.g0$b$a */
        /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
        public final class a implements Action0 {
            public final long j;

            public a(long j) {
                this.j = j;
            }

            @Override // rx.functions.Action0
            public void call() {
                b bVar = b.this;
                if (bVar.p.compareAndSet(this.j, RecyclerView.FOREVER_NS)) {
                    bVar.unsubscribe();
                    if (bVar.n == null) {
                        bVar.j.onError(new TimeoutException());
                        return;
                    }
                    long j = bVar.f3772s;
                    if (j != 0) {
                        bVar.o.b(j);
                    }
                    a aVar = new a(bVar.j, bVar.o);
                    if (bVar.r.a(aVar)) {
                        bVar.n.U(aVar);
                    }
                }
            }
        }

        public b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, Observable<? extends T> observable) {
            this.j = subscriber;
            this.k = j;
            this.l = timeUnit;
            this.m = worker;
            this.n = observable;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.q = sequentialSubscription;
            this.r = new SequentialSubscription(this);
            add(worker);
            add(sequentialSubscription);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.p.getAndSet(RecyclerView.FOREVER_NS) != RecyclerView.FOREVER_NS) {
                this.q.unsubscribe();
                this.j.onCompleted();
                this.m.unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.p.getAndSet(RecyclerView.FOREVER_NS) == RecyclerView.FOREVER_NS) {
                j0.o.l.b(th);
                return;
            }
            this.q.unsubscribe();
            this.j.onError(th);
            this.m.unsubscribe();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            long j = this.p.get();
            if (j != RecyclerView.FOREVER_NS) {
                long j2 = j + 1;
                if (this.p.compareAndSet(j, j2)) {
                    Subscription subscription = this.q.get();
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.f3772s++;
                    this.j.onNext(t);
                    this.q.a(this.m.b(new a(j2), this.k, this.l));
                }
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.o.c(producer);
        }
    }

    public OnSubscribeTimeoutTimedWithFallback(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, Observable<? extends T> observable2) {
        this.j = observable;
        this.k = j;
        this.l = timeUnit;
        this.m = scheduler;
        this.n = observable2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, this.k, this.l, this.m.a(), this.n);
        subscriber.add(bVar.r);
        subscriber.setProducer(bVar.o);
        bVar.q.a(bVar.m.b(new b.a(0L), bVar.k, bVar.l));
        this.j.U(bVar);
    }
}
