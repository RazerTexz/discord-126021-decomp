package com.google.android.exoplayer2.audio;

import b.i.a.c.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioSink$ConfigurationException extends Exception {
    public final j1 format;

    public AudioSink$ConfigurationException(Throwable th, j1 j1Var) {
        super(th);
        this.format = j1Var;
    }

    public AudioSink$ConfigurationException(String str, j1 j1Var) {
        super(str);
        this.format = j1Var;
    }
}
