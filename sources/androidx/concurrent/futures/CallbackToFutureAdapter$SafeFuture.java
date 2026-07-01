package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import b.i.b.d.a.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter$SafeFuture<T> implements a<T> {
    public final WeakReference<CallbackToFutureAdapter$Completer<T>> completerWeakReference;
    private final AbstractResolvableFuture<T> delegate = new CallbackToFutureAdapter$SafeFuture$1(this);

    public CallbackToFutureAdapter$SafeFuture(CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) {
        this.completerWeakReference = new WeakReference<>(callbackToFutureAdapter$Completer);
    }

    @Override // b.i.b.d.a.a
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = this.completerWeakReference.get();
        boolean zCancel = this.delegate.cancel(z2);
        if (zCancel && callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.fireCancellationListeners();
        }
        return zCancel;
    }

    public boolean cancelWithoutNotifyingCompleter(boolean z2) {
        return this.delegate.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.delegate.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.delegate.isDone();
    }

    public boolean set(T t) {
        return this.delegate.set(t);
    }

    public boolean setException(Throwable th) {
        return this.delegate.setException(th);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.get(j, timeUnit);
    }
}
