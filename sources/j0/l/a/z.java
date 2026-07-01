package j0.l.a;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class z implements Action1<Subscription> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ AtomicBoolean k;
    public final /* synthetic */ c0 l;

    public z(c0 c0Var, Subscriber subscriber, AtomicBoolean atomicBoolean) {
        this.l = c0Var;
        this.j = subscriber;
        this.k = atomicBoolean;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action1
    public void call(Subscription subscription) {
        try {
            this.l.k.a(subscription);
            c0 c0Var = this.l;
            Subscriber subscriber = this.j;
            CompositeSubscription compositeSubscription = c0Var.k;
            subscriber.add(new j0.r.a(new b0(c0Var, compositeSubscription)));
            c0Var.j.i0(new a0(c0Var, subscriber, subscriber, compositeSubscription));
        } finally {
            this.l.m.unlock();
            this.k.set(false);
        }
    }
}
