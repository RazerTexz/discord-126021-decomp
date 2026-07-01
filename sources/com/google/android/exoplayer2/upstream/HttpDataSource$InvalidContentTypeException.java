package com.google.android.exoplayer2.upstream;

import b.i.a.c.e3.n;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpDataSource$InvalidContentTypeException extends HttpDataSource$HttpDataSourceException {
    public final String contentType;

    /* JADX WARN: Illegal instructions before constructor call */
    public HttpDataSource$InvalidContentTypeException(String str, n nVar) {
        String strValueOf = String.valueOf(str);
        super(strValueOf.length() != 0 ? "Invalid content type: ".concat(strValueOf) : new String("Invalid content type: "), nVar, 2003, 1);
        this.contentType = str;
    }
}
