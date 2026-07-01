package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListenableWorker$Result {
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public ListenableWorker$Result() {
    }

    @NonNull
    public static ListenableWorker$Result failure() {
        return new ListenableWorker$Result$Failure();
    }

    @NonNull
    public static ListenableWorker$Result retry() {
        return new ListenableWorker$Result$Retry();
    }

    @NonNull
    public static ListenableWorker$Result success() {
        return new ListenableWorker$Result$Success();
    }

    @NonNull
    public static ListenableWorker$Result failure(@NonNull Data data) {
        return new ListenableWorker$Result$Failure(data);
    }

    @NonNull
    public static ListenableWorker$Result success(@NonNull Data data) {
        return new ListenableWorker$Result$Success(data);
    }
}
