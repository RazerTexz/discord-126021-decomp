package p637j0.p650m;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.Subscription;

/* JADX INFO: renamed from: j0.m.a */
/* JADX INFO: compiled from: BlockingObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12756a<T> {

    /* JADX INFO: renamed from: a */
    public final Observable<? extends T> f27359a;

    /* JADX INFO: renamed from: j0.m.a$a */
    /* JADX INFO: compiled from: BlockingObservable.java */
    public class a extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ CountDownLatch f27360j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ AtomicReference f27361k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ AtomicReference f27362l;

        public a(C12756a c12756a, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f27360j = countDownLatch;
            this.f27361k = atomicReference;
            this.f27362l = atomicReference2;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f27360j.countDown();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.f27361k.set(th);
            this.f27360j.countDown();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            this.f27362l.set(t);
        }
    }

    public C12756a(Observable<? extends T> observable) {
        this.f27359a = observable;
    }

    /* JADX INFO: renamed from: a */
    public final T m10859a(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Subscription subscriptionM11095U = observable.m11095U(new a(this, countDownLatch, atomicReference2, atomicReference));
        if (countDownLatch.getCount() != 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                subscriptionM11095U.unsubscribe();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        if (atomicReference2.get() == null) {
            return (T) atomicReference.get();
        }
        C3404f.m4253V0((Throwable) atomicReference2.get());
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public T m10860b() {
        return m10859a(this.f27359a.m11092R());
    }
}
