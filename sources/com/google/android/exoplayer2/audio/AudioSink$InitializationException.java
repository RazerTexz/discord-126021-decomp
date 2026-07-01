package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import b.i.a.c.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioSink$InitializationException extends Exception {
    public final int audioTrackState;
    public final j1 format;
    public final boolean isRecoverable;

    public AudioSink$InitializationException(int i, int i2, int i3, int i4, j1 j1Var, boolean z2, @Nullable Exception exc) {
        String str = z2 ? " (recoverable)" : "";
        StringBuilder sb = new StringBuilder(str.length() + 80);
        sb.append("AudioTrack init failed ");
        sb.append(i);
        sb.append(" ");
        sb.append("Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(")");
        sb.append(str);
        super(sb.toString(), exc);
        this.audioTrackState = i;
        this.isRecoverable = z2;
        this.format = j1Var;
    }
}
