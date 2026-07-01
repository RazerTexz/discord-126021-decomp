package rx.internal.util;

import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionList implements Subscription {
    public List<Subscription> j;
    public volatile boolean k;

    public SubscriptionList() {
    }

    public void a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.k) {
            synchronized (this) {
                if (!this.k) {
                    List linkedList = this.j;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.j = linkedList;
                    }
                    linkedList.add(subscription);
                    return;
                }
            }
        }
        subscription.unsubscribe();
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
            List<Subscription> list = this.j;
            ArrayList arrayList = null;
            this.j = null;
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
            f.n1(arrayList);
        }
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.j = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.j = linkedList;
        linkedList.add(subscription);
    }
}
