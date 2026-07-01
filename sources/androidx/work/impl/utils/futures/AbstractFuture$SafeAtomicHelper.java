package androidx.work.impl.utils.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$SafeAtomicHelper extends AbstractFuture$AtomicHelper {
    public final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture$Listener> listenersUpdater;
    public final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
    public final AtomicReferenceFieldUpdater<AbstractFuture$Waiter, AbstractFuture$Waiter> waiterNextUpdater;
    public final AtomicReferenceFieldUpdater<AbstractFuture$Waiter, Thread> waiterThreadUpdater;
    public final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture$Waiter> waitersUpdater;

    public AbstractFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture$Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture$Waiter, AbstractFuture$Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture$Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture$Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casListeners(AbstractFuture<?> abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        return this.listenersUpdater.compareAndSet(abstractFuture, abstractFuture$Listener, abstractFuture$Listener2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
        return this.valueUpdater.compareAndSet(abstractFuture, obj, obj2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casWaiters(AbstractFuture<?> abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        return this.waitersUpdater.compareAndSet(abstractFuture, abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        this.waiterNextUpdater.lazySet(abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(abstractFuture$Waiter, thread);
    }
}
