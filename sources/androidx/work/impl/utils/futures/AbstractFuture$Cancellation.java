package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$Cancellation {
    public static final AbstractFuture$Cancellation CAUSELESS_CANCELLED;
    public static final AbstractFuture$Cancellation CAUSELESS_INTERRUPTED;

    @Nullable
    public final Throwable cause;
    public final boolean wasInterrupted;

    static {
        if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            CAUSELESS_CANCELLED = new AbstractFuture$Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new AbstractFuture$Cancellation(true, null);
        }
    }

    public AbstractFuture$Cancellation(boolean z2, @Nullable Throwable th) {
        this.wasInterrupted = z2;
        this.cause = th;
    }
}
