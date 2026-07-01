package j0.l.a;

import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 implements Action0 {
    public final /* synthetic */ CompositeSubscription j;
    public final /* synthetic */ c0 k;

    public b0(c0 c0Var, CompositeSubscription compositeSubscription) {
        this.k = c0Var;
        this.j = compositeSubscription;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.m.lock();
        try {
            if (this.k.k == this.j && this.k.l.decrementAndGet() == 0) {
                Object obj = this.k.j;
                if (obj instanceof Subscription) {
                    ((Subscription) obj).unsubscribe();
                }
                this.k.k.unsubscribe();
                this.k.k = new CompositeSubscription();
            }
        } finally {
            this.k.m.unlock();
        }
    }
}
