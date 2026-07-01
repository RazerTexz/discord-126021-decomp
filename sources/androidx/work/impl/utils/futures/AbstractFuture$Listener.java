package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$Listener {
    public static final AbstractFuture$Listener TOMBSTONE = new AbstractFuture$Listener(null, null);
    public final Executor executor;

    @Nullable
    public AbstractFuture$Listener next;
    public final Runnable task;

    public AbstractFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}
