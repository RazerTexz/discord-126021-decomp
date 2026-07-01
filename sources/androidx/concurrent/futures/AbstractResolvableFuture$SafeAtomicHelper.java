package androidx.concurrent.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$SafeAtomicHelper extends AbstractResolvableFuture$AtomicHelper {
    public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture$Listener> listenersUpdater;
    public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
    public final AtomicReferenceFieldUpdater<AbstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter> waiterNextUpdater;
    public final AtomicReferenceFieldUpdater<AbstractResolvableFuture$Waiter, Thread> waiterThreadUpdater;
    public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture$Waiter> waitersUpdater;

    public AbstractResolvableFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractResolvableFuture$Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture$Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, AbstractResolvableFuture$Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2) {
        return this.listenersUpdater.compareAndSet(abstractResolvableFuture, abstractResolvableFuture$Listener, abstractResolvableFuture$Listener2);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
        return this.valueUpdater.compareAndSet(abstractResolvableFuture, obj, obj2);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        return this.waitersUpdater.compareAndSet(abstractResolvableFuture, abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        this.waiterNextUpdater.lazySet(abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(abstractResolvableFuture$Waiter, thread);
    }
}
