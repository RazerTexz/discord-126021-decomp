package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: l */
    public static final FormatException f21664l;

    static {
        FormatException formatException = new FormatException();
        f21664l = formatException;
        formatException.setStackTrace(ReaderException.f21667k);
    }

    private FormatException() {
    }

    /* JADX INFO: renamed from: a */
    public static FormatException m9260a() {
        return ReaderException.f21666j ? new FormatException() : f21664l;
    }

    public FormatException(Throwable th) {
        super(th);
    }
}
