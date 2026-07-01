package androidx.work.impl.utils.futures;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$Failure {
    public static final AbstractFuture$Failure FALLBACK_INSTANCE = new AbstractFuture$Failure(new AbstractFuture$Failure$1("Failure occurred while trying to finish a future."));
    public final Throwable exception;

    public AbstractFuture$Failure(Throwable th) {
        this.exception = (Throwable) AbstractFuture.checkNotNull(th);
    }
}
