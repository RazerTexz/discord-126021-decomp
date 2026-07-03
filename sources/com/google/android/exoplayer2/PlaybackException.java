package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: loaded from: classes3.dex */
public class PlaybackException extends Exception implements InterfaceC2963w0 {
    public final int errorCode;
    public final long timestampMs;

    public PlaybackException(@Nullable String str, @Nullable Throwable th, int i, long j) {
        super(str, th);
        this.errorCode = i;
        this.timestampMs = j;
    }
}
