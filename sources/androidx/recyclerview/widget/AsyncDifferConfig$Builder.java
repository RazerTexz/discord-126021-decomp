package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncDifferConfig$Builder<T> {
    private static Executor sDiffExecutor;
    private static final Object sExecutorLock = new Object();
    private Executor mBackgroundThreadExecutor;
    private final DiffUtil$ItemCallback<T> mDiffCallback;

    @Nullable
    private Executor mMainThreadExecutor;

    public AsyncDifferConfig$Builder(@NonNull DiffUtil$ItemCallback<T> diffUtil$ItemCallback) {
        this.mDiffCallback = diffUtil$ItemCallback;
    }

    @NonNull
    public AsyncDifferConfig<T> build() {
        if (this.mBackgroundThreadExecutor == null) {
            synchronized (sExecutorLock) {
                if (sDiffExecutor == null) {
                    sDiffExecutor = Executors.newFixedThreadPool(2);
                }
            }
            this.mBackgroundThreadExecutor = sDiffExecutor;
        }
        return new AsyncDifferConfig<>(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
    }

    @NonNull
    public AsyncDifferConfig$Builder<T> setBackgroundThreadExecutor(Executor executor) {
        this.mBackgroundThreadExecutor = executor;
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public AsyncDifferConfig$Builder<T> setMainThreadExecutor(Executor executor) {
        this.mMainThreadExecutor = executor;
        return this;
    }
}
