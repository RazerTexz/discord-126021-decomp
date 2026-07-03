package p637j0.p642l.p643a;

import p637j0.p650m.AbstractC12757b;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.a0 */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12599a0<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26724j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CompositeSubscription f26725k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12607c0 f26726l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12599a0(C12607c0 c12607c0, Subscriber subscriber, Subscriber subscriber2, CompositeSubscription compositeSubscription) {
        super(subscriber);
        this.f26726l = c12607c0;
        this.f26724j = subscriber2;
        this.f26725k = compositeSubscription;
    }

    /* JADX INFO: renamed from: a */
    public void m10742a() {
        this.f26726l.f26756m.lock();
        try {
            if (this.f26726l.f26754k == this.f26725k) {
                AbstractC12757b<? extends T> abstractC12757b = this.f26726l.f26753j;
                if (abstractC12757b instanceof Subscription) {
                    ((Subscription) abstractC12757b).unsubscribe();
                }
                this.f26726l.f26754k.unsubscribe();
                this.f26726l.f26754k = new CompositeSubscription();
                this.f26726l.f26755l.set(0);
            }
        } finally {
            this.f26726l.f26756m.unlock();
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        m10742a();
        this.f26724j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        m10742a();
        this.f26724j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f26724j.onNext(t);
    }
}
