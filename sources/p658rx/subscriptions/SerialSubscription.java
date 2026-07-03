package p658rx.subscriptions;

import p637j0.p642l.p646d.C12709a;
import p637j0.p642l.p646d.EnumC12710b;
import p658rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SerialSubscription implements Subscription {

    /* JADX INFO: renamed from: j */
    public final C12709a f27657j = new C12709a();

    /* JADX INFO: renamed from: a */
    public void m11139a(Subscription subscription) {
        Subscription subscription2;
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        C12709a c12709a = this.f27657j;
        do {
            subscription2 = c12709a.get();
            if (subscription2 == EnumC12710b.INSTANCE) {
                subscription.unsubscribe();
                return;
            }
        } while (!c12709a.compareAndSet(subscription2, subscription));
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27657j.isUnsubscribed();
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f27657j.unsubscribe();
    }
}
