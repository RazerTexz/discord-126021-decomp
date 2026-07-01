package com.google.android.exoplayer2.upstream;

import b.i.a.c.e3.n;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpDataSource$CleartextNotPermittedException extends HttpDataSource$HttpDataSourceException {
    public HttpDataSource$CleartextNotPermittedException(IOException iOException, n nVar) {
        super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, nVar, 2007, 1);
    }
}
