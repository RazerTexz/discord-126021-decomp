package p637j0.p642l.p646d;

import java.util.concurrent.atomic.AtomicReference;
import p658rx.Subscription;

/* JADX INFO: renamed from: j0.l.d.a */
/* JADX INFO: compiled from: SequentialSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12709a extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public C12709a() {
    }

    /* JADX INFO: renamed from: a */
    public boolean m10809a(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get();
            if (subscription2 == EnumC12710b.INSTANCE) {
                if (subscription == null) {
                    return false;
                }
                subscription.unsubscribe();
                return false;
            }
        } while (!compareAndSet(subscription2, subscription));
        return true;
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return get() == EnumC12710b.INSTANCE;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        Subscription andSet;
        Subscription subscription = get();
        EnumC12710b enumC12710b = EnumC12710b.INSTANCE;
        if (subscription == enumC12710b || (andSet = getAndSet(enumC12710b)) == null || andSet == enumC12710b) {
            return;
        }
        andSet.unsubscribe();
    }

    public C12709a(Subscription subscription) {
        lazySet(subscription);
    }
}
