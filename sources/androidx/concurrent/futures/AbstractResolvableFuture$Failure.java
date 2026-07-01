package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$Failure {
    public static final AbstractResolvableFuture$Failure FALLBACK_INSTANCE = new AbstractResolvableFuture$Failure(new AbstractResolvableFuture$Failure$1("Failure occurred while trying to finish a future."));
    public final Throwable exception;

    public AbstractResolvableFuture$Failure(Throwable th) {
        this.exception = (Throwable) AbstractResolvableFuture.checkNotNull(th);
    }
}
