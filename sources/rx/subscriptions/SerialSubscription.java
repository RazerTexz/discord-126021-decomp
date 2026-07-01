package rx.subscriptions;

import j0.l.d.SequentialSubscription;
import j0.l.d.Unsubscribed;
import rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SerialSubscription implements Subscription {
    public final SequentialSubscription j = new SequentialSubscription();

    public void a(Subscription subscription) {
        Subscription subscription2;
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        SequentialSubscription sequentialSubscription = this.j;
        do {
            subscription2 = sequentialSubscription.get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                subscription.unsubscribe();
                return;
            }
        } while (!sequentialSubscription.compareAndSet(subscription2, subscription));
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
