package j0.l.a;

import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.b, reason: use source file name */
/* JADX INFO: compiled from: DeferredScalarSubscriberSafe.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {
    public boolean n;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.n) {
            return;
        }
        this.n = true;
        if (!this.k) {
            this.j.onCompleted();
            return;
        }
        R r = this.l;
        Subscriber<? super R> subscriber = this.j;
        do {
            int i = this.m.get();
            if (i == 2 || i == 3 || subscriber.isUnsubscribed()) {
                return;
            }
            if (i == 1) {
                subscriber.onNext(r);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
                this.m.lazySet(3);
                return;
            }
            this.l = r;
        } while (!this.m.compareAndSet(0, 2));
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        if (this.n) {
            j0.o.l.b(th);
            return;
        }
        this.n = true;
        this.l = null;
        this.j.onError(th);
    }
}
