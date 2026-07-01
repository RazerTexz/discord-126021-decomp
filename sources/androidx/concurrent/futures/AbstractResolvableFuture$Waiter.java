package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$Waiter {
    public static final AbstractResolvableFuture$Waiter TOMBSTONE = new AbstractResolvableFuture$Waiter(false);

    @Nullable
    public volatile AbstractResolvableFuture$Waiter next;

    @Nullable
    public volatile Thread thread;

    public AbstractResolvableFuture$Waiter(boolean z2) {
    }

    public void setNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter) {
        AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, abstractResolvableFuture$Waiter);
    }

    public void unpark() {
        Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }

    public AbstractResolvableFuture$Waiter() {
        AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
}
