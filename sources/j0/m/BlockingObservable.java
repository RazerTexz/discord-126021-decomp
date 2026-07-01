package j0.m;

import b.i.a.f.e.o.f;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: renamed from: j0.m.a, reason: use source file name */
/* JADX INFO: compiled from: BlockingObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BlockingObservable<T> {
    public final Observable<? extends T> a;

    /* JADX INFO: renamed from: j0.m.a$a */
    /* JADX INFO: compiled from: BlockingObservable.java */
    public class a extends Subscriber<T> {
        public final /* synthetic */ CountDownLatch j;
        public final /* synthetic */ AtomicReference k;
        public final /* synthetic */ AtomicReference l;

        public a(BlockingObservable blockingObservable, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.j = countDownLatch;
            this.k = atomicReference;
            this.l = atomicReference2;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.j.countDown();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.k.set(th);
            this.j.countDown();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.l.set(t);
        }
    }

    public BlockingObservable(Observable<? extends T> observable) {
        this.a = observable;
    }

    public final T a(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Subscription subscriptionU = observable.U(new a(this, countDownLatch, atomicReference2, atomicReference));
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
