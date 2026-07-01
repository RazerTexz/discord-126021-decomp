package j0.m;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: BlockingObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a<T> extends Subscriber<T> {
    public final /* synthetic */ CountDownLatch j;
    public final /* synthetic */ AtomicReference k;
    public final /* synthetic */ AtomicReference l;

    public a$a(a aVar, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.j = countDownLatch;
        this.k = atomicReference;
        this.l = atomicReference2;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.countDown();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.set(th);
        this.j.countDown();
    }

    @Override // j0.g
    public void onNext(T t) {
        this.l.set(t);
    }
}
