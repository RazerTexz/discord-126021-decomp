package j0.r;

import rx.Subscription;

/* JADX INFO: renamed from: j0.r.c, reason: use source file name */
/* JADX INFO: compiled from: Subscriptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Subscriptions {
    public static final a a = new a();

    /* JADX INFO: renamed from: j0.r.c$a */
    /* JADX INFO: compiled from: Subscriptions.java */
    public static final class a implements Subscription {
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }
}
