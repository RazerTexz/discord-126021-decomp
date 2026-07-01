package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import b.c.a.a0.d;
import b.i.a.c.f2$a;
import b.i.a.c.t2.z$b;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAudioSink$h$a extends AudioTrack$StreamEventCallback {
    public final /* synthetic */ DefaultAudioSink$h a;

    public DefaultAudioSink$h$a(DefaultAudioSink$h defaultAudioSink$h, DefaultAudioSink defaultAudioSink) {
        this.a = defaultAudioSink$h;
    }

    @Override // android.media.AudioTrack$StreamEventCallback
    public void onDataRequest(AudioTrack audioTrack, int i) {
        f2$a f2_a;
        d.D(audioTrack == this.a.c.f2916s);
        DefaultAudioSink defaultAudioSink = this.a.c;
        AudioSink$a audioSink$a = defaultAudioSink.p;
        if (audioSink$a == null || !defaultAudioSink.S || (f2_a = ((z$b) audioSink$a).a.X0) == null) {
            return;
        }
        f2_a.a();
    }

    @Override // android.media.AudioTrack$StreamEventCallback
    public void onTearDown(AudioTrack audioTrack) {
        f2$a f2_a;
        d.D(audioTrack == this.a.c.f2916s);
        DefaultAudioSink defaultAudioSink = this.a.c;
        AudioSink$a audioSink$a = defaultAudioSink.p;
        if (audioSink$a == null || !defaultAudioSink.S || (f2_a = ((z$b) audioSink$a).a.X0) == null) {
            return;
        }
        f2_a.a();
    }
}
