package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$SynchronizedHelper extends AbstractResolvableFuture$AtomicHelper {
    public AbstractResolvableFuture$SynchronizedHelper() {
        super(null);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.listeners != abstractResolvableFuture$Listener) {
                return false;
            }
            abstractResolvableFuture.listeners = abstractResolvableFuture$Listener2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.value != obj) {
                return false;
            }
            abstractResolvableFuture.value = obj2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.waiters != abstractResolvableFuture$Waiter) {
                return false;
            }
            abstractResolvableFuture.waiters = abstractResolvableFuture$Waiter2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        abstractResolvableFuture$Waiter.next = abstractResolvableFuture$Waiter2;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    public void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread) {
        abstractResolvableFuture$Waiter.thread = thread;
    }
}
