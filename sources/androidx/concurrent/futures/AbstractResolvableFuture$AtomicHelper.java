package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResolvableFuture$AtomicHelper {
    private AbstractResolvableFuture$AtomicHelper() {
    }

    public abstract boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2);

    public abstract boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2);

    public abstract void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2);

    public abstract void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread);

    public /* synthetic */ AbstractResolvableFuture$AtomicHelper(AbstractResolvableFuture$1 abstractResolvableFuture$1) {
        this();
    }
}
