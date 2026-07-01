package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter$FutureGarbageCollectedException extends Throwable {
    public CallbackToFutureAdapter$FutureGarbageCollectedException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
