package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public final class NotFoundException extends ReaderException {
    public static final NotFoundException l;

    static {
        NotFoundException notFoundException = new NotFoundException();
        l = notFoundException;
        notFoundException.setStackTrace(ReaderException.k);
    }

    private NotFoundException() {
    }
}
