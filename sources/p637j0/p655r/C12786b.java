package p637j0.p655r;

import p637j0.p642l.p646d.C12709a;
import p658rx.Subscription;

/* JADX INFO: renamed from: j0.r.b */
/* JADX INFO: compiled from: MultipleAssignmentSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12786b implements Subscription {

    /* JADX INFO: renamed from: j */
    public final C12709a f27421j = new C12709a();

    /* JADX INFO: renamed from: a */
    public void m10881a(Subscription subscription) {
        this.f27421j.m10809a(subscription);
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27421j.isUnsubscribed();
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f27421j.unsubscribe();
    }
}
