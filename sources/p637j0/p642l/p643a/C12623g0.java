package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.p642l.p644b.C12693a;
import p637j0.p642l.p646d.C12709a;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.g0 */
/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12623g0<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26791j;

    /* JADX INFO: renamed from: k */
    public final long f26792k;

    /* JADX INFO: renamed from: l */
    public final TimeUnit f26793l;

    /* JADX INFO: renamed from: m */
    public final Scheduler f26794m;

    /* JADX INFO: renamed from: n */
    public final Observable<? extends T> f26795n;

    /* JADX INFO: renamed from: j0.l.a.g0$a */
    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    public static final class a<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f26796j;

        /* JADX INFO: renamed from: k */
        public final C12693a f26797k;

        public a(Subscriber<? super T> subscriber, C12693a c12693a) {
            this.f26796j = subscriber;
            this.f26797k = c12693a;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f26796j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.f26796j.onError(th);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            this.f26796j.onNext(t);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f26797k.m10797c(producer);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.g0$b */
    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    public static final class b<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f26798j;

        /* JADX INFO: renamed from: k */
        public final long f26799k;

        /* JADX INFO: renamed from: l */
        public final TimeUnit f26800l;

        /* JADX INFO: renamed from: m */
        public final Scheduler.Worker f26801m;

        /* JADX INFO: renamed from: n */
        public final Observable<? extends T> f26802n;

        /* JADX INFO: renamed from: o */
        public final C12693a f26803o = new C12693a();

        /* JADX INFO: renamed from: p */
        public final AtomicLong f26804p = new AtomicLong();

        /* JADX INFO: renamed from: q */
        public final C12709a f26805q;

        /* JADX INFO: renamed from: r */
        public final C12709a f26806r;

        /* JADX INFO: renamed from: s */
        public long f26807s;

        /* JADX INFO: renamed from: j0.l.a.g0$b$a */
        /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
        public final class a implements Action0 {

            /* JADX INFO: renamed from: j */
            public final long f26808j;

            public a(long j) {
                this.f26808j = j;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                b bVar = b.this;
                if (bVar.f26804p.compareAndSet(this.f26808j, RecyclerView.FOREVER_NS)) {
                    bVar.unsubscribe();
                    if (bVar.f26802n == null) {
                        bVar.f26798j.onError(new TimeoutException());
                        return;
                    }
                    long j = bVar.f26807s;
                    if (j != 0) {
                        bVar.f26803o.m10796b(j);
                    }
                    a aVar = new a(bVar.f26798j, bVar.f26803o);
                    if (bVar.f26806r.m10809a(aVar)) {
                        bVar.f26802n.m11095U(aVar);
                    }
                }
            }
        }

        public b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, Observable<? extends T> observable) {
            this.f26798j = subscriber;
            this.f26799k = j;
            this.f26800l = timeUnit;
            this.f26801m = worker;
            this.f26802n = observable;
            C12709a c12709a = new C12709a();
            this.f26805q = c12709a;
            this.f26806r = new C12709a(this);
            add(worker);
            add(c12709a);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f26804p.getAndSet(RecyclerView.FOREVER_NS) != RecyclerView.FOREVER_NS) {
                this.f26805q.unsubscribe();
                this.f26798j.onCompleted();
                this.f26801m.unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f26804p.getAndSet(RecyclerView.FOREVER_NS) == RecyclerView.FOREVER_NS) {
                C12774l.m10863b(th);
                return;
            }
            this.f26805q.unsubscribe();
            this.f26798j.onError(th);
            this.f26801m.unsubscribe();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            long j = this.f26804p.get();
            if (j != RecyclerView.FOREVER_NS) {
                long j2 = j + 1;
                if (this.f26804p.compareAndSet(j, j2)) {
                    Subscription subscription = this.f26805q.get();
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.f26807s++;
                    this.f26798j.onNext(t);
                    this.f26805q.m10809a(this.f26801m.mo10741b(new a(j2), this.f26799k, this.f26800l));
                }
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f26803o.m10797c(producer);
        }
    }

    public C12623g0(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, Observable<? extends T> observable2) {
        this.f26791j = observable;
        this.f26792k = j;
        this.f26793l = timeUnit;
        this.f26794m = scheduler;
        this.f26795n = observable2;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, this.f26792k, this.f26793l, this.f26794m.mo10739a(), this.f26795n);
        subscriber.add(bVar.f26806r);
        subscriber.setProducer(bVar.f26803o);
        bVar.f26805q.m10809a(bVar.f26801m.mo10741b(new b.a(0L), bVar.f26799k, bVar.f26800l));
        this.f26791j.m11095U(bVar);
    }
}
