package j0.l.b;

import b.i.a.f.e.o.f;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.b.c, reason: use source file name */
/* JADX INFO: compiled from: SingleProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    public final Subscriber<? super T> child;
    public final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.child = subscriber;
        this.value = t;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> subscriber = this.child;
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
                f.p1(th, subscriber, t);
            }
        }
    }
}
