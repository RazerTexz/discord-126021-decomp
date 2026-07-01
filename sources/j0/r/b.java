package j0.r;

import rx.Subscription;

/* JADX INFO: compiled from: MultipleAssignmentSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Subscription {
    public final j0.l.d.a j = new j0.l.d.a();

    public void a(Subscription subscription) {
        this.j.a(subscription);
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
