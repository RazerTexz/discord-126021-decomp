package rx.subjects;

import b.i.a.f.e.o.f;
import j0.g;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes3.dex */
public final class PublishSubject$a<T> extends AtomicLong implements Producer, Subscription, g<T> {
    private static final long serialVersionUID = 6451806817170721536L;
    public final Subscriber<? super T> actual;
    public final PublishSubject$b<T> parent;
    public long produced;

    public PublishSubject$a(PublishSubject$b<T> publishSubject$b, Subscriber<? super T> subscriber) {
        this.parent = publishSubject$b;
        this.actual = subscriber;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get() == Long.MIN_VALUE;
    }

    @Override // rx.Producer
    public void j(long j) {
        long j2;
        if (f.A1(j)) {
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
            } while (!compareAndSet(j2, f.f(j2, j)));
        }
    }

    @Override // j0.g
    public void onCompleted() {
        if (get() != Long.MIN_VALUE) {
            this.actual.onCompleted();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (get() != Long.MIN_VALUE) {
            this.actual.onError(th);
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        long j = get();
        if (j != Long.MIN_VALUE) {
            long j2 = this.produced;
            if (j != j2) {
                this.produced = j2 + 1;
                this.actual.onNext(t);
            } else {
                unsubscribe();
                this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.a(this);
        }
    }
}
