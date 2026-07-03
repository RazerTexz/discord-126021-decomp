package p637j0.p642l.p643a;

import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.b0 */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12603b0 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CompositeSubscription f26738j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C12607c0 f26739k;

    public C12603b0(C12607c0 c12607c0, CompositeSubscription compositeSubscription) {
        this.f26739k = c12607c0;
        this.f26738j = compositeSubscription;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        this.f26739k.f26756m.lock();
        try {
            if (this.f26739k.f26754k == this.f26738j && this.f26739k.f26755l.decrementAndGet() == 0) {
                Object obj = this.f26739k.f26753j;
                if (obj instanceof Subscription) {
                    ((Subscription) obj).unsubscribe();
                }
                this.f26739k.f26754k.unsubscribe();
                this.f26739k.f26754k = new CompositeSubscription();
            }
        } finally {
            this.f26739k.f26756m.unlock();
        }
    }
}
