package j0.l.d;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

/* JADX INFO: compiled from: SequentialSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public a() {
    }

    public boolean a(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get();
            if (subscription2 == b.INSTANCE) {
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
        return get() == b.INSTANCE;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Subscription andSet;
        Subscription subscription = get();
        b bVar = b.INSTANCE;
        if (subscription == bVar || (andSet = getAndSet(bVar)) == null || andSet == bVar) {
            return;
        }
        andSet.unsubscribe();
    }

    public a(Subscription subscription) {
        lazySet(subscription);
    }
}
