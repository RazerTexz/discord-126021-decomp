package j0.l.e;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k$g<T> implements Producer {
    public final Subscriber<? super T> j;
    public final T k;
    public boolean l;

    public k$g(Subscriber<? super T> subscriber, T t) {
        this.j = subscriber;
        this.k = t;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (this.l) {
            return;
        }
        if (j < 0) {
            throw new IllegalStateException(b.d.b.a.a.t("n >= required but it was ", j));
        }
        if (j == 0) {
            return;
        }
        this.l = true;
        Subscriber<? super T> subscriber = this.j;
        if (subscriber.isUnsubscribed()) {
            return;
        }
        T t = this.k;
        try {
            subscriber.onNext(t);
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, subscriber, t);
        }
    }
}
