package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CallbackToFutureAdapter$Resolver<T> {
    @Nullable
    Object attachCompleter(@NonNull CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) throws Exception;
}
