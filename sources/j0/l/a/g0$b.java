package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$b<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public final long k;
    public final TimeUnit l;
    public final Scheduler$Worker m;
    public final Observable<? extends T> n;
    public final j0.l.b.a o = new j0.l.b.a();
    public final AtomicLong p = new AtomicLong();
    public final j0.l.d.a q;
    public final j0.l.d.a r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f3772s;

    public g0$b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler$Worker scheduler$Worker, Observable<? extends T> observable) {
        this.j = subscriber;
        this.k = j;
        this.l = timeUnit;
        this.m = scheduler$Worker;
        this.n = observable;
        j0.l.d.a aVar = new j0.l.d.a();
        this.q = aVar;
        this.r = new j0.l.d.a(this);
        add(scheduler$Worker);
        add(aVar);
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.p.getAndSet(RecyclerView.FOREVER_NS) != RecyclerView.FOREVER_NS) {
            this.q.unsubscribe();
            this.j.onCompleted();
            this.m.unsubscribe();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.p.getAndSet(RecyclerView.FOREVER_NS) == RecyclerView.FOREVER_NS) {
            j0.o.l.b(th);
            return;
        }
        this.q.unsubscribe();
        this.j.onError(th);
        this.m.unsubscribe();
    }

    @Override // j0.g
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
                this.q.a(this.m.b(new g0$b$a(this, j2), this.k, this.l));
            }
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.o.c(producer);
    }
}
