package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: j */
    public static final boolean f21666j;

    /* JADX INFO: renamed from: k */
    public static final StackTraceElement[] f21667k;

    static {
        f21666j = System.getProperty("surefire.test.class.path") != null;
        f21667k = new StackTraceElement[0];
    }

    public ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public ReaderException(Throwable th) {
        super(th);
    }
}
