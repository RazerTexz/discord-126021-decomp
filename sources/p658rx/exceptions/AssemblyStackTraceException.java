package p658rx.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
