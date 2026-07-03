package p658rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeSubscription implements Subscription {

    /* JADX INFO: renamed from: j */
    public Set<Subscription> f27655j;

    /* JADX INFO: renamed from: k */
    public volatile boolean f27656k;

    /* JADX INFO: renamed from: d */
    public static void m11135d(Collection<Subscription> collection) {
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
        C3404f.m4321n1(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public void m11136a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.f27656k) {
            synchronized (this) {
                if (!this.f27656k) {
                    if (this.f27655j == null) {
                        this.f27655j = new HashSet(4);
                    }
                    this.f27655j.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    /* JADX INFO: renamed from: b */
    public void m11137b() {
        Set<Subscription> set;
        if (this.f27656k) {
            return;
        }
        synchronized (this) {
            if (!this.f27656k && (set = this.f27655j) != null) {
                this.f27655j = null;
                m11135d(set);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m11138c(Subscription subscription) {
        Set<Subscription> set;
        if (this.f27656k) {
            return;
        }
        synchronized (this) {
            if (!this.f27656k && (set = this.f27655j) != null) {
                boolean zRemove = set.remove(subscription);
                if (zRemove) {
                    subscription.unsubscribe();
                }
            }
        }
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27656k;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        if (this.f27656k) {
            return;
        }
        synchronized (this) {
            if (this.f27656k) {
                return;
            }
            this.f27656k = true;
            Set<Subscription> set = this.f27655j;
            this.f27655j = null;
            m11135d(set);
        }
    }
}
