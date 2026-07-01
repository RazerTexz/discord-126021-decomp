package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$Waiter {
    public static final AbstractFuture$Waiter TOMBSTONE = new AbstractFuture$Waiter(false);

    @Nullable
    public volatile AbstractFuture$Waiter next;

    @Nullable
    public volatile Thread thread;

    public AbstractFuture$Waiter(boolean z2) {
    }

    public void setNext(AbstractFuture$Waiter abstractFuture$Waiter) {
        AbstractFuture.ATOMIC_HELPER.putNext(this, abstractFuture$Waiter);
    }

    public void unpark() {
        Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }

    public AbstractFuture$Waiter() {
        AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
}
