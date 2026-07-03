package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3122w f19856a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(InterfaceC3122w interfaceC3122w) {
        this.f19856a = interfaceC3122w;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8837a(C2757x c2757x, long j) throws ParserException {
        return mo3657b(c2757x) && mo3658c(c2757x, j);
    }

    /* JADX INFO: renamed from: b */
    public abstract boolean mo3657b(C2757x c2757x) throws ParserException;

    /* JADX INFO: renamed from: c */
    public abstract boolean mo3658c(C2757x c2757x, long j) throws ParserException;
}
