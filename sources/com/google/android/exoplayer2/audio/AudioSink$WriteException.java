package com.google.android.exoplayer2.audio;

import b.d.b.a.a;
import b.i.a.c.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioSink$WriteException extends Exception {
    public final int errorCode;
    public final j1 format;
    public final boolean isRecoverable;

    public AudioSink$WriteException(int i, j1 j1Var, boolean z2) {
        super(a.g(36, "AudioTrack write failed: ", i));
        this.isRecoverable = z2;
        this.errorCode = i;
        this.format = j1Var;
    }
}
