package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAudioSink$a extends Thread {
    public final /* synthetic */ AudioTrack j;
    public final /* synthetic */ DefaultAudioSink k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultAudioSink$a(DefaultAudioSink defaultAudioSink, String str, AudioTrack audioTrack) {
        super(str);
        this.k = defaultAudioSink;
        this.j = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.j.flush();
            this.j.release();
        } finally {
            this.k.h.open();
        }
    }
}
