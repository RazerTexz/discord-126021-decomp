package j0.l.a;

import j0.m.ConnectableObservable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.a0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRefCount<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ CompositeSubscription k;
    public final /* synthetic */ OnSubscribeRefCount3 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeRefCount(OnSubscribeRefCount3 onSubscribeRefCount3, Subscriber subscriber, Subscriber subscriber2, CompositeSubscription compositeSubscription) {
        super(subscriber);
        this.l = onSubscribeRefCount3;
        this.j = subscriber2;
        this.k = compositeSubscription;
    }

    public void a() {
        this.l.m.lock();
        try {
            if (this.l.k == this.k) {
                ConnectableObservable<? extends T> connectableObservable = this.l.j;
                if (connectableObservable instanceof Subscription) {
                    ((Subscription) connectableObservable).unsubscribe();
                }
                this.l.k.unsubscribe();
                this.l.k = new CompositeSubscription();
                this.l.l.set(0);
            }
        } finally {
            this.l.m.unlock();
        }
    }

    @Override // j0.Observer2
    public void onCompleted() {
        a();
        this.j.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        a();
        this.j.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
