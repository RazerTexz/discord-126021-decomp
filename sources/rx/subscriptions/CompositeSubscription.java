package rx.subscriptions;

import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeSubscription implements Subscription {
    public Set<Subscription> j;
    public volatile boolean k;

    public static void d(Collection<Subscription> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<Subscription> it = collection.iterator();
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        f.n1(arrayList);
    }

    public void a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.k) {
            synchronized (this) {
                if (!this.k) {
                    if (this.j == null) {
                        this.j = new HashSet(4);
                    }
                    this.j.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    public void b() {
        Set<Subscription> set;
        if (this.k) {
            return;
        }
        synchronized (this) {
            if (!this.k && (set = this.j) != null) {
                this.j = null;
                d(set);
            }
        }
    }

    public void c(Subscription subscription) {
        Set<Subscription> set;
        if (this.k) {
            return;
        }
        synchronized (this) {
            if (!this.k && (set = this.j) != null) {
                boolean zRemove = set.remove(subscription);
                if (zRemove) {
                    subscription.unsubscribe();
                }
            }
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.k;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.k) {
            return;
        }
        synchronized (this) {
            if (this.k) {
                return;
            }
            this.k = true;
            Set<Subscription> set = this.j;
            this.j = null;
            d(set);
        }
    }
}
