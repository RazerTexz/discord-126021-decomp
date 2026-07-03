package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p637j0.p650m.AbstractC12757b;
import p637j0.p655r.C12785a;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.c0 */
/* JADX INFO: compiled from: OnSubscribeRefCount.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12607c0<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final AbstractC12757b<? extends T> f26753j;

    /* JADX INFO: renamed from: k */
    public volatile CompositeSubscription f26754k = new CompositeSubscription();

    /* JADX INFO: renamed from: l */
    public final AtomicInteger f26755l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m */
    public final ReentrantLock f26756m = new ReentrantLock();

    public C12607c0(AbstractC12757b<? extends T> abstractC12757b) {
        this.f26753j = abstractC12757b;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.f26756m.lock();
        if (this.f26755l.incrementAndGet() != 1) {
            try {
                CompositeSubscription compositeSubscription = this.f26754k;
                subscriber.add(new C12785a(new C12603b0(this, compositeSubscription)));
                this.f26753j.m11107i0(new C12599a0(this, subscriber, subscriber, compositeSubscription));
                return;
            } finally {
                this.f26756m.unlock();
            }
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        try {
            this.f26753j.mo10753k0(new C12690z(this, subscriber, atomicBoolean));
        } finally {
            if (atomicBoolean.get()) {
                this.f26756m.unlock();
            }
        }
    }
}
