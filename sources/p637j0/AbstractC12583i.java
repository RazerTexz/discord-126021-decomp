package p637j0;

import p658rx.Subscription;
import p658rx.internal.util.SubscriptionList;

/* JADX INFO: renamed from: j0.i */
/* JADX INFO: compiled from: SingleSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12583i<T> implements Subscription {

    /* JADX INFO: renamed from: j */
    public final SubscriptionList f26697j = new SubscriptionList();

    /* JADX INFO: renamed from: a */
    public abstract void m10735a(Throwable th);

    /* JADX INFO: renamed from: b */
    public abstract void m10736b(T t);

    @Override // p658rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f26697j.f27645k;
    }

    @Override // p658rx.Subscription
    public final void unsubscribe() {
        this.f26697j.unsubscribe();
    }
}
