package com.google.android.exoplayer2.upstream;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader$UnexpectedLoaderException extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public Loader$UnexpectedLoaderException(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String message = th.getMessage();
        super(a.l(a.b(message, simpleName.length() + 13), "Unexpected ", simpleName, ": ", message), th);
    }
}
