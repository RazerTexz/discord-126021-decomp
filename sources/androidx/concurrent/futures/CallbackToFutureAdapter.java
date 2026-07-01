package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter {
    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> a<T> getFuture(@NonNull CallbackToFutureAdapter$Resolver<T> callbackToFutureAdapter$Resolver) {
        CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer<>();
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture<>(callbackToFutureAdapter$Completer);
        callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
        callbackToFutureAdapter$Completer.tag = callbackToFutureAdapter$Resolver.getClass();
        try {
            Object objAttachCompleter = callbackToFutureAdapter$Resolver.attachCompleter(callbackToFutureAdapter$Completer);
            if (objAttachCompleter != null) {
                callbackToFutureAdapter$Completer.tag = objAttachCompleter;
            }
        } catch (Exception e) {
            callbackToFutureAdapter$SafeFuture.setException(e);
        }
        return callbackToFutureAdapter$SafeFuture;
    }
}
