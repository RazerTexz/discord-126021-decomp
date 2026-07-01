package com.google.android.exoplayer2.audio;

import b.i.a.c.t2.c0;
import b.i.a.c.t2.d0;
import b.i.a.c.t2.e0;
import b.i.a.c.x1;
import com.discord.api.permission.Permission;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAudioSink$d implements DefaultAudioSink$b {
    public final AudioProcessor[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f2921b;
    public final e0 c;

    public DefaultAudioSink$d(AudioProcessor... audioProcessorArr) {
        c0 c0Var = new c0();
        e0 e0Var = new e0();
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
        this.a = audioProcessorArr2;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
        this.f2921b = c0Var;
        this.c = e0Var;
        audioProcessorArr2[audioProcessorArr.length] = c0Var;
        audioProcessorArr2[audioProcessorArr.length + 1] = e0Var;
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
    public x1 a(x1 x1Var) {
        e0 e0Var = this.c;
        float f = x1Var.k;
        if (e0Var.c != f) {
            e0Var.c = f;
            e0Var.i = true;
        }
        float f2 = x1Var.l;
        if (e0Var.d != f2) {
            e0Var.d = f2;
            e0Var.i = true;
        }
        return x1Var;
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
    public long b(long j) {
        e0 e0Var = this.c;
        if (e0Var.o < Permission.VIEW_CHANNEL) {
            return (long) (((double) e0Var.c) * j);
        }
        long j2 = e0Var.n;
        d0 d0Var = e0Var.j;
        Objects.requireNonNull(d0Var);
        long j3 = j2 - ((long) ((d0Var.k * d0Var.f1118b) * 2));
        int i = e0Var.h.f2914b;
        int i2 = e0Var.g.f2914b;
        return i == i2 ? b.i.a.c.f3.e0.F(j, j3, e0Var.o) : b.i.a.c.f3.e0.F(j, j3 * ((long) i), e0Var.o * ((long) i2));
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
    public long c() {
        return this.f2921b.t;
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink$b
    public boolean d(boolean z2) {
        this.f2921b.m = z2;
        return z2;
    }
}
