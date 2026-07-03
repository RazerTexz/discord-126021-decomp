package p637j0.p642l.p643a;

import p637j0.p652o.C12774l;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.b */
/* JADX INFO: compiled from: DeferredScalarSubscriberSafe.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12602b<T, R> extends AbstractC12598a<T, R> {

    /* JADX INFO: renamed from: n */
    public boolean f26737n;

    public AbstractC12602b(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f26737n) {
            return;
        }
        this.f26737n = true;
        if (!this.f26720k) {
            this.f26719j.onCompleted();
            return;
        }
        R r = this.f26721l;
        Subscriber<? super R> subscriber = this.f26719j;
        do {
            int i = this.f26722m.get();
            if (i == 2 || i == 3 || subscriber.isUnsubscribed()) {
                return;
            }
            if (i == 1) {
                subscriber.onNext(r);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
                this.f26722m.lazySet(3);
                return;
            }
            this.f26721l = r;
        } while (!this.f26722m.compareAndSet(0, 2));
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        if (this.f26737n) {
            C12774l.m10863b(th);
            return;
        }
        this.f26737n = true;
        this.f26721l = null;
        this.f26719j.onError(th);
    }
}
