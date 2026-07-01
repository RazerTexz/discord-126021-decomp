package j0.l.d;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

/* JADX INFO: renamed from: j0.l.d.a, reason: use source file name */
/* JADX INFO: compiled from: SequentialSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public boolean a(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                if (subscription == null) {
                    return false;
                }
                subscription.unsubscribe();
                return false;
            }
        } while (!compareAndSet(subscription2, subscription));
        return true;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Subscription andSet;
        Subscription subscription = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (subscription == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == unsubscribed) {
            return;
        }
        andSet.unsubscribe();
    }

    public SequentialSubscription(Subscription subscription) {
        lazySet(subscription);
    }
}
