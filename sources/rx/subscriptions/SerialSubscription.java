package rx.subscriptions;

import j0.l.d.a;
import j0.l.d.b;
import rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SerialSubscription implements Subscription {
    public final a j = new a();

    public void a(Subscription subscription) {
        Subscription subscription2;
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        a aVar = this.j;
        do {
            subscription2 = aVar.get();
            if (subscription2 == b.INSTANCE) {
                subscription.unsubscribe();
                return;
            }
        } while (!aVar.compareAndSet(subscription2, subscription));
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.j.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.j.unsubscribe();
    }
}
