package com.google.android.exoplayer2.audio;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioSink$UnexpectedDiscontinuityException extends Exception {
    public final long actualPresentationTimeUs;
    public final long expectedPresentationTimeUs;

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioSink$UnexpectedDiscontinuityException(long j, long j2) {
        StringBuilder sbR = a.R(103, "Unexpected audio track timestamp discontinuity: expected ", j2, ", got ");
        sbR.append(j);
        super(sbR.toString());
        this.actualPresentationTimeUs = j;
        this.expectedPresentationTimeUs = j2;
    }
}
