package com.google.android.exoplayer2.extractor.flv;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.ParserException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TagPayloadReader {
    public final TrackOutput2 a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput2 trackOutput2) {
        this.a = trackOutput2;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j) throws ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j);
    }

    public abstract boolean b(ParsableByteArray parsableByteArray) throws ParserException;

    public abstract boolean c(ParsableByteArray parsableByteArray, long j) throws ParserException;
}
