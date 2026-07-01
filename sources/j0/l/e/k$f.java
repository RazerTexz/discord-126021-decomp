package j0.l.e;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k$f<T> extends AtomicBoolean implements Producer, Action0 {
    private static final long serialVersionUID = -2466317989629281651L;
    public final Subscriber<? super T> actual;
    public final j0.k.b<Action0, Subscription> onSchedule;
    public final T value;

    public k$f(Subscriber<? super T> subscriber, T t, j0.k.b<Action0, Subscription> bVar) {
        this.actual = subscriber;
        this.value = t;
        this.onSchedule = bVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        Subscriber<? super T> subscriber = this.actual;
        if (subscriber.isUnsubscribed()) {
            return;
        }
        T t = this.value;
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

    @Override // rx.Producer
    public void j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
        if (j == 0 || !compareAndSet(false, true)) {
            return;
        }
        this.actual.add(this.onSchedule.call(this));
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ScalarAsyncProducer[");
        sbU.append(this.value);
        sbU.append(", ");
        sbU.append(get());
        sbU.append("]");
        return sbU.toString();
    }
}
