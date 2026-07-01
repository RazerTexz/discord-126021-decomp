package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$Listener {
    public static final AbstractResolvableFuture$Listener TOMBSTONE = new AbstractResolvableFuture$Listener(null, null);
    public final Executor executor;

    @Nullable
    public AbstractResolvableFuture$Listener next;
    public final Runnable task;

    public AbstractResolvableFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}
