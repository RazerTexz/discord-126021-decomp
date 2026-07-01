package j0.m;

import b.i.a.f.e.o.f;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: BlockingObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {
    public final Observable<? extends T> a;

    public a(Observable<? extends T> observable) {
        this.a = observable;
    }

    public final T a(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Subscription subscriptionU = observable.U(new a$a(this, countDownLatch, atomicReference2, atomicReference));
        if (countDownLatch.getCount() != 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                subscriptionU.unsubscribe();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        if (atomicReference2.get() == null) {
            return (T) atomicReference.get();
        }
        f.V0((Throwable) atomicReference2.get());
        throw null;
    }

    public T b() {
        return a(this.a.R());
    }
}
