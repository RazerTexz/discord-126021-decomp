package j0.l.d;

import rx.Subscription;

/* JADX INFO: compiled from: Unsubscribed.java */
/* JADX INFO: loaded from: classes3.dex */
public enum b implements Subscription {
    INSTANCE;

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
    }
}
