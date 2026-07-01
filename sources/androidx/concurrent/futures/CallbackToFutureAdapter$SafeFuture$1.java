package androidx.concurrent.futures;

import b.d.b.a.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class CallbackToFutureAdapter$SafeFuture$1<T> extends AbstractResolvableFuture<T> {
    public final /* synthetic */ CallbackToFutureAdapter$SafeFuture this$0;

    public CallbackToFutureAdapter$SafeFuture$1(CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture) {
        this.this$0 = callbackToFutureAdapter$SafeFuture;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public String pendingToString() {
        CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = this.this$0.completerWeakReference.get();
        if (callbackToFutureAdapter$Completer == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        StringBuilder sbU = a.U("tag=[");
        sbU.append(callbackToFutureAdapter$Completer.tag);
        sbU.append("]");
        return sbU.toString();
    }
}
