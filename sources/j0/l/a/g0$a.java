package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$a<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public final j0.l.b.a k;

    public g0$a(Subscriber<? super T> subscriber, j0.l.b.a aVar) {
        this.j = subscriber;
        this.k = aVar;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.k.c(producer);
    }
}
