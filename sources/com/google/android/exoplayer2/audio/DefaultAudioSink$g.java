package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import b.d.b.a.a;
import b.i.a.c.t2.h;
import b.i.a.c.t2.i;
import b.i.a.c.t2.r$a;
import b.i.a.c.t2.t$a;
import b.i.a.c.t2.z$b;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink$g implements t$a {
    public final /* synthetic */ DefaultAudioSink a;

    public DefaultAudioSink$g(DefaultAudioSink defaultAudioSink, DefaultAudioSink$a defaultAudioSink$a) {
        this.a = defaultAudioSink;
    }

    @Override // b.i.a.c.t2.t$a
    public void a(long j) {
        r$a r_a;
        Handler handler;
        AudioSink$a audioSink$a = this.a.p;
        if (audioSink$a == null || (handler = (r_a = ((z$b) audioSink$a).a.O0).a) == null) {
            return;
        }
        handler.post(new h(r_a, j));
    }

    @Override // b.i.a.c.t2.t$a
    public void b(int i, long j) {
        if (this.a.p != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            DefaultAudioSink defaultAudioSink = this.a;
            long j2 = jElapsedRealtime - defaultAudioSink.X;
            r$a r_a = ((z$b) defaultAudioSink.p).a.O0;
            Handler handler = r_a.a;
            if (handler != null) {
                handler.post(new i(r_a, i, j, j2));
            }
        }
    }

    @Override // b.i.a.c.t2.t$a
    public void c(long j) {
        StringBuilder sb = new StringBuilder(61);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        Log.w("DefaultAudioSink", sb.toString());
    }

    @Override // b.i.a.c.t2.t$a
    public void d(long j, long j2, long j3, long j4) {
        DefaultAudioSink defaultAudioSink = this.a;
        DefaultAudioSink$c defaultAudioSink$c = defaultAudioSink.r;
        long j5 = defaultAudioSink$c.c == 0 ? defaultAudioSink.f2919z / ((long) defaultAudioSink$c.f2920b) : defaultAudioSink.A;
        long jE = defaultAudioSink.E();
        StringBuilder sbR = a.R(Opcodes.INVOKEVIRTUAL, "Spurious audio timestamp (frame position mismatch): ", j, ", ");
        sbR.append(j2);
        sbR.append(", ");
        sbR.append(j3);
        sbR.append(", ");
        sbR.append(j4);
        sbR.append(", ");
        sbR.append(j5);
        sbR.append(", ");
        sbR.append(jE);
        Log.w("DefaultAudioSink", sbR.toString());
    }

    @Override // b.i.a.c.t2.t$a
    public void e(long j, long j2, long j3, long j4) {
        DefaultAudioSink defaultAudioSink = this.a;
        DefaultAudioSink$c defaultAudioSink$c = defaultAudioSink.r;
        long j5 = defaultAudioSink$c.c == 0 ? defaultAudioSink.f2919z / ((long) defaultAudioSink$c.f2920b) : defaultAudioSink.A;
        long jE = defaultAudioSink.E();
        StringBuilder sbR = a.R(180, "Spurious audio timestamp (system clock mismatch): ", j, ", ");
        sbR.append(j2);
        sbR.append(", ");
        sbR.append(j3);
        sbR.append(", ");
        sbR.append(j4);
        sbR.append(", ");
        sbR.append(j5);
        sbR.append(", ");
        sbR.append(jE);
        Log.w("DefaultAudioSink", sbR.toString());
    }
}
