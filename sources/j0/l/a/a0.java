package j0.l.a;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ CompositeSubscription k;
    public final /* synthetic */ c0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(c0 c0Var, Subscriber subscriber, Subscriber subscriber2, CompositeSubscription compositeSubscription) {
        super(subscriber);
        this.l = c0Var;
        this.j = subscriber2;
        this.k = compositeSubscription;
    }

    public void a() {
        this.l.m.lock();
        try {
            if (this.l.k == this.k) {
                j0.m.b<? extends T> bVar = this.l.j;
                if (bVar instanceof Subscription) {
                    ((Subscription) bVar).unsubscribe();
                }
                this.l.k.unsubscribe();
                this.l.k = new CompositeSubscription();
                this.l.l.set(0);
            }
        } finally {
            this.l.m.unlock();
        }
    }

    @Override // j0.g
    public void onCompleted() {
        a();
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        a();
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
