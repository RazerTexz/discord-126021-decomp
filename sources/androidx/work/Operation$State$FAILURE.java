package androidx.work;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class Operation$State$FAILURE extends Operation$State {
    private final Throwable mThrowable;

    public Operation$State$FAILURE(@NonNull Throwable th) {
        this.mThrowable = th;
    }

    @NonNull
    public Throwable getThrowable() {
        return this.mThrowable;
    }

    @NonNull
    public String toString() {
        return String.format("FAILURE (%s)", this.mThrowable.getMessage());
    }
}
