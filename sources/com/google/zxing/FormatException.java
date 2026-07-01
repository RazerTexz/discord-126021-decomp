package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public final class FormatException extends ReaderException {
    public static final FormatException l;

    static {
        FormatException formatException = new FormatException();
        l = formatException;
        formatException.setStackTrace(ReaderException.k);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.j ? new FormatException() : l;
    }

    public FormatException(Throwable th) {
        super(th);
    }
}
