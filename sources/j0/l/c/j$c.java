package j0.l.c;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: ScheduledAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = 247232374289553518L;
    public final CompositeSubscription parent;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j f3793s;

    public j$c(j jVar, CompositeSubscription compositeSubscription) {
        this.f3793s = jVar;
        this.parent = compositeSubscription;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f3793s.cancel.k;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.parent.c(this.f3793s);
        }
    }
}
