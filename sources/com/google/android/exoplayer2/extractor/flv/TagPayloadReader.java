package com.google.android.exoplayer2.extractor.flv;

import b.i.a.c.f3.x;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TagPayloadReader {
    public final w a;

    public TagPayloadReader(w wVar) {
        this.a = wVar;
    }

    public final boolean a(x xVar, long j) throws ParserException {
        return b(xVar) && c(xVar, j);
    }

    public abstract boolean b(x xVar) throws ParserException;

    public abstract boolean c(x xVar, long j) throws ParserException;
}
