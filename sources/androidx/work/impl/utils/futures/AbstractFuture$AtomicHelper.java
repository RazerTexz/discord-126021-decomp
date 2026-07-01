package androidx.work.impl.utils.futures;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFuture$AtomicHelper {
    private AbstractFuture$AtomicHelper() {
    }

    public abstract boolean casListeners(AbstractFuture<?> abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2);

    public abstract boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractFuture<?> abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2);

    public abstract void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2);

    public abstract void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread);

    public /* synthetic */ AbstractFuture$AtomicHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }
}
