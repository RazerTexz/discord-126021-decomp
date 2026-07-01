package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioAttributes$Builder;
import android.media.AudioTrack;
import android.media.AudioTrack$Builder;
import androidx.annotation.RequiresApi;
import b.c.a.a0.d;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.t2.o;
import com.discord.restapi.RestAPIAbortCodes;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink$c {
    public final j1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2920b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final AudioProcessor[] i;

    public DefaultAudioSink$c(j1 j1Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, AudioProcessor[] audioProcessorArr) {
        int iRound;
        this.a = j1Var;
        this.f2920b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.i = audioProcessorArr;
        if (i7 != 0) {
            iRound = i7;
        } else {
            if (i2 == 0) {
                float f = z2 ? 8.0f : 1.0f;
                int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
                d.D(minBufferSize != -2);
                long j = i4;
                int iH = e0.h(minBufferSize * 4, ((int) ((250000 * j) / 1000000)) * i3, Math.max(minBufferSize, ((int) ((j * 750000) / 1000000)) * i3));
                iRound = f != 1.0f ? Math.round(iH * f) : iH;
            } else if (i2 == 1) {
                iRound = e(50000000L);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException();
                }
                iRound = e(250000L);
            }
        }
        this.h = iRound;
    }

    @RequiresApi(21)
    public static AudioAttributes d(o oVar, boolean z2) {
        return z2 ? new AudioAttributes$Builder().setContentType(3).setFlags(16).setUsage(1).build() : oVar.a();
    }

    public AudioTrack a(boolean z2, o oVar, int i) throws AudioSink$InitializationException {
        try {
            AudioTrack audioTrackB = b(z2, oVar, i);
            int state = audioTrackB.getState();
            if (state == 1) {
                return audioTrackB;
            }
            try {
                audioTrackB.release();
            } catch (Exception unused) {
            }
            throw new AudioSink$InitializationException(state, this.e, this.f, this.h, this.a, f(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new AudioSink$InitializationException(0, this.e, this.f, this.h, this.a, f(), e);
        }
    }

    public final AudioTrack b(boolean z2, o oVar, int i) {
        int i2 = e0.a;
        if (i2 >= 29) {
            return new AudioTrack$Builder().setAudioAttributes(d(oVar, z2)).setAudioFormat(DefaultAudioSink.y(this.e, this.f, this.g)).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
        }
        if (i2 >= 21) {
            return new AudioTrack(d(oVar, z2), DefaultAudioSink.y(this.e, this.f, this.g), this.h, 1, i);
        }
        int iT = e0.t(oVar.m);
        return i == 0 ? new AudioTrack(iT, this.e, this.f, this.g, this.h, 1) : new AudioTrack(iT, this.e, this.f, this.g, this.h, 1, i);
    }

    public long c(long j) {
        return (j * 1000000) / ((long) this.e);
    }

    public final int e(long j) {
        int i;
        int i2 = this.g;
        switch (i2) {
            case 5:
                i = RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED;
                break;
            case 6:
            case 18:
                i = 768000;
                break;
            case 7:
                i = 192000;
                break;
            case 8:
                i = 2250000;
                break;
            case 9:
                i = 40000;
                break;
            case 10:
                i = 100000;
                break;
            case 11:
                i = 16000;
                break;
            case 12:
                i = 7000;
                break;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                i = 3062500;
                break;
            case 15:
                i = 8000;
                break;
            case 16:
                i = 256000;
                break;
            case 17:
                i = 336000;
                break;
        }
        if (i2 == 5) {
            i *= 2;
        }
        return (int) ((j * ((long) i)) / 1000000);
    }

    public boolean f() {
        return this.c == 1;
    }
}
