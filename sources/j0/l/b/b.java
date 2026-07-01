package j0.l.b;

import b.i.a.f.e.o.f;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: SingleDelayedProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends AtomicInteger implements Producer {
    private static final long serialVersionUID = -2873467947112093874L;
    public final Subscriber<? super T> child;
    public T value;

    public b(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Subscriber<? super T> subscriber, T t) {
        if (subscriber.isUnsubscribed()) {
            return;
        }
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

    public void b(T t) {
        do {
            int i = get();
            if (i != 0) {
                if (i == 2 && compareAndSet(2, 3)) {
                    a(this.child, t);
                    return;
                }
                return;
            }
            this.value = t;
        } while (!compareAndSet(0, 1));
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        do {
            int i = get();
            if (i != 0) {
                if (i == 1 && compareAndSet(1, 3)) {
                    a(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }
}
