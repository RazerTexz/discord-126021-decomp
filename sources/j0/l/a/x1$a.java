package j0.l.a;

import rx.Observable;
import rx.Producer;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x1$a<T> extends Subscriber<T> implements Action0 {
    public final Subscriber<? super T> j;
    public final boolean k;
    public final Scheduler$Worker l;
    public Observable<T> m;
    public Thread n;

    public x1$a(Subscriber<? super T> subscriber, boolean z2, Scheduler$Worker scheduler$Worker, Observable<T> observable) {
        this.j = subscriber;
        this.k = z2;
        this.l = scheduler$Worker;
        this.m = observable;
    }

    @Override // rx.functions.Action0
    public void call() {
        Observable<T> observable = this.m;
        this.m = null;
        this.n = Thread.currentThread();
        observable.i0(this);
    }

    @Override // j0.g
    public void onCompleted() {
        try {
            this.j.onCompleted();
        } finally {
            this.l.unsubscribe();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        try {
            this.j.onError(th);
        } finally {
            this.l.unsubscribe();
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.j.setProducer(new x1$a$a(this, producer));
    }
}
