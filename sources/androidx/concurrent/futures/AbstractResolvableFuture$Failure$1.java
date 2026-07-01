package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
public class AbstractResolvableFuture$Failure$1 extends Throwable {
    public AbstractResolvableFuture$Failure$1(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
