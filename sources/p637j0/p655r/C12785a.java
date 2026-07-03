package p637j0.p655r;

import java.util.concurrent.atomic.AtomicReference;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.r.a */
/* JADX INFO: compiled from: BooleanSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12785a implements Subscription {

    /* JADX INFO: renamed from: j */
    public static final Action0 f27419j = new a();

    /* JADX INFO: renamed from: k */
    public final AtomicReference<Action0> f27420k;

    /* JADX INFO: renamed from: j0.r.a$a */
    /* JADX INFO: compiled from: BooleanSubscription.java */
    public static class a implements Action0 {
        @Override // p658rx.functions.Action0
        public void call() {
        }
    }

    public C12785a() {
        this.f27420k = new AtomicReference<>();
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27420k.get() == f27419j;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        Action0 andSet;
        Action0 action0 = this.f27420k.get();
        Action0 action1 = f27419j;
        if (action0 == action1 || (andSet = this.f27420k.getAndSet(action1)) == null || andSet == action1) {
            return;
        }
        andSet.call();
    }

    public C12785a(Action0 action0) {
        this.f27420k = new AtomicReference<>(action0);
    }
}
