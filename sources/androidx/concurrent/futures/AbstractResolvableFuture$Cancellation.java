package androidx.concurrent.futures;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$Cancellation {
    public static final AbstractResolvableFuture$Cancellation CAUSELESS_CANCELLED;
    public static final AbstractResolvableFuture$Cancellation CAUSELESS_INTERRUPTED;

    @Nullable
    public final Throwable cause;
    public final boolean wasInterrupted;

    static {
        if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            CAUSELESS_CANCELLED = new AbstractResolvableFuture$Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new AbstractResolvableFuture$Cancellation(true, null);
        }
    }

    public AbstractResolvableFuture$Cancellation(boolean z2, @Nullable Throwable th) {
        this.wasInterrupted = z2;
        this.cause = th;
    }
}
