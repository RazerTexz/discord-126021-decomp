package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import p637j0.p655r.C12785a;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.z */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12690z implements Action1<Subscription> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f27142j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AtomicBoolean f27143k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12607c0 f27144l;

    public C12690z(C12607c0 c12607c0, Subscriber subscriber, AtomicBoolean atomicBoolean) {
        this.f27144l = c12607c0;
        this.f27142j = subscriber;
        this.f27143k = atomicBoolean;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p658rx.functions.Action1
    public void call(Subscription subscription) {
        try {
            this.f27144l.f26754k.m11136a(subscription);
            C12607c0 c12607c0 = this.f27144l;
            Subscriber subscriber = this.f27142j;
            CompositeSubscription compositeSubscription = c12607c0.f26754k;
            subscriber.add(new C12785a(new C12603b0(c12607c0, compositeSubscription)));
            c12607c0.f26753j.m11107i0(new C12599a0(c12607c0, subscriber, subscriber, compositeSubscription));
        } finally {
            this.f27144l.f26756m.unlock();
            this.f27143k.set(false);
        }
    }
}
