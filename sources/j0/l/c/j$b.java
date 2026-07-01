package j0.l.c;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* JADX INFO: compiled from: ScheduledAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = 247232374289553518L;
    public final SubscriptionList parent;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j f3792s;

    public j$b(j jVar, SubscriptionList subscriptionList) {
        this.f3792s = jVar;
        this.parent = subscriptionList;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f3792s.cancel.k;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            SubscriptionList subscriptionList = this.parent;
            j jVar = this.f3792s;
            if (subscriptionList.k) {
                return;
            }
            synchronized (subscriptionList) {
                List<Subscription> list = subscriptionList.j;
                if (!subscriptionList.k && list != null) {
                    boolean zRemove = list.remove(jVar);
                    if (zRemove) {
                        jVar.unsubscribe();
                    }
                }
            }
        }
    }
}
