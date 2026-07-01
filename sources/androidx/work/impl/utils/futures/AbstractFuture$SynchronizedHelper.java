package androidx.work.impl.utils.futures;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$SynchronizedHelper extends AbstractFuture$AtomicHelper {
    public AbstractFuture$SynchronizedHelper() {
        super(null);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casListeners(AbstractFuture<?> abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        synchronized (abstractFuture) {
            if (abstractFuture.listeners != abstractFuture$Listener) {
                return false;
            }
            abstractFuture.listeners = abstractFuture$Listener2;
            return true;
        }
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
        synchronized (abstractFuture) {
            if (abstractFuture.value != obj) {
                return false;
            }
            abstractFuture.value = obj2;
            return true;
        }
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public boolean casWaiters(AbstractFuture<?> abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        synchronized (abstractFuture) {
            if (abstractFuture.waiters != abstractFuture$Waiter) {
                return false;
            }
            abstractFuture.waiters = abstractFuture$Waiter2;
            return true;
        }
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        abstractFuture$Waiter.next = abstractFuture$Waiter2;
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
    public void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        abstractFuture$Waiter.thread = thread;
    }
}
