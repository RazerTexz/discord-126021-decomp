package j0.l.a;

import j0.r.BooleanSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.z, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRefCount4 implements Action1<Subscription> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ AtomicBoolean k;
    public final /* synthetic */ OnSubscribeRefCount3 l;

    public OnSubscribeRefCount4(OnSubscribeRefCount3 onSubscribeRefCount3, Subscriber subscriber, AtomicBoolean atomicBoolean) {
        this.l = onSubscribeRefCount3;
        this.j = subscriber;
        this.k = atomicBoolean;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action1
    public void call(Subscription subscription) {
        try {
            this.l.k.a(subscription);
            OnSubscribeRefCount3 onSubscribeRefCount3 = this.l;
            Subscriber subscriber = this.j;
            CompositeSubscription compositeSubscription = onSubscribeRefCount3.k;
            subscriber.add(new BooleanSubscription(new OnSubscribeRefCount2(onSubscribeRefCount3, compositeSubscription)));
            onSubscribeRefCount3.j.i0(new OnSubscribeRefCount(onSubscribeRefCount3, subscriber, subscriber, compositeSubscription));
        } finally {
            this.l.m.unlock();
            this.k.set(false);
        }
    }
}
