package p658rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionList implements Subscription {

    /* JADX INFO: renamed from: j */
    public List<Subscription> f27644j;

    /* JADX INFO: renamed from: k */
    public volatile boolean f27645k;

    public SubscriptionList() {
    }

    /* JADX INFO: renamed from: a */
    public void m11128a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.f27645k) {
            synchronized (this) {
                if (!this.f27645k) {
                    List linkedList = this.f27644j;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f27644j = linkedList;
                    }
                    linkedList.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27645k;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        if (this.f27645k) {
            return;
        }
        synchronized (this) {
            if (this.f27645k) {
                return;
            }
            this.f27645k = true;
            List<Subscription> list = this.f27644j;
            ArrayList arrayList = null;
            this.f27644j = null;
            if (list == null) {
                return;
            }
            Iterator<Subscription> it = list.iterator();
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
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.f27644j = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.f27644j = linkedList;
        linkedList.add(subscription);
    }
}
