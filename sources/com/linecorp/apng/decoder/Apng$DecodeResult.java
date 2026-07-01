package com.linecorp.apng.decoder;

import d0.z.d.m;

/* JADX INFO: compiled from: Apng.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Apng$DecodeResult {
    private long allFrameByteCount;
    private int frameCount;
    private int[] frameDurations = new int[0];
    private int height;
    private int loopCount;
    private int width;

    public final long getAllFrameByteCount() {
        return this.allFrameByteCount;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final int[] getFrameDurations() {
        return this.frameDurations;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setAllFrameByteCount(long j) {
        this.allFrameByteCount = j;
    }

    public final void setFrameCount(int i) {
        this.frameCount = i;
    }

    public final void setFrameDurations(int[] iArr) {
        m.checkNotNullParameter(iArr, "<set-?>");
        this.frameDurations = iArr;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setLoopCount(int i) {
        this.loopCount = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
