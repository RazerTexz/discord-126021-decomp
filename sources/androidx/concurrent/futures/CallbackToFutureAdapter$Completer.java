package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter$Completer<T> {
    private boolean attemptedSetting;
    private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
    public CallbackToFutureAdapter$SafeFuture<T> future;
    public Object tag;

    private void setCompletedNormally() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture = null;
    }

    public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(runnable, executor);
        }
    }

    public void finalize() {
        ResolvableFuture<Void> resolvableFuture;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null && !callbackToFutureAdapter$SafeFuture.isDone()) {
            StringBuilder sbU = a.U("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            sbU.append(this.tag);
            callbackToFutureAdapter$SafeFuture.setException(new CallbackToFutureAdapter$FutureGarbageCollectedException(sbU.toString()));
        }
        if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
            return;
        }
        resolvableFuture.set(null);
    }

    public void fireCancellationListeners() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture.set(null);
    }

    public boolean set(T t) {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z2 = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.set(t);
        if (z2) {
            setCompletedNormally();
        }
        return z2;
    }

    public boolean setCancelled() {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z2 = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.cancelWithoutNotifyingCompleter(true);
        if (z2) {
            setCompletedNormally();
        }
        return z2;
    }

    public boolean setException(@NonNull Throwable th) {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z2 = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.setException(th);
        if (z2) {
            setCompletedNormally();
        }
        return z2;
    }
}
