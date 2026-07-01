package com.google.android.exoplayer2;

import b.i.a.c.o2;

/* JADX INFO: loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final o2 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(o2 o2Var, int i, long j) {
        this.timeline = o2Var;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
