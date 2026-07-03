package p637j0.p642l.p644b;

import java.util.concurrent.atomic.AtomicInteger;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.b.b */
/* JADX INFO: compiled from: SingleDelayedProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12694b<T> extends AtomicInteger implements Producer {
    private static final long serialVersionUID = -2873467947112093874L;
    public final Subscriber<? super T> child;
    public T value;

    public C12694b(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static <T> void m10798a(Subscriber<? super T> subscriber, T t) {
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
            C3404f.m4329p1(th, subscriber, t);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10799b(T t) {
        do {
            int i = get();
            if (i != 0) {
                if (i == 2 && compareAndSet(2, 3)) {
                    m10798a(this.child, t);
                    return;
                }
                return;
            }
            this.value = t;
        } while (!compareAndSet(0, 1));
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
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
                    m10798a(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }
}
