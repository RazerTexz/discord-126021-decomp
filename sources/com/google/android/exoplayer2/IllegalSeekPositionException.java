package com.google.android.exoplayer2;

import p007b.p225i.p226a.p242c.AbstractC2832o2;

/* JADX INFO: loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final AbstractC2832o2 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(AbstractC2832o2 abstractC2832o2, int i, long j) {
        this.timeline = abstractC2832o2;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
